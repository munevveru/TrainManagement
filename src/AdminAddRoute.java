import java.awt.GridLayout;

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
	
	private JButton saveRouteButton;
	private JButton editRouteButton;
	
	private JLabel header;
	private JLabel approval;
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
		setLayout(new GridLayout(3,1));
		createComponents();
		
	}
	
	public void createComponents()
	{
		first = new JPanel(new GridLayout(2,1));
		center = new JPanel(new GridLayout(1,2));
		last = new JPanel(new GridLayout(2,1));
		centerLabels = new JPanel(new GridLayout(4,1));
		centerBoxes = new JPanel(new GridLayout(4,1));
		
		saveRouteButton = new JButton("Save");
		editRouteButton = new JButton("Edit Route");
		
		header = new JLabel("ADD ROUTE");
		approval = new JLabel("Route is added succesfully.");
		
		leavingDepLabel = new JLabel("Leaving department");
		arrivingDepLabel = new JLabel("Arriving department");
		leavingTimeLabel  = new JLabel("Leaving time");
		arrivingTimeLabel = new JLabel("Arriving time");
		
		
		chooseTrain = new JComboBox();
		leavingDep = new JComboBox();
		arrivingDep = new JComboBox();
		leavingTime = new JComboBox();
		arrivingTime = new JComboBox();
		
		chooseTrain.setToolTipText("Choose an available train");
		leavingDep.setToolTipText("Choose an leaving department");
		arrivingDep.setToolTipText("Choose an arriving department");
		leavingTime.setToolTipText("Choose a leaving time");
		arrivingTime.setToolTipText("Choose an arriving time");
		
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
		first.add(chooseTrain);
		center.add(centerLabels);
		center.add(centerBoxes);
		
		last.add(saveRouteButton);
		last.add(editRouteButton);
		
		add(first);
		add(center);
		add(last);
	}
	
	
}
