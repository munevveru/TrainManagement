import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class ReservationDetailsPanel extends JPanel implements Questionable{

    JLabel completed;
    JScrollBar vbar;
    JTextArea textarea;
    JScrollPane ta1;
    JButton button1;
    JButton button2;
    JButton button3;
    JPanel buttonpanel ;
    private JPanel questionPanel;
    private JButton questionMark;
    Icon question;

    public ReservationDetailsPanel () {
        createComponents();
    }

    public void createComponents(){
        completed = new JLabel ( "Reservation is completed", SwingConstants.CENTER);
        question = new ImageIcon(getClass().getResource("quesJava.png"));
        questionMark= new JButton("",  question);
        questionMark.addActionListener( new listener () );
        questionPanel =  new JPanel();
        questionPanel.setLayout( new BorderLayout());
        questionPanel.add( questionMark, BorderLayout.EAST );
        questionPanel.add( completed, BorderLayout.WEST );

//		 //example
//		   ArrayList <String> infoOfTicket = new ArrayList <>();
//		   infoOfTicket.add("a \n");
//		   infoOfTicket.add("b \n");
//		   infoOfTicket.add("c \n");
//		   infoOfTicket.add("d \n");
//		   infoOfTicket.add("e \n");


        vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 100);
        textarea = new JTextArea(30, 30);
        ta1 = new JScrollPane(textarea);

        buttonpanel = new JPanel ();
        button1= new JButton("My Tickets");
        button2= new JButton("Buy a new ticket");
        button3= new JButton("Log out");
        buttonpanel.add(button1);
        buttonpanel.add(button2);
        buttonpanel.add(button3);

        setLayout (new BorderLayout());
        add( questionPanel, BorderLayout.NORTH );
        add(new JScrollPane(ta1), BorderLayout.CENTER);
        add(buttonpanel, BorderLayout.SOUTH);

    }


    public class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (  e.getSource() ==  questionMark ) {
                JOptionPane.showMessageDialog(null, QuestionMark()  );
            } else if (  e.getSource() ==  button1 ) {
                // TODO back to my tickets
            } else if (  e.getSource() ==  button2 ) {
                // TODO buy a new ticket
            } else if (  e.getSource() ==  button3 ) {
                // TODO log out
            }


        }
    }

    @Override
    public String QuestionMark() {
        return "reservation details";
    }


}
