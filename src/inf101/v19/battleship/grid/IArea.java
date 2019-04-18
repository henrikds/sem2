package inf101.v19.battleship.grid;

public interface IArea {
	
	/**
	 * @param x-coordinate of area.
	 */
	void setX(int x);
	
	/**
	 * @return The height of the area.
	 */
	int getHeight();
	
	/**
	 * @param y-coordinate of area.
	 */
	void setY(int y);
	
	/**
	 * @return The length of the grid.
	 */
	int getLength();
	
	/**
	 * @return The start x-coordinate of the area.
	 */
	int getXStart();
	
	/**
	 * @return The start y-coordinate of the area.
	 */
	int getYStart();
	
	/**
	 * @return The end x-coordinate of the area.
	 */
	int getXEnd();
	
	/**
	 * @return The end y-coordinate of the area.
	 */
	int getYEnd();
	
	
	

}
