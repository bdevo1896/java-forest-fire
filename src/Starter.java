import javax.swing.Timer;

public class Starter {

	public static void main(String[] args) {
		Controller c = new Controller();
		Timer time = new Timer(1000,c.getActionHelper());
		time.start();
	}

}
