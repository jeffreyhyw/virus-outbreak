package ui;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import controller.MainController;

import java.awt.*;
import java.awt.event.*;

public class Main{
	static JFrame frame= new JFrame("MainUI");
	static String att[]= {"Country","Infect","Death"};
	static Object info [][]=
		{
			{"China","200000","5000"},
			{"Africa","1000000","95000"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"},
			{"UK","20000","950"}
		};

	public static void BuildTitle(JPanel panel)
	{
		GridBagConstraints layout=new GridBagConstraints();
		JLabel title=new JLabel("This is a message", SwingConstants.CENTER);
		title.setFont(new Font("sans serif", Font.BOLD, 16));
		Dimension d = title.getPreferredSize();
		title.setPreferredSize(new Dimension(d.width+200,d.height));//<-----------
		layout.gridx=0;
		layout.gridy=0;
		panel.add(title,layout);
	}

	public static void BuildInfo(JPanel panel)
	{
		JTable table = new JTable(info, att);
		table.setEnabled(false);
		JTableHeader TableHeadertable=table.getTableHeader();
		TableHeadertable.setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
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
		int total[] = {0,0};
		for(int i=0;i<info.length;i++)
		{
			total[0]+=Integer.parseInt((String) info[i][1]);
			total[1]+=Integer.parseInt((String) info[i][2]);
		}

		JLabel TotalInfect = new JLabel("Total Infect: " + Integer.toString(total[0]));
		JLabel TotalDeath = new JLabel("Total Death: " + Integer.toString(total[1]));
		layout.gridx=0;
		layout.gridy=0;
		layout.anchor=GridBagConstraints.SOUTHWEST;
		Total.add(TotalInfect,layout);
		layout.gridy=1;
		Total.add(TotalDeath,layout);
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
		JLabel finDate= new JLabel("Finish Date: 1/1/2020");
		JLabel resDate= new JLabel("Research Date: 15/10/2019");
		layout.gridx=0;
		layout.gridy=0;
		layout.anchor=GridBagConstraints.NORTHWEST;
		Date.add(finDate,layout);
		layout.gridy=1;
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
			}
		});
					
		
		//Go to attribute page
		attritube.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	MainController.frame.getContentPane().removeAll();
						MainController.frame.getContentPane().add(VirusConfigMainPanel.createAndShowGUI());
						MainController.frame.revalidate();
				    }
				});
			}
		});
		
		panel.add(bottom,layout);
	}

	public static JPanel createAndShowGUI() {

		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridBagLayout());
		BuildTitle(mainpanel);
		BuildInfo(mainpanel);
		BuildDate(mainpanel);
		BuildBottom(mainpanel);
		BuildTotal(mainpanel);

		return mainpanel;

//		frame.add(mainpanel);
//		frame.setSize(960, 540);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
	}
}
