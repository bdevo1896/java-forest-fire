import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Controller {
	
	private Forest forest;
	public static final int ROWS = 100,COLS = 100,SITE_SIZE = 10;
	private ActionHelper aH;
	private MouseHelper mH;
	private MainFrame mf;
	
	public Controller(){
		this.forest = new Forest(ROWS,COLS);
		this.aH = new ActionHelper(this);
		this.mH = new MouseHelper(this);
		this.mf = new MainFrame(this);
		this.mf.setVisible(true);
	}
	
	public void startFire(int i, int j) {
		this.forest.startFire(i, j);
	}

	public void update() {
		this.forest.spread();
		this.mf.update();
	}

	public int getSite(int i, int k) {
		return this.forest.getSite(i, k);
	}

	public MouseListener getMouseHelper() {
		return mH;
	}
	
	public ActionListener getActionHelper(){
		return aH;
	}

}
