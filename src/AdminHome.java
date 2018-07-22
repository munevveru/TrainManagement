import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminHome extends JPanel implements Questionable{
	
	private JButton logoutButton;
	private JButton addTrainButton;
	private JButton addRouteButton;
	private JButton addStationButton;
	private JButton showUsersButton;
	private JButton questionButton;
	private JLabel adminHomePageHeader;
	private JPanel header;
	private JPanel total;
	public AdminHome()
	{
		createComponents();
	}
	
	public void createComponents()
	{
		logoutButton = new JButton("Log Out");
		logoutButton.addActionListener( new listener());
		addTrainButton = new JButton("Add Train");
		addTrainButton.addActionListener( new listener());
		addStationButton = new JButton("Add Station");
		addStationButton.addActionListener( new listener());
		addRouteButton = new JButton("Add Route");
		addRouteButton.addActionListener( new listener());
		showUsersButton = new JButton("Show Users");
		showUsersButton.addActionListener( new listener());
		questionButton = new JButton("?");
		questionButton.addActionListener(new listener());
		adminHomePageHeader = new JLabel("Admin Homepage");
		
		
		addTrainButton.setPreferredSize(new Dimension (100,100));
		addRouteButton.setPreferredSize(new Dimension (100,100));
		addStationButton.setPreferredSize(new Dimension (100,100));
		showUsersButton.setPreferredSize(new Dimension (100,100));
		
	
		header = new JPanel();
		header.add(logoutButton, BorderLayout.WEST);
		header.add(adminHomePageHeader, BorderLayout.CENTER);
		header.add(questionButton, BorderLayout.EAST);
		total = new JPanel(new GridLayout(5,1));
				
		
		
		total.add(header);
		total.add(addTrainButton);
		total.add(addStationButton);
		total.add(addRouteButton);
		total.add(showUsersButton);
	
		setLayout(new BorderLayout());
		add(total);
		
	}
	
	public class listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if ( e.getSource() == logoutButton ) {

				LoginPanel loginPanel= new LoginPanel();
				removeAll();
				add(loginPanel);
				revalidate();
				repaint();
			} 
			
		
			else if(e.getSource() == addTrainButton) {
				AdminAddTrain addTrain = new AdminAddTrain();
				
				removeAll();
				add(addTrain);
				revalidate();
				repaint();
			}
			
			else if (e.getSource() == addStationButton)
			{
				AdminAddStation addStation = new AdminAddStation();
				removeAll();
				add(addStation);
				revalidate();
				repaint();
			}
			
			else if (e.getSource() == addRouteButton)
			{
				AdminAddRoute addRoute = new AdminAddRoute();
				
				removeAll();
				add(addRoute);
				revalidate();
				repaint();
			}
			
			else if (e.getSource() == showUsersButton)
			{
				//Show users
			}
			
			else if (e.getSource() == questionButton)
			{
				JOptionPane.showMessageDialog(null, QuestionMark()  ); 
			 }
						
		}
			 

	
		}
	 

	@Override
	public String QuestionMark() {
		return "Admin can add train, route, station and display the users.";
	}
}
