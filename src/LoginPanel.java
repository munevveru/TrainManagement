import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class LoginPanel extends JPanel implements Questionable{

    //properties
    final String USERNAME_TEXT = "Username ";
    final String PASSWORD_TEXT = "Password ";
    final String BUTTON1_TEXT = "Sign in";
    final String BUTTON2_TEXT = "or Sign up";
    final String BUTTON3_TEXT = "For admin account";

    private JTextField usernameField, passwordField;
    private JButton signInButton;
    private JButton signUpButton;
    private JButton adminAccountButton;
    private JButton questionMark;

    private JPanel buttonsSigningPanel;
    private JPanel textFieldPanel;
    private JPanel questionPanel;

    private Icon question;
    private Icon username;
    JLabel lowerField;

    CreateAccountPanel page;

    public LoginPanel(){

        signInButton= new JButton(BUTTON1_TEXT); //size of buttons
        signInButton.setPreferredSize(new Dimension(40, 40));
        signUpButton= new JButton(BUTTON2_TEXT);
        signUpButton.setPreferredSize(new Dimension(40, 40));
        adminAccountButton= new JButton(BUTTON3_TEXT);
        adminAccountButton.setPreferredSize(new Dimension(40, 40));


        question = new ImageIcon(getClass().getResource("quesJava.png"));
     //  username = new ImageIcon(getClass().getResource("username.png"));

        questionMark= new JButton("",  question);

        usernameField = new JTextField(USERNAME_TEXT);
        usernameField.addFocusListener( new focuslistener() );
        passwordField = new JTextField(PASSWORD_TEXT);
        passwordField.addFocusListener( new focuslistener() );

        signInButton.addActionListener(new listener() ) ;
        signUpButton.addActionListener(new listener() ) ;
        adminAccountButton.addActionListener(new listener() ) ;
        questionMark.addActionListener(new listener() ) ;

        buttonsSigningPanel = new JPanel();
        buttonsSigningPanel.setLayout( new BorderLayout());
        buttonsSigningPanel.add(signInButton , BorderLayout.NORTH );
        buttonsSigningPanel.add(signUpButton, BorderLayout.CENTER  );
        buttonsSigningPanel.add(adminAccountButton , BorderLayout.SOUTH);


        textFieldPanel =  new JPanel();
//		  textFieldPanel.setLayout( new GridLayout(2,1));
        textFieldPanel.add( usernameField  );
        textFieldPanel.add(passwordField);

        questionPanel =  new JPanel();
        lowerField = new JLabel("change");
        questionPanel.setLayout( new BorderLayout());
        questionPanel.add( questionMark, BorderLayout.EAST );
        questionPanel.add(lowerField ,BorderLayout.WEST );



        setLayout( new BorderLayout());
        add( questionPanel, BorderLayout.NORTH);
        add( textFieldPanel, BorderLayout.CENTER );
        add( buttonsSigningPanel, BorderLayout.SOUTH );


        setBackground(Color.PINK);




    }

    public class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource() ==  signInButton ) { //if the given name password true?


                File file = new File("username");
                try {
////					 File file = new File("username");
//			          Scanner scan = new Scanner(file);
//			          String line = null;
//
//			          String usernametxt = "";
//			          String passwordtxt = "";
//			          String puname =  usernameField.getText();
//			          String  ppaswd = passwordField.getText();
//
//
//			          while (scan.hasNext()) {
//			            usernametxt = scan.nextLine();
//			            passwordtxt = scan.nextLine();
//			            if( puname.equals(usernametxt) &&  ppaswd.equals(passwordtxt)) {
//			            	lowerField.setText("true");
//
//			            	 //PASS TO ANOTHER PAGE
//			            }
//			            else if( !( ( puname.equals(usernametxt)) &&   ppaswd.equals(passwordtxt) ) ){
//			            	lowerField.setText("false");
//			            	 System.out.println("false");
//
//			            }
//			            else if( puname.equals("") &&  ppaswd.equals("") )  {
//
//			            	 JOptionPane.showMessageDialog(null,"Please insert Username and Password");
//			            }
//			        }

//					 File file = new File("username");
                    Scanner scan = new Scanner(file);
                    String line = null;


                    String usertxt = " ";
                    String passtxt = " ";
                    String puname = usernameField.getText();
                    String ppaswd = passwordField.getText();


                    while (scan.hasNext()) {

                        usertxt = scan.nextLine();
                        passtxt = scan.nextLine();


                        if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
                            lowerField.setText("true");
//				        	  JOptionPane.showMessageDialog(null,"true");
                        }
                        else if(puname.equals("") && ppaswd.equals("")){

                            lowerField.setText("Please insert Username and Password");
                        }
                        else {

                            lowerField.setText("false");
                            usernameField.setText("               ");
                            passwordField.setText("                ");

                        }

                    }






                }  catch( Exception ex) {
                    System.out.println("Could Not Find the File");
                }


            }else if ( e.getSource() ==   signUpButton ) {
                //CreateAccountFrame createAccountframe = new CreateAccountFrame();
                // add( createAccountframe  );

                CreateAccountPanel createAccountpanel;
                createAccountpanel = new CreateAccountPanel();
                setBackground(Color.BLACK);
                removeAll();
                add(createAccountpanel );
                revalidate();
                repaint();

            }else if ( e.getSource() ==   adminAccountButton ) {




            }else if (  e.getSource() ==   questionMark ) {
                JOptionPane.showMessageDialog(null, QuestionMark()  );
            }

        }

    }

    @Override
    public String QuestionMark() { //pop up panel???
        return "you have clicked the question mark";
    }

    public class focuslistener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() ==  usernameField) {
                usernameField.setText("");
            }else{
                passwordField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
        }

    }



}
