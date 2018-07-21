import java.awt.GridLayout;
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
	
	private JTextField stationNoField;
	private JTextField stationNameField;
	
	private JPanel first;
	private JPanel center;
	private JPanel last;
	
	private JPanel centerLabels;
	private JPanel centerFields;
	
	public AdminAddStation()
	{
		setLayout(new GridLayout(3,1));
		createComponents();
	}
	
	public void createComponents()
	{
		addRoute = new JLabel("ADD STATION");
		stationNo = new JLabel("Station No");
		stationName = new JLabel("Station Name");
		
		saveStationButton = new JButton("Save");
		editStationButton = new JButton("Edit Route");
		
		stationNoField = new JTextField("Station No");
		stationNameField = new JTextField("Station Name");
		
		first = new JPanel();
		center = new JPanel(new GridLayout(1,2));
		centerLabels = new JPanel(new GridLayout(2,1));
		centerFields = new JPanel(new GridLayout(2,1));
		last = new JPanel(new GridLayout(2,1));
		
		first.add(addRoute);
		centerLabels.add(stationNo);
		centerLabels.add(stationName);
		centerFields.add(stationNoField);
		centerFields.add(stationNameField);
		
		stationNoField.addFocusListener(new focuslistener());
		stationNameField.addFocusListener(new focuslistener());
		
		center.add(centerLabels);
		center.add(centerFields);
		
		last.add(saveStationButton);
		last.add(editStationButton);
		
		add(first);
		add(center);
		add(last);
		
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
}
