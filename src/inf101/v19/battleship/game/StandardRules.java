package inf101.v19.battleship.game;

import java.util.ArrayList;

public class StandardRules implements IRules{

	@Override
	public ArrayList<String> getShips() {
		ArrayList<String> ships = new ArrayList<String>();
		
		ships.add("Carrier");
		ships.add("Battleship");
		ships.add("Destroyer");
		ships.add("Submarine");
		ships.add("Patrol Boat");
		
		return ships;
	}

	@Override
	public int getShots() {
		return 1;
	}

	@Override
	public boolean getSinkNotice() {
		return true;
	}

	@Override
	public int getBoardWidth() {
		return 10;
	}

	@Override
	public int getBoardHeight() {
		return 10;
	}

}
