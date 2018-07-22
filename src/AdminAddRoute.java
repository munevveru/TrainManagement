import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AdminAddRoute extends JPanel {
	private JPanel first;
	private JPanel center;
	private JPanel last;
	private JPanel centerLabels;
	private JPanel centerBoxes;
	private JPanel total;
	
	private JButton saveRouteButton;
	private JButton editRouteButton;
	private JButton backHomeButton;
	
	private JLabel header;
	private JLabel approval;
	private JLabel availableTrainLabel;
	private JLabel leavingDepLabel;
	private JLabel arrivingDepLabel;
	private JLabel leavingTimeLabel;
	private JLabel arrivingTimeLabel;
	
	private JComboBox chooseTrain;
	private JComboBox leavingDep;
	private JComboBox arrivingDep;
	private JComboBox leavingTime;
	private JComboBox arrivingTime;
	
	public AdminAddRoute()
	{
		createComponents();
		
	}
	
	public void createComponents()
	{
		first = new JPanel();
		center = new JPanel(new GridLayout(1,2));
		last = new JPanel(new GridLayout(3,1));
		centerLabels = new JPanel(new GridLayout(5,1));
		centerBoxes = new JPanel(new GridLayout(5,1));
		total = new JPanel(new GridLayout(3,1));
		
		saveRouteButton = new JButton("Save");
		editRouteButton = new JButton("Edit Route");
		backHomeButton = new JButton("Back to Home Page");
		
		header = new JLabel("ADD ROUTE");
		approval = new JLabel("Route is added succesfully.");
		
		availableTrainLabel = new JLabel("Available train");
		leavingDepLabel = new JLabel("Leaving department");
		arrivingDepLabel = new JLabel("Arriving department");
		leavingTimeLabel  = new JLabel("Leaving time");
		arrivingTimeLabel = new JLabel("Arriving time");
		
		
		
		
		
		
		chooseTrain = new JComboBox(viewer.trainNames.toArray());
		leavingDep = new JComboBox(viewer.stationNames.toArray());
		arrivingDep = new JComboBox(viewer.stationNames.toArray());
		leavingTime = new JComboBox(viewer.times.toArray());
		arrivingTime = new JComboBox(viewer.times.toArray());
		
		chooseTrain.setToolTipText("Choose an available train");
		leavingDep.setToolTipText("Choose an leaving department");
		arrivingDep.setToolTipText("Choose an arriving department");
		leavingTime.setToolTipText("Choose a leaving time");
		arrivingTime.setToolTipText("Choose an arriving time");
		
		centerLabels.add(availableTrainLabel);
		centerLabels.add(leavingDepLabel);
		centerLabels.add(arrivingDepLabel);
		centerLabels.add(leavingTimeLabel);
		centerLabels.add(arrivingTimeLabel);
		
		centerBoxes.add(chooseTrain);
		centerBoxes.add(leavingDep);
		centerBoxes.add(arrivingDep);
		centerBoxes.add(leavingTime);
		centerBoxes.add(arrivingTime);
		
		first.add(header);
		center.add(centerLabels);
		center.add(centerBoxes);
		
		saveRouteButton.addActionListener(new listener());
		editRouteButton.addActionListener(new listener());
		backHomeButton.addActionListener(new listener());
		
		last.add(saveRouteButton);
		last.add(editRouteButton);
		last.add(backHomeButton);
		
		total.add(first);
		total.add(center);
		total.add(last);
	
		setLayout(new BorderLayout());
		add(total);
	}
	
	public Train getTrain()
	{
		return (Train)(chooseTrain.getSelectedItem());
	}
	
	public Station getLeavStation()
	{
		return (Station) leavingDep.getSelectedItem();
	}
	
	public Station getArrStation()
	{
		return (Station) arrivingDep.getSelectedItem();
	}
	
	public String getLeavTime()
	{
		return (String) leavingTime.getSelectedItem();
	}
	
	public String getArrTime()
	{
		return (String) arrivingTime.getSelectedItem();
	}
	
	
	public class listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if ( e.getSource() == saveRouteButton ) {
				Route newRoute = new Route(getTrain(), getLeavStation(), getArrStation(), getLeavTime(), getArrTime() );	
				viewer.routes.add(newRoute);

				AdminAddRoute newAdminAddRoutePage = new AdminAddRoute();
			
				removeAll();
				add(newAdminAddRoutePage);
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
