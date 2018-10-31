package ui;

import javax.swing.*;

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
		game.mainTitleLabel = new JLabel("Game Start!", SwingConstants.CENTER);
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

	}
	public static void BuildTotal(JPanel panel)
	{
		JPanel Total=new JPanel();
		Total.setLayout(new GridBagLayout());
		GridBagConstraints layout=new GridBagConstraints();
		
		
		game.totalInfectLabel = new JLabel("Total Infect: " + game.getTotalInfectedPopulation());
		game.totalDeathLabel = new JLabel("Total Death: " + game.getTotalDeathPopulation());
		
		layout.gridx=0;
		layout.gridy=0;
		layout.anchor=GridBagConstraints.SOUTHWEST;
		Total.add(game.totalInfectLabel,layout);
		
		layout.gridy=1;
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
		JLabel evopoint= new JLabel("Evo Point: 5", SwingConstants.CENTER);
		evopoint.setFont(new Font("sans serif", Font.BOLD, 16));
		evopoint.setBackground(Color.lightGray);
		evopoint.setOpaque(true);
		bottom.add(evopoint);
		JButton attritube=new JButton("Attritube");
		bottom.add(attritube);
		JButton exit=new JButton("Exit");
		bottom.add(exit);
		JLabel respoint= new JLabel("Research: 50%", SwingConstants.CENTER);
		respoint.setFont(new Font("sans serif", Font.BOLD, 16));
		respoint.setBackground(Color.lightGray);
		respoint.setOpaque(true);
		bottom.add(respoint);
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
