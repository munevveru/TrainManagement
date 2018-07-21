import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CreateAccountPanel extends JPanel implements Questionable{
    //properties
    private JPanel questionPanel;
    private JButton questionMark;
    final String BUTTON2_TEXT = "Sign up";
    final String USERNAME_TEXT = "Enter Username ";
    final String PASSWORD_TEXT = "Enter Password ";
    final String PASSWORD_AGAIN_TEXT = "Enter Password Again";
    private JButton signUpButton;
    private JTextField usernameField, passwordField, againPasswordField;
    Icon question;
    private JPanel centerPanel;
    JPanel signupPanel ;
    JLabel labelText;

    public  CreateAccountPanel (){

        createComponents();
        addComponents();

    }


    public void createComponents(){

        question = new ImageIcon(getClass().getResource("quesJava.png"));
        questionMark= new JButton("",  question);
        questionMark.addActionListener( new listener () );

        signUpButton= new JButton(BUTTON2_TEXT);
        signUpButton.addActionListener( new listener () );

        usernameField = new JTextField(USERNAME_TEXT);
        usernameField.addFocusListener( new  focuslistener() );
        passwordField = new JTextField(PASSWORD_TEXT);
        passwordField.addFocusListener( new focuslistener() );
        againPasswordField = new JTextField(PASSWORD_AGAIN_TEXT);
        againPasswordField.addFocusListener( new focuslistener() );

        centerPanel = new JPanel();
        questionPanel =  new JPanel();
        signupPanel = new JPanel();

        labelText = new JLabel ("      CREATING ACCOUNT");
    }

    public void addComponents(){
        centerPanel.setLayout( new GridLayout(3,1) );
        centerPanel.add(usernameField);
        centerPanel.add(passwordField);
        centerPanel.add(againPasswordField);


        questionPanel.setLayout( new BorderLayout());
        questionPanel.add( questionMark, BorderLayout.EAST );
        questionPanel.add( labelText, BorderLayout.WEST );

        signupPanel.add(signUpButton);

        setLayout( new BorderLayout());
        add(questionPanel,  BorderLayout.NORTH );
        add(centerPanel,  BorderLayout.CENTER );
        add(signupPanel,  BorderLayout.SOUTH );


    }

    public class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Scanner x ;
            if ( e.getSource()==signUpButton) {

                try {
                    x= new Scanner( new File("username") );
                    FileWriter filewrite = new FileWriter(new File("username"), true);

                    String punamer =  usernameField.getText();
                    String ppaswder =  passwordField.getText();

                    while (x.hasNext()) {
                        filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
                        filewrite.close();
                        JOptionPane.showMessageDialog(null,"Account has been created.");

                    }
                }  catch( Exception ex) {
                    System.out.println("Could Not Find the File2");
                }
                 LoginPanel loginpanel; //ADD BACK
                loginpanel = new LoginPanel(); //ADD BACK
                setBackground(Color.BLACK);
                removeAll();
                add(loginpanel); //ADD BACK
                revalidate();
                repaint();

            }else if (  e.getSource() ==  questionMark ) {
                JOptionPane.showMessageDialog(null, QuestionMark()  );
            }

        }
    }
    public class focuslistener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() ==  usernameField) {
                usernameField.setText("");
            }else if ( e.getSource() == passwordField) {
                passwordField.setText("");
            }else{
                againPasswordField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
        }

    }


    @Override
    public String QuestionMark() {
        return "creating account";
    }

}
