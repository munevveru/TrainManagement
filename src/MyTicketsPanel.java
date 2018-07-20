import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//log out or back button

public class MyTicketsPanel extends JPanel implements Questionable{

    private JLabel mytickets;
    private JPanel questionPanel;
    private JButton questionMark;
    Icon question;
    JScrollBar vbar;
    JTextArea textarea ;
    JScrollPane ta1;

    public MyTicketsPanel() {
        createComponents()  ;
        addComponents() ;
    }



    public void createComponents(){
        mytickets = new JLabel ("My Tickets");
        question = new ImageIcon(getClass().getResource("quesJava.png"));
        questionMark= new JButton("",  question);
        questionMark.addActionListener( new listener () );
        questionPanel =  new JPanel();

        questionPanel.setLayout( new BorderLayout());
        questionPanel.add( questionMark, BorderLayout.EAST );
        questionPanel.add( mytickets, BorderLayout.CENTER );

        vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 100);
        textarea = new JTextArea(40, 40);
        ta1 = new JScrollPane(textarea);

    }

    public void addComponents() {
        setLayout(new BorderLayout());
        add(questionPanel, BorderLayout.NORTH);
        add(new JScrollPane(ta1), BorderLayout.CENTER);

    }
    public class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (  e.getSource() ==  questionMark ) {
                JOptionPane.showMessageDialog(null, QuestionMark()  );
            }

        }
    }
    @Override
    public String QuestionMark() {
        return "showing users all tickets";
    }


}
