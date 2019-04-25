package inf101.v19.battleship.objects;

public interface IShip extends IItem {
	
	/**
	 * Set a custom name for a ship.
	 * 
	 * @param Custom name.
	 */
	void setCustomName(String name);
	
	/**
	 * Get a custom name for a ship.
	 * Returns ship type if custom name not set.
	 * 
	 * @return Custom name.
	 */
	String getCustomName(String name);
	
	/**
	 * Change placement of ship.
	 * 
	 * @param xStart
	 * @param yStart
	 * @param xEnd
	 * @param yEnd
	 */
	void changePlacement(int xStart, int yStart, int xEnd, int yEnd);
}
