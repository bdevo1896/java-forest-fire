import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private Controller c;
	private Canvas canvas;
	private static final Color TREE_C = new Color(120,184,63), DIRT_C = new Color(136,84,49),FIRE_L_C = new Color(233,208,69),FIRE_M_C = new Color(243,134,35),FIRE_D_C = new Color(245,33,33),CHARRED_C = new Color(61,44,27),WATER_C = new Color(63,80,173);

	
	public MainFrame(Controller c){
		this.c = c;
		this.canvas = new Canvas();
		this.getContentPane().add(canvas);
		this.setSize(Controller.ROWS*Controller.SITE_SIZE,Controller.COLS*Controller.SITE_SIZE);
		this.setResizable(false);
		this.setTitle("Forest Fire");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class Canvas extends JPanel {
				
		public Canvas(){
			this.addMouseListener(c.getMouseHelper());
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			for(int i = 0; i < Controller.ROWS; i++){
				for(int k = 0; k < Controller.COLS; k++){
					switch(c.getSite(i,k)){
					case Forest.TREE:
						g.setColor(TREE_C);
						break;
					case Forest.DIRT:
						g.setColor(DIRT_C);
						break;
					case Forest.FIRE_LITE:
						g.setColor(FIRE_L_C);
						break;
					case Forest.FIRE_MED:
						g.setColor(FIRE_M_C);
						break;
					case Forest.FIRE_DONE:
						g.setColor(FIRE_D_C);
						break;
					case Forest.WATER:
						g.setColor(WATER_C);
						break;
					default:
						g.setColor(CHARRED_C);
					}
					
					g.fillRect(i*Controller.SITE_SIZE, k * Controller.SITE_SIZE, Controller.SITE_SIZE, Controller.SITE_SIZE);
					g.setColor(Color.black);
					//g.drawRect(i*Controller.SITE_SIZE, k * Controller.SITE_SIZE, Controller.SITE_SIZE, Controller.SITE_SIZE);
				}
			}
		}
	}

	public void update() {
		canvas.repaint();
	}

}
