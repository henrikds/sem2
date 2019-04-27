package inf101.v19.battleship.game;

import java.util.ArrayList;

import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class Events {
	
	public static boolean winCondition(ArrayList<IShip> ships) {
		//Check the combined health of all ships
		int combinedHealth = 0;
		for (int n = 0; n < ships.size(); n++) {
			IItem ship = ships.get(n);
			combinedHealth = combinedHealth + ship.getHealth();
		}
		//If it is 0, game is over
		if (combinedHealth == 0) return true;
		return false;
	}
	
	public static void sunkenShip(ArrayList<IShip> ships) {
		//Checks if any ship is at 0 health
		for (int n = 0; n < ships.size(); n++) {
			IItem ship = ships.get(n);
			if (ship.getHealth() == 0) {
				System.out.println("You've sunken the enemy " + ship.getType() + ".");
			}
		}
	}

}
