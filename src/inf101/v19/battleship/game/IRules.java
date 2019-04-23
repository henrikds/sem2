package inf101.v19.battleship.game;

import java.util.ArrayList;

public interface IRules {
	
	/**
	 * @return List of ship types.
	 */
	ArrayList<String> getShips();
	
	/**
	 * @return Shots per round.
	 */
	int getShots();
	
	/**
	 * @return If player is notified about sunken ships.
	 */
	boolean getSinkNotice();

}
