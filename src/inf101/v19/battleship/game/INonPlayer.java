package inf101.v19.battleship.game;

import java.util.ArrayList;

import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public interface INonPlayer {

	/**
	 * Fills the the board with ships.
	 * 
	 * @return Board with ships.
	 */
	Board<IItem> fillBoard();
	
	/**
	 * Get Non-player ships
	 * 
	 * @return Ships
	 */
	ArrayList<IShip> getShips();
	
	/**
	 * Fire a shot at a given board.
	 * @param Board to be shot at.
	 * 
	 * @return If ships is hit.
	 */
	boolean fireAtPlayer(Board<IItem> playerBoard);
}
