package inf101.v19.battleship.game;

import java.util.ArrayList;

import inf101.v19.battleship.objects.IShip;

public interface IRules {
	
	/**
	 * @return List of ship types.
	 */
	ArrayList<IShip> getShips();
	
	/**
	 * @return Shots per round.
	 */
	int getShots();
	
	/**
	 * @return If player is notified about sunken ships.
	 */
	boolean getSinkNotice();
	
	/**
	 * @return Width of board
	 */
	int getBoardWidth();
	
	/**
	 * @return Height of board
	 */
	int getBoardHeight();

	/**
	 * @return List of lengths of ships.
	 */
	int[] getLengths();
	
	/**
	 * Prints the rules.
	 */
	void printRules();

}
