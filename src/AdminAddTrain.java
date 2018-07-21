import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminAddTrain extends JPanel{
	
	private JPanel first;
	private JPanel center;
	private JPanel last;
	private JPanel centerLabels;
	private JPanel centerFields;
	
	private JLabel addTrain;
	private JLabel trainName;
	private JLabel numberOfCompartments;
	private JLabel seatsInEveryCompartment;
	private JLabel standartTicketPrice;
	private JLabel businessTicketPrice;
	private JLabel approved;
	
	private JTextField trainNameField;
	private JTextField numberOfCompartmentsField;
	private JTextField seatsField;
	private JTextField standartPriceField;
	private JTextField businessPriceField;
	
	private JButton saveButton = new JButton("Save");
	private JButton editTrainButton = new JButton("Edit Trains");
	
	public AdminAddTrain()
	{
		setLayout(new GridLayout(3,1));
		createComponents();
		
	}
	
	public void createComponents()
	{
		//panels
		first = new JPanel();
		center = new JPanel(new GridLayout(1,2));
		last = new JPanel(new GridLayout(2,1));
		centerLabels = new JPanel(new GridLayout(5,1));
		centerFields = new JPanel(new GridLayout(5,1));
		
		//labels
		addTrain = new JLabel("ADD TRAIN");
		trainName = new JLabel("Train Name");
		numberOfCompartments = new JLabel("Number of Compartments");
		seatsInEveryCompartment = new JLabel("Seats (in every compartment)");
		standartTicketPrice = new JLabel("Standart Ticket Price");
		businessTicketPrice = new JLabel("Business Ticket Price");
		approved = new JLabel("Train is added succesfully.");
		
		//buttons
		saveButton = new JButton("Save");
		editTrainButton = new JButton("Edit Trains");
				
		//text fields
		trainNameField = new JTextField("Train Name");
		numberOfCompartmentsField = new JTextField("Number Of Compartments");
		seatsField = new JTextField("Seats (in every compartment)");
		standartPriceField = new JTextField("Standart Ticket Price");
		businessPriceField = new JTextField("Business Ticket Price");
		
		
		trainNameField.addFocusListener(new focuslistener());
		numberOfCompartmentsField.addFocusListener(new focuslistener());
		seatsField.addFocusListener(new focuslistener());
		standartPriceField.addFocusListener(new focuslistener());
		businessPriceField.addFocusListener(new focuslistener());
		
		centerFields.add(trainNameField);
		centerFields.add(numberOfCompartmentsField);
		centerFields.add(seatsField);
		centerFields.add(standartPriceField);
		centerFields.add(businessPriceField);
		
		trainNameField.setCaretColor(Color.LIGHT_GRAY);
		numberOfCompartmentsField.setCaretColor(Color.LIGHT_GRAY);
		seatsField.setCaretColor(Color.LIGHT_GRAY);
		standartPriceField.setCaretColor(Color.LIGHT_GRAY);
		businessPriceField.setCaretColor(Color.LIGHT_GRAY);
		
		
		
		centerLabels.add(trainName);
		centerLabels.add(numberOfCompartments);
		centerLabels.add(seatsInEveryCompartment);
		centerLabels.add(standartTicketPrice);
		centerLabels.add(businessTicketPrice);
		
		first.add(addTrain);
		center.add(centerLabels);
		center.add(centerFields);
		last.add(saveButton);
		last.add(editTrainButton);
		
		add(first);
		add(center);
		add(last);
	}
	
	public class focuslistener implements FocusListener {

		@Override

		public void focusGained(FocusEvent e) {

			if (e.getSource() ==  trainNameField) {

				trainNameField.setText("");

			}
			else if ( e.getSource() == numberOfCompartmentsField) {

				numberOfCompartmentsField.setText("");

			}
			else if( e.getSource() == seatsField)
			{

				seatsField.setText("");

			}
			
			else if ( e.getSource() == standartPriceField)
			{
				standartPriceField.setText("");
			}
			
			else if ( e.getSource() == businessPriceField)
			{
				businessPriceField.setText("");
			}

		}



		@Override

		public void focusLost(FocusEvent e) {

			// TODO Auto-generated method stub

		}
		
		public void paint(Graphics g)
		{
		   g.drawString("ADD TRAIN", 25, 25);
		}
	}
}
