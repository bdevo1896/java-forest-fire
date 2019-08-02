import java.util.Random;


public class Forest {
	
	private int[][] forest; 
	private int cols,rows;
	public static final int TREE = 1, DIRT = 2, FIRE_LITE = 3, FIRE_MED = 4, FIRE_DONE = 5, CHARRED = 6;
	public static final int WATER = 0;
	private static final double CHANCE = .25;

	public Forest(int rows, int cols) {
		forest = new int[rows][cols];
		this.rows = rows;
		this.cols = cols;
		this.plant();//Fills the grid with numbers
	}
	
	/**
	 * Fills the 2D array forest with numbers that are 1 or 2
	 */
	public void plant(){
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				double areaChoice = Math.random();// This number will be used to plant a tree or put dirt in the current grid spot
				if(areaChoice >= CHANCE){
					forest[row][col] = TREE;
				}else{
					forest[row][col] = DIRT;
				}
			}
		}
	}
	
	/**
	 * This will return a true or false depending on whether the row and col indexes are in the forest list
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean isOutOfBounds(int row, int col){
		return row < 0 || row >= rows || col < 0 || col >= cols;
	}
	
	/**
	 * Checks to see if the site requested is in the list, then returns the value of the site.
	 * @param row
	 * @param col
	 * @return
	 */
	public int getSite(int row, int col){
		if(this.isOutOfBounds(row,col)){
			return 0;
		}
		
		return forest[row][col];
	}
	
	/**
	 * Changes the requested site to a specified value. Will be used to start the fire
	 * @return
	 */
	public void changeSite(int row, int col, int newVal){
		if(!this.isOutOfBounds(row, col)){
			forest[row][col] = newVal;
		}
	}
	
	/**
	 * This method will change the area picked to
	 * @return
	 */
	public void startFire(int row, int col){
		if(!this.isOutOfBounds(row, col)){
			if(forest[row][col] == TREE){
				forest[row][col] = FIRE_LITE;
			}
		}
	}
	
	/**
	 * This method will find the adjacent areas around the inputed row and col number and then set fire to
	 * them if they are trees.
	 * @return
	 */
	public void makeFireRing(int row, int col){
		this.startFire(row-1, col-1);//Top-left corner
		this.startFire(row-1, col);//Top center
		this.startFire(row-1, col+1);//Top-right corner
		this.startFire(row, col-1);//Left-middle
		this.startFire(row, col+1);//Right-middle
		this.startFire(row+1, col-1);//Bottom-left corner
		this.startFire(row+1, col);//Bottom center
		this.startFire(row+1, col+1);//Bottom-right corner
	}
	
	/**
	 * This method will spread the fire to other nearby trees at every place that it can be done
	 * @return
	 */
	public void spread(){
		for(int i = 0; i < forest.length; i++){
			for(int k = 0; k < forest[i].length; k++){
				switch(forest[i][k]){
				case FIRE_LITE:
					forest[i][k] = FIRE_MED;
					break;
				case FIRE_MED:
					forest[i][k] = FIRE_DONE;
					this.makeFireRing(i, k);
					break;
				case FIRE_DONE:
					forest[i][k] = CHARRED;
					break;
//				default:
//					//Nothing will be done here
				}
			}
		}
	}
	

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	

}
