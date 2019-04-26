package inf101.v19.battleship.game;

import java.util.ArrayList;

import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class Printer {
	
	public static void printShips(ArrayList<IShip> ships) {
		System.out.println("These are your ships:\n");
		System.out.println(String.format("%-16s %-16s %s\n" , "Ship", "Length" , "Health"));
		
		for (int n = 0; n < ships.size(); n++) {
			IItem ship = ships.get(n);
			System.out.println(String.format("%-16s %-16s %s" , ship.getType(), ship.getLength() ,ship.getHealth()));
		}
	}
	
	public static void printNumericOptions(ArrayList<String> options) {
		for (int n = 0; n < options.size(); n++) {
			System.out.println(n +1 + ": " + options.get(n));
		}
	}
	
	public static void printEndMessage(boolean won) {
		if (won) {
			System.out.println("CONGRATULATIONS!");
			System.out.println("You've sunken all of the enemies ships.");
			System.out.println("I guess I was wrong to doubt you.");
			System.out.println("Try again?\n1: Yes\n2: No");
		}
		else {
			System.out.println("I am truly sorry...\n\n");
			System.out.println("The enemy have sunken all of your ships.");
			System.out.println("We at the army is prepared to give you another chance.");
			System.out.println("Try again?\n1: Yes\n2: No");
		}
	}
}
