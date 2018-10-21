package ui;

public class Main{
	static JFrame frame= new JFrame("MainUI");
	static JPanel mainpanel = new JPanel();
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
	
	
	public static void BuildInfo() 
	{
		JTable table = new JTable(info, att);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		GridBagConstraints layout=new GridBagConstraints();
		layout.gridx=0;
		layout.gridy=0;
		layout.gridheight=2;
		layout.insets = new Insets(0,0,0,20);
		mainpanel.add(scrollPane,layout);
		

	}
	public static void BuildDate()
	{
		JLabel finDate= new JLabel("Finish Date: 1/1/2020");
		JLabel resDate= new JLabel("Research Date: 15/10/2019");
		GridBagConstraints layout=new GridBagConstraints();
		layout.gridx=1;
		layout.gridy=0;
		layout.anchor=GridBagConstraints.NORTHWEST;
		mainpanel.add(finDate,layout);
		layout.gridy=1;
		mainpanel.add(resDate,layout);
	}
	
	public static void BuildBottom()
	{
		JPanel bottom=new JPanel();
		bottom.setLayout(new GridLayout(1,3));
		JLabel respoint= new JLabel("Research: 50%", SwingConstants.CENTER);
		respoint.setFont(new Font("sans serif", Font.BOLD, 16));
		respoint.setBackground(Color.lightGray);
		respoint.setOpaque(true);
		bottom.add(respoint);
		JButton attritube=new JButton("Attritube");
		bottom.add(attritube);
		JButton exit=new JButton("Exit");
		bottom.add(exit);
		GridBagConstraints layout=new GridBagConstraints();
		layout.gridx=0;
		layout.gridy=2;
		layout.gridwidth=2;
		layout.fill=GridBagConstraints.HORIZONTAL;
		mainpanel.add(bottom,layout);
	}
	
	public static void Buildmain(String[] args) {
		mainpanel.setLayout(new GridBagLayout());
		BuildInfo();
		BuildDate();
		BuildBottom();
		mainpanel.setSize(800, 600);
		/*	frame.add(mainpanel);
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		*/
		
	}
    }


