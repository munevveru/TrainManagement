import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminAddTrain extends JPanel {
	
	Menu menu;
	private static Trains trainList;
	private JPanel first;
	private JPanel center;
	private JPanel last;
	private JPanel centerLabels;
	private JPanel centerFields;
	private JPanel total;
	
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
	private JButton backHomeButton;

	
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
		last = new JPanel(new GridLayout(3,1));
		centerLabels = new JPanel(new GridLayout(5,1));
		centerFields = new JPanel(new GridLayout(5,1));
		
		total = new JPanel(new GridLayout(3,1));
		
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
		backHomeButton = new JButton("Back to Home Page");
		
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
		
		//listener
		saveButton.addActionListener(new listener());
		backHomeButton.addActionListener(new listener());
		editTrainButton.addActionListener(new listener());
		
		first.add(addTrain);
		center.add(centerLabels);
		center.add(centerFields);
		last.add(saveButton);
		last.add(editTrainButton);
		last.add(backHomeButton);
		
		setLayout(new BorderLayout());
		total.add(first);
		total.add(center);
		total.add(last);
		
		add(total);
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
		
	}
	
	public String getTrainName()
	{
		return trainNameField.getText();
	}
	
	public int getCompartmentNumber()
	{
		int compartmentNumber = Integer.parseInt(numberOfCompartmentsField.getText());
		return compartmentNumber;
	}
	
	public int getSeatNumber()
	{
		int seatNumber = Integer.parseInt(seatsField.getText());
		return seatNumber;
	}
	
	public double getStandartPrice()
	{
		double standartPrice = Double.parseDouble(standartPriceField.getText());
		return standartPrice;
	}
	
	public double getBusinessPrice()
	{
		double businessPrice = Double.parseDouble( businessPriceField.getText());
		return businessPrice;
	}
	
//	public void getTrainList()
//	{
//		for(int i = 0; i < trains.size(); i++)
//		{
//			if (trains.get(i) instanceof Train)
//			{
//				System.out.println(((Train)trains.get(i)).getName());
//			}
//		}
//	}
	
	public class listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if ( e.getSource() == saveButton ) {
				Train newTrain = new Train(getTrainName(), getCompartmentNumber(), getSeatNumber(), getStandartPrice(), getBusinessPrice());	
				viewer.trains.add(newTrain);
				viewer.trainNames.add(newTrain.getName());
				
				AdminAddTrain newAdminAddTrainPage = new AdminAddTrain();
				removeAll();

				add(newAdminAddTrainPage);
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
			
			else if (e.getSource() == editTrainButton)
			{
				///edit page
			}
		}
	}




}
