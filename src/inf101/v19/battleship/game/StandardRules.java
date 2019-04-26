package inf101.v19.battleship.game;

import java.util.ArrayList;
import inf101.v19.battleship.objects.IShip;
import inf101.v19.battleship.objects.PatrolBoat;
import inf101.v19.battleship.objects.Submarine;
import inf101.v19.battleship.objects.Battleship;
import inf101.v19.battleship.objects.Carrier;
import inf101.v19.battleship.objects.Destroyer;

public class StandardRules implements IRules{

	@Override
	public ArrayList<IShip> getShips() {
		ArrayList<IShip> ships = new ArrayList<IShip>();
		
		ships.add(new Carrier(1, 1, 1, 1));
		ships.add(new Battleship(1, 1, 1, 1));
		ships.add(new Destroyer(1, 1, 1, 1));
		ships.add(new Submarine(1, 1, 1, 1));
		ships.add(new PatrolBoat(1, 1, 1, 1));
		
		return ships;
	}
	
	@Override
	public int[] getLengths() {
		int[] lengths = {5, 4, 3, 3, 2};
		return lengths;
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
