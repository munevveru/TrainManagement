import java.awt.Dimension;

import javax.swing.JFrame;

public class  CreateAccountFrame extends JFrame{

    //attributes
    final int WIDTH = 600;
    final int HEIGHT = 400;
    private  CreateAccountPanel createAccountPanel;

    //constructors
    public CreateAccountFrame(){
        setComponents()  ;
        addComponents();

    }

    //methods
    public void setComponents(){
        createAccountPanel = new CreateAccountPanel();
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setPreferredSize(new Dimension(600, 400));
        pack() ;
        setVisible(true);
    }
    public void addComponents(){
        add( createAccountPanel);
    }
}
