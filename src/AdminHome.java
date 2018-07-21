import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminHome extends JPanel{
	
	private JButton logoutButton;
	private JButton addTrainButton;
	private JButton addRouteButton;
	private JButton addStationButton;
	private JButton showUsersButton;
	private JButton questionButton;
	private JLabel adminHomePageHeader;
	private JPanel header;
	
	public AdminHome()
	{
		setLayout(new GridLayout(5,1));
		createComponents();
	}
	
	public void createComponents()
	{
		logoutButton = new JButton("Log Out");
		addTrainButton = new JButton("Add Train");
		addRouteButton = new JButton("Add Route");
		addStationButton = new JButton("Add Station");
		showUsersButton = new JButton("Show Users");
		questionButton = new JButton("?");
		adminHomePageHeader = new JLabel("Admin Homepage");
		
		addTrainButton.setPreferredSize(new Dimension (100,100));
		addRouteButton.setPreferredSize(new Dimension (100,100));
		addStationButton.setPreferredSize(new Dimension (100,100));
		showUsersButton.setPreferredSize(new Dimension (100,100));
		
	
		header = new JPanel();
		header.add(logoutButton, BorderLayout.WEST);
		header.add(adminHomePageHeader, BorderLayout.CENTER);
		header.add(questionButton, BorderLayout.EAST);
		
		
		add(header);
		add(addTrainButton);
		add(addRouteButton);
		add(addStationButton);
		add(showUsersButton);
		
		
		
	
	}
}
