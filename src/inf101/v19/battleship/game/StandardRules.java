package inf101.v19.battleship.game;

import java.util.ArrayList;
import inf101.v19.battleship.objects.IShip;
import inf101.v19.battleship.objects.PatrolBoat;
import inf101.v19.battleship.objects.ShipFactory;
import inf101.v19.battleship.objects.Submarine;
import inf101.v19.battleship.objects.Battleship;
import inf101.v19.battleship.objects.Carrier;
import inf101.v19.battleship.objects.Destroyer;

public class StandardRules implements IRules{

	@Override
	public ArrayList<IShip> getShips() {
		ArrayList<IShip> ships = new ArrayList<IShip>();
		
		ships.add(ShipFactory.getShip("Carrier"));
		ships.add(ShipFactory.getShip("Battleship"));
		ships.add(ShipFactory.getShip("Destroyer"));
		ships.add(ShipFactory.getShip("Submarine"));
		ships.add(ShipFactory.getShip("PatrolBoat"));
		
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

	@Override
	public void printRules() {
		System.out.println("Welcome to the rules.");
		System.out.println("The point of Battleship is to sink the ships of your enemy.");
		System.out.println("You do that by choosing a coordinate on the enemy board to shoot at.");
		System.out.println("If you hit all the coordinates of a ship, it will sink.");
		System.out.println("Every type of ship has a different letter.");
		System.out.println("Example: C - Carrier.");
		System.out.println("If a coordinate is marked with X, it means that the ship that was there");
		System.out.println("has been hit.");
		System.out.println("If the coordinate is empty, then a shot has been fired there, but there was");
		System.out.println("no boat to be hit. It is a miss.");
		System.out.println("A message will be given when you sink an enemy ship.");
		System.out.println("Have fun and enjoy! Try not to lose to a computer.");
		System.out.println("It does shoot randomly around your board.");
	}

}
