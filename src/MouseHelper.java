import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHelper implements MouseListener{
	private Controller c;
	
	public MouseHelper(Controller c){
		this.c = c;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		c.startFire(arg0.getX()/Controller.SITE_SIZE,arg0.getY()/Controller.SITE_SIZE);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
