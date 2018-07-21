import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JFrame;


public class viewer{
	
	public static void main(String[] args)
	{

		JFrame frame ;

		frame = new JFrame();
		//AdminHome admin = new AdminHome();
		AdminAddRoute admin = new AdminAddRoute();
		AdminAddTrain addtrain = new AdminAddTrain();

		//frame.add(admin);
		frame.add( addtrain);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.pack() ;
		frame.setVisible(true);


	}
}
