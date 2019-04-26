package inf101.v19.battleship.game;

import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.objects.IItem;

public interface INonPlayer {

	/**
	 * Fills the the board with ships.
	 * 
	 */
	Board<IItem> fillBoard();
}
