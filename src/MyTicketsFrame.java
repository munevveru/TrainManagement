import javax.swing.JFrame;

public class MyTicketsFrame extends JFrame {

    //attributes
    final int WIDTH = 600;
    final int HEIGHT = 400;
    private  MyTicketsPanel  myticketspanel;

    //constructors
    public MyTicketsFrame (){
        addComponents();
        setComponents()  ;
    }

    //methods
    public void addComponents() {
        myticketspanel = new MyTicketsPanel();
        add( myticketspanel );
    }
    public void setComponents(){
        setSize( WIDTH, HEIGHT);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
    }
}