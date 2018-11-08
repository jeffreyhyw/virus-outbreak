package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

import controller.MainController;
import object.Game;

import java.awt.*;
import java.awt.event.*;

public class Main{
	static JFrame frame= new JFrame("MainUI");
	static String att[]= {"Country","Infect","Death"};

    public static Game game;


	public static void BuildTitle(JPanel panel)
	{
		GridBagConstraints layout=new GridBagConstraints();
		if(game.newGame)
		{
			game.mainTitleLabel = new JLabel("Game Start!", SwingConstants.CENTER);
			game.newGame = false;
		}
		game.mainTitleLabel.setFont(new Font("sans serif", Font.BOLD, 16));
		layout.gridx=0;
		layout.gridy=0;
		panel.add(game.mainTitleLabel,layout);
	}

	public static void BuildInfo(JPanel panel)
	{
		Main m = new Main();
		game.mainInfoTable = new JTable(game.mainTableModel);
		JScrollPane scrollPane = new JScrollPane(game.mainInfoTable);

		scrollPane.setPreferredSize(new Dimension(500, 300));
		GridBagConstraints layout=new GridBagConstraints();
		layout.gridx=0;
		layout.gridy=1;
		layout.gridheight=3;
		layout.insets = new Insets(0,0,0,20);
		panel.add(scrollPane,layout);
		
		//Row click listener
		game.mainInfoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				game.setSelectedRowCountryName(game.mainInfoTable.getValueAt(game.mainInfoTable.getSelectedRow(), 0).toString());
				
				game.totalCountryPopLabel.setVisible(true);
				game.totalInfectedLabel.setVisible(true);
				game.totalDeathPopLabel.setVisible(true);
			}
	    });

	}
	public static void BuildTotal(JPanel panel)
	{
		JPanel Total=new JPanel();
		Total.setLayout(new GridBagLayout());
		GridBagConstraints layout=new GridBagConstraints();
		
		game.totalCountryPopLabel = new JLabel("Total Population in Country: " + 0);
		game.totalInfectedLabel = new JLabel("Infected Population in Country: " + 0);
		game.totalDeathPopLabel = new JLabel("Death Population in Country: " + 0);
		
		JLabel space = new JLabel(" ");
		game.worldTotalPopulation = new  JLabel("World Total Population: " + game.getWorldTotalPopulation());
		game.totalInfectLabel = new JLabel("World Total Infect          : " + game.getTotalInfectedPopulation());
		game.totalDeathLabel = new JLabel("World Total Death         : " + game.getTotalDeathPopulation());
		
		layout.gridx=0;
		
		layout.gridy=0;
		layout.anchor=GridBagConstraints.SOUTHWEST;
		Total.add(game.totalCountryPopLabel,layout);
		game.totalCountryPopLabel.setVisible(false);

		layout.gridy=1;
		layout.anchor=GridBagConstraints.SOUTHWEST;
		Total.add(game.totalInfectedLabel,layout);
		game.totalInfectedLabel.setVisible(false);
		
		layout.gridy=2;
		layout.anchor=GridBagConstraints.SOUTHWEST;
		Total.add(game.totalDeathPopLabel,layout);
		game.totalDeathPopLabel.setVisible(false);
		
		layout.gridy=3;
		layout.anchor=GridBagConstraints.SOUTHWEST;
		Total.add(space,layout);
		
		layout.gridy=4;
		Total.add(game.worldTotalPopulation,layout);
		
		layout.gridy=5;
		Total.add(game.totalInfectLabel,layout);
		
		layout.gridy=6;
		Total.add(game.totalDeathLabel,layout);
		
		layout.gridx=1;
		layout.gridy=3;
		layout.insets = new Insets(0,0,10,0);
		panel.add(Total,layout);
	}

	public static void BuildDate(JPanel panel)
	{
		JPanel Date=new JPanel();
		Date.setLayout(new GridBagLayout());
		GridBagConstraints layout=new GridBagConstraints();

		game.mainCurrentDateLabel = new JLabel("Current Date: " + game.getCurrentDate());
		game.mainFinDateLabel= new JLabel("Finish Date: " + game.getEndGameDate());
		JLabel resDate= new JLabel("Research Date: Not Started");
		layout.gridx=0;
		layout.gridy=0;
		layout.anchor=GridBagConstraints.NORTHWEST;
		Date.add(game.mainCurrentDateLabel, layout);
		layout.gridy=1;
		Date.add(game.mainFinDateLabel, layout);
		layout.gridy=2;
		Date.add(resDate,layout);

		layout.gridy=2;
		layout.gridx=1;
		panel.add(Date,layout);
	}

	public static void BuildBottom(JPanel panel)
	{
		JPanel bottom=new JPanel();
		bottom.setLayout(new GridLayout(1,3));
		game.evoPointLabel = new JLabel("Evo Point: " + game.getUpgradePoint(), SwingConstants.CENTER);
		game.evoPointLabel.setFont(new Font("sans serif", Font.BOLD, 16));
		game.evoPointLabel.setBackground(Color.lightGray);
		game.evoPointLabel.setOpaque(true);
		bottom.add(game.evoPointLabel);
		JButton attritube=new JButton("Attritube");
		bottom.add(attritube);
		JButton exit=new JButton("Exit");
		bottom.add(exit);
		game.researchLabel = new JLabel("Research: "+ game.getResearch().getCurrentResearch() +"%", SwingConstants.CENTER);
		game.researchLabel.setFont(new Font("sans serif", Font.BOLD, 16));
		game.researchLabel.setBackground(Color.lightGray);
		game.researchLabel.setOpaque(true);
		bottom.add(game.researchLabel);
		GridBagConstraints layout=new GridBagConstraints();
		layout.gridx=0;
		layout.gridy=4;
		layout.gridwidth=2;
		layout.fill=GridBagConstraints.HORIZONTAL;
		
		//Exit the program when exit button clicked
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				System.exit(0);
			}
		});
					
		
		//Go to attribute page
		attritube.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Stop the game
				game.pauseGame();
				
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	MainController.frame.getContentPane().removeAll();
						MainController.frame.getContentPane().add(VirusConfigMainPanel.createAndShowGUI(game));

						MainController.frame.revalidate();
						
						
				    }
				});
			}
		});
		
		panel.add(bottom,layout);
	}

	public static JPanel createAndShowGUI(Game gm) {
		game = gm;

		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridBagLayout());
		BuildTitle(mainpanel);
		BuildInfo(mainpanel);
		BuildDate(mainpanel);
		BuildBottom(mainpanel);
		BuildTotal(mainpanel);

		return mainpanel;
	}
}
