import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminAddStation extends JPanel {
	private JLabel addRoute;
	private JLabel stationNo;
	private JLabel stationName;
	
	private JButton saveStationButton;
	private JButton editStationButton;
	private JButton backHomeButton;
	
	private JTextField stationNoField;
	private JTextField stationNameField;
	
	private JPanel first;
	private JPanel center;
	private JPanel last;
	
	private JPanel centerLabels;
	private JPanel centerFields;
	private JPanel total;
	
	public AdminAddStation()
	{
		createComponents();
	}
	
	public void createComponents()
	{
		addRoute = new JLabel("ADD STATION");
		stationNo = new JLabel("Station No");
		stationName = new JLabel("Station Name");
		
		saveStationButton = new JButton("Save");
		editStationButton = new JButton("Edit Station");
		backHomeButton = new JButton("Back to Home Page");
		
		stationNoField = new JTextField("Station No");
		stationNameField = new JTextField("Station Name");
		
		first = new JPanel();
		center = new JPanel(new GridLayout(1,2));
		centerLabels = new JPanel(new GridLayout(2,1));
		centerFields = new JPanel(new GridLayout(2,1));
		last = new JPanel(new GridLayout(3,1));
		total = new JPanel(new GridLayout(3,1));
		
		first.add(addRoute);
		centerLabels.add(stationNo);
		centerLabels.add(stationName);
		centerFields.add(stationNoField);
		centerFields.add(stationNameField);
		
		stationNoField.addFocusListener(new focuslistener());
		stationNameField.addFocusListener(new focuslistener());
		
		center.add(centerLabels);
		center.add(centerFields);
		
		saveStationButton.addActionListener(new listener());
		editStationButton.addActionListener(new listener());
		backHomeButton.addActionListener(new listener());
		
		last.add(saveStationButton);
		last.add(editStationButton);
		last.add(backHomeButton);
		
		total.add(first);
		total.add(center);
		total.add(last);
	
		setLayout(new BorderLayout());
		add(total);
		
	}
	
	public class focuslistener implements FocusListener {

		@Override

		public void focusGained(FocusEvent e) {

			if (e.getSource() ==  stationNoField) {

				stationNoField.setText("");

			}
			else if ( e.getSource() == stationNameField) {

				stationNameField.setText("");

			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public String getStationName()
	{
		return stationNameField.getText();
	}
	
	public int getStationNo()
	{
		return Integer.parseInt(stationNoField.getText());
	}
	public class listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if ( e.getSource() == saveStationButton ) {
				Station newStation = new Station(getStationName(), getStationNo());	
				viewer.stations.add(newStation);
				viewer.stationNames.add(newStation.getStationName());
				AdminAddStation newAdminAddStationPage = new AdminAddStation();
			
				removeAll();
				add(newAdminAddStationPage);
				revalidate();
				repaint();
			} 
			
			else if(e.getSource() == backHomeButton) {
				AdminHome adminHomePage = new AdminHome();
				
				removeAll();
				add(adminHomePage);
				revalidate();
				repaint();
			}
			
		
//			 if {
//				//EDIT PANELI OLUŞTUR SONRA YAP 
//			}
		}
	}
}
