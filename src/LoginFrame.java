import javax.swing.*;


public class LoginFrame extends JFrame{

    //attributes
    final int WIDTH = 600;
    final int HEIGHT = 400;
    private LoginPanel topPanel;

    //constructors
    public LoginFrame(){
        createComponents();
        setComponents()  ;
    }

    //methods
    public void setComponents(){
        setSize( WIDTH, HEIGHT);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
    }
    public void createComponents(){
        topPanel = new LoginPanel();
        add( topPanel);
    }
}
