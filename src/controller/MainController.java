package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import object.Country;
import object.DeadCountry;
import object.Game;
import object.InfectedCountry;
import object.NormalCountry;
import object.Research;
import ui.GameStart;
public class MainController {

    //Initialize variable
    public static JFrame frame;
//    static Game game;
    private static Game game;

    public static void main(String[] args) {
        //Create game object
        game = Game.getInstance();


        //Schedule a job for the event dispatch thread:
        //creating and showing config application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                //Create and set up the window.
                frame = new JFrame("Virus Outbreak");
                int height = 540;
                int width = 960;

                // set the jframe height and width
                frame.setPreferredSize(new Dimension(width, height));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);

                //Initialize game objects
                game.initGameObjects();

                //Create game start UI
                JPanel panel = GameStart.createAndShowGUI(game);


                //Add content to the window
                frame.add(panel, BorderLayout.CENTER);

                //Display the window.
                frame.pack();
                frame.setVisible(true);

            }
        });

    }

    //The game logic
    public static void gameStart() {
        game.getGameRunning().set(true);


        //Use thread to run so the loop won't block the UI
        game.gameThread = new Thread(new Runnable() {
            @Override
            public void run() {

                //Delay a bit so the UI is initialized
                try {
                    Thread.sleep(1000);
                    game.setLabel(game.mainTitleLabel, game.getVirusName() + " has started to spread in " + game.getBornCountry());

                    //Infect the first country
                    game.updateMainCountryVal(game.getBornCountry(), "Infect", 1);
                } catch (Exception e) {
                }


                //Loop for each day
                while (!game.isEndGame()) {

                    //Check if game is paused/resumed
                    checkGameResumeOrPause();

                    //Sleep for 1 second before going to next day
                    try {
                        Thread.sleep(game.getMsBetweenDay());
                    } catch (InterruptedException ex) {
                    }

                    //Store current infected & death population
                    long currentInfect = game.getTotalInfectedPopulation();
                    long currentDeath = game.getTotalDeathPopulation();


                    //Update the current date in main panel
                    game.setLabel(game.mainCurrentDateLabel, "Current Date: " + game.getCurrentDate());

                    //Killing / Infecting logic ...
                    for (Country c : game.getCountries()) {
                        if (c.getInfectedPopulation() > 0) {
                            infectPeople(c);
                            killPeople(c);
                        }
                    }

                    //Pick a random country to infect
                    pickCountryToInfect();

                    //Update corresponding UI with new data
                    daySummary();

                    //Increment 1 day
                    game.addDayToCalendar(1);

                    checkEndGame();
                }
            }
        });
        game.gameThread.start();

    }

    public static void checkGameResumeOrPause() {
        if (!game.getGameRunning().get()) {
            try {
                System.out.println("Game Paused");
                Thread.sleep(999999);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Game Resumed");
            }
        }
    }

    public static void infectPeople(Country c) {
        //If there is still uninfected people
        if (!(c.getState() instanceof InfectedCountry)) {
            //Infect country with at least 1 infected people
            c.addInfectedPopulation(game.getVirus().getInfectPerDay(c, game.getDay()));
            game.updateMainCountryVal(c.getName(), "Infect", game.getVirus().getInfectPerDay(c, game.getDay()));
        }
    }

    public static void killPeople(Country c) {
        //If there is still people alive
        if (!(c.getState() instanceof DeadCountry)) {

            //Killing people in that country if infected > 0 and deathPopulation != totalPopulation
            c.addDeathPopulation(game.getVirus().getKillPerDay(c));
            game.updateMainCountryVal(c.getName(), "Death", game.getVirus().getKillPerDay(c));
        } else {

            game.updateMainCountryVal(c.getName(), "Death", game.getVirus().getKillPerDay(c));
        }
    }

    public static void pickCountryToInfect() {
        //Pick a random country to infect 1 people
        int sizeOfUnifectCountries = game.getUninfectedCountries().size();
        if (sizeOfUnifectCountries > 0) {
            Random r = new Random();
            int index = 0;
            if (sizeOfUnifectCountries != 1) {
                index = r.nextInt(game.getUninfectedCountries().size() - 1);
            }
            double chance = Math.random();
            if (chance < game.infectOtherCountryProbability()) {
                Country c = game.getUninfectedCountries().get(index);
                c.addInfectedPopulation(1);
                game.setLabel(game.mainTitleLabel, game.getVirusName() + " has started to spread in " + c.getName());
            }
        }
    }

    public static void daySummary() {
        //Summary for today
        game.setLabel(game.totalInfectLabel, "World Total Infect         : " + game.getTotalInfectedPopulation());
        game.setLabel(game.totalDeathLabel, "World Total Death         : " + game.getTotalDeathPopulation());

        int upgradePointsGained = game.upgradePointGainPerDay();
        game.calUpgradePoint(0, upgradePointsGained);
        game.setLabel(game.evoPointLabel, "Evo Point: " + game.getUpgradePoint());
        game.makeInfectGainPointHarder();

        //Check again if half population is dead
        if (!game.isHalfPopulationDead()) {
            game.setHalfPopulationDead(game.checkHalfPopulationDead());
            if (game.isHalfPopulationDead()) {
                game.setLabel(game.mainTitleLabel, game.getVirusName() + " has killed 50% of people in this world");
            }
        }

        //Pick a country to research when necessary
        if (game.shouldResearchStart()) {
            pickCountryToResearch();
            researching();
        }


        //Display this message once when the virus infected 50% population
        if (!game.isHalfPopulationInfected()) {
            game.setHalfPopulationInfected(game.checkHalfPopulationInfected());
            if (game.isHalfPopulationInfected()) {
                game.setLabel(game.mainTitleLabel, game.getVirusName() + " has infected 50% of the people in this world");
            }
        }

        //Update country info displayed on the right
        try {
            if (!game.getSelectedRowCountryName().equals("")) {
                Country countryInfo = game.getCountryByName(game.getSelectedRowCountryName());
                game.setLabel(game.totalCountryPopLabel, "Total Population in " + countryInfo.getName() + "       : " + countryInfo.getPopulation());
                game.setLabel(game.totalInfectedLabel, "Infected Population in " + countryInfo.getName() + " : " + countryInfo.getInfectedPopulation());
                game.setLabel(game.totalDeathPopLabel, "Death Population in " + countryInfo.getName() + "     : " + countryInfo.getDeathPopulation());
            }
        } catch (Exception e) {
            System.out.println("Country name not found");
        }
    }

    public static void checkEndGame() {
        //Check if the game has ended
        if (game.getTotalDeathPopulation() >= game.getWorldTotalPopulation()) {
            game.setLabel(game.mainTitleLabel, game.getVirusName() + " has takeover the world! Congratulations!");
            game.setEndGame(true);
        } else if (game.getDay() > game.getTotalNumberOfDays()) {
            game.setLabel(game.mainTitleLabel, "Game over ... " + game.getVirusName() + " has failed to kill all population within " + game.getTotalNumberOfDays() + " days");
            game.setEndGame(true);
        }
    }

    public static void pickCountryToResearch() {
        if (game.getResearch().getHoldByCountry() == null) {
            game.getResearch().setHoldByCountry(game.getHighestInfectCountry());
            game.setLabel(game.mainTitleLabel, game.getResearch().getHoldByCountry().getName() + " has started a research!");
        }
        if (game.getResearch().getHoldByCountry().getState() instanceof DeadCountry) {
            game.getResearch().setHoldByCountry(game.getHighestInfectCountry());
            if (game.getResearch().getHoldByCountry() != null) {
                game.setLabel(game.mainTitleLabel, game.getResearch().getHoldByCountry().getName() + " has started a new research!");
            }
        }
    }

    public static void researching() {
        if (game.getResearch().getHoldByCountry() != null) {

            Research tmpResearch = game.getResearch();

            //Calculate research to increase per day
            double researchPoint = tmpResearch.getHoldByCountry().getMedicalSystem() - decreaseCountryResearchRate(tmpResearch.getHoldByCountry());

            //Add research point
            tmpResearch.addResearchPerDay(researchPoint);

            //Increase the whole research percentage by one if research per day exceeds 1
            tmpResearch.addCurrentResearch(tmpResearch.getResearchPerDay());
            game.setLabel(game.researchLabel, "Research: " + tmpResearch.getCurrentResearch() + "%");

            if (tmpResearch.getCurrentResearch() >= 100) {
                game.setLabel(game.mainTitleLabel, "Game over :( " + "WHO has found a cure.");
                game.setEndGame(true);
            }
        }
    }

    //Decrease rate if there are more and more dead people in that country
    public static double decreaseCountryResearchRate(Country c) {
        double decreaseRate = c.getDeathPopulation() / c.getPopulation();
        if (decreaseRate > c.getMedicalSystem() * 0.5) {
            decreaseRate = c.getMedicalSystem() * 0.5;
        }
        return decreaseRate;
    }

    //Print
    public static void print(Object o) {
        System.out.println(o);
    }


}
