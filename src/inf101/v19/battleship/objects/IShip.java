package inf101.v19.battleship.objects;

public interface IShip extends IItem {
	
	/**
	 * @return The length of the ship.
	 */
	int getLength();
	
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

}
