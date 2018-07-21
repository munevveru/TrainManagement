import javax.swing.JFrame;
import javax.swing.JPanel;

public class viewer{
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
	//	AdminHome admin = new AdminHome();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600,600);
	//	
		
		AdminAddRoute admin = new AdminAddRoute();
		
		frame.add(admin);
	}
}
