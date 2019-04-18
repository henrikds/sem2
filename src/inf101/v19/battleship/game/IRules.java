package inf101.v19.battleship.game;

import java.util.List;

import inf101.v19.battleship.objects.IShip;

public interface IRules {
	
	/**
	 * @return List of ship types.
	 */
	List<IShip> getShips();
	
	/**
	 * @return Shots per round.
	 */
	int getShots();
	
	/**
	 * @return If player is notified about sunken ships.
	 */
	boolean getSinkNotice();

}
