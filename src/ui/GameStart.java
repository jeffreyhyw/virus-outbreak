package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.MainController;
import object.Game;

public class GameStart {
    private static JPanel mainPanel = new JPanel();

    public static Boolean nameValid = false; 
    public static Boolean countryValid = false; 
    public static Game game;

    public static JPanel createAndShowGUI(Game gm) {
    	game = gm;
        buildUI();
        return mainPanel;
    }

    private static void buildUI() {

        JPanel gameStartPanel = new JPanel();
        gameStartPanel.setLayout(new BoxLayout(gameStartPanel, BoxLayout.PAGE_AXIS));


        String[] labelName = {"VIRUS", "Virus Name", "---", "Born Country", "---", "Start"};

        int testNumber = 10;

        String[] testData = new String[game.countries.size()+1];
        testData[0] = "--Select--";
        for (int i = 1; i <= game.countries.size(); i++) {
        	testData[i] = game.countries.get(i-1).getName();
        }
        

        for (int i = 0; i < 6; i++) {
            JPanel rowPanel = new JPanel();
            if (i == 0 || i == 1 || i == 3) {
                JLabel jlabel = new JLabel(labelName[i]);
                if (i == 0) {
                    jlabel.setFont(new Font("sans serif", Font.BOLD, 16));
                }
                rowPanel.add(jlabel);
            } else if (i == 2) {
                JTextField jTextField = new JTextField(20);
                rowPanel.add(jTextField);
            } else if (i == 4) {
                final JComboBox<String> cb = new JComboBox<>(testData);
                cb.setVisible(true);
                rowPanel.add(cb);
            } else {
                JButton jButton = new JButton(labelName[i]);
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Component gameStartComponent : gameStartPanel.getComponents()) {
                            Component rowComponent = ((JPanel) gameStartComponent).getComponent(0);
                        	
                            if (rowComponent.getClass().equals(JTextField.class)) {
                            	nameValid = checkTextFiled(rowComponent);
                            } else if (rowComponent.getClass().equals(JComboBox.class)) {
                                countryValid = checkComboBox(rowComponent);
                            }

                        }
                        
                        //Go to Main UI if valid
                        if(nameValid && countryValid) 
                        {
                        	
                        	EventQueue.invokeLater(new Runnable() {
            				    @Override
            				    public void run() {
            				    	MainController.frame.getContentPane().removeAll();
            						MainController.frame.getContentPane().add(Main.createAndShowGUI(game));
            						MainController.frame.revalidate();
            				    }
            				});
                        	
                        	//Start the game
                            MainController.gameStart();
                        }
                    }
                });
                rowPanel.add(jButton);
            }
            gameStartPanel.add(rowPanel);
            mainPanel.add(gameStartPanel);
        }
    }

    private static boolean checkTextFiled(Component rowComponent){
        JTextField tx = (JTextField) rowComponent;
        if (tx.getText().trim().isEmpty()) {
        	JOptionPane.showMessageDialog(null, 
                    "Please enter a name", 
                    "Invalid Input", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (tx.getText().length() > 15) {
        	JOptionPane.showMessageDialog(null, 
                    "Please enter a name within 15 characters", 
                    "Name is too long", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
        	game.setVirusName(tx.getText().replaceAll("[^a-zA-Z0-9 ]", "")); 
            return true;
        }
    }

    private static boolean checkComboBox(Component rowComponent){
        JComboBox jComboBox = (JComboBox) rowComponent;
        if (jComboBox.getSelectedIndex() == 0) {
        	JOptionPane.showMessageDialog(null, 
                    "Please select a country to born the virus", 
                    "Invalid Input", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else
        {
        	 game.setBornCountry(String.valueOf(jComboBox.getSelectedItem()));;
             return true;
        }
       
    }

}
