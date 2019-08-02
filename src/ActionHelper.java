import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHelper implements ActionListener {
	
	private Controller c;
	
	public ActionHelper(Controller c){
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		c.update();
	}

}
