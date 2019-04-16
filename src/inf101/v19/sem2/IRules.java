package inf101.v19.sem2;

import java.util.List;

public interface IRules {
	
	/**
	 * @return List of ship types.
	 */
	List<Ship> getShips();
	
	/**
	 * @return Shots per round.
	 */
	int getShots();
	
	/**
	 * @return If player is notified about sunken ships.
	 */
	boolean getSinkNotice();

}
