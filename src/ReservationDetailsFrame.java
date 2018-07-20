import java.awt.Dimension;
import javax.swing.JFrame;

public class ReservationDetailsFrame extends JFrame {

    //attributes
    private  ReservationDetailsPanel reservationdetailspanel;

    //constructors
    public ReservationDetailsFrame() {
        createComponents();
        setComponents()  ;
    }

    //methods
    public void createComponents(){
        reservationdetailspanel = new ReservationDetailsPanel();
        add( reservationdetailspanel );
    }
    public void setComponents(){
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setPreferredSize(new Dimension(600, 400));
        pack() ;
        setVisible(true);

    }
}


