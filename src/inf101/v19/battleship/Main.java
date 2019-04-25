package inf101.v19.battleship;

import java.util.ArrayList;
import java.util.Scanner;

import inf101.v19.battleship.game.IRules;
import inf101.v19.battleship.game.StandardRules;
import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.grid.Coordinate;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class Main {

	public static void main(String[] args) {
		boolean gameRunning = true;
		
		while (gameRunning) {
//		    Initialise the game
			
			Scanner in = new Scanner(System.in);
			IRules rules;

			System.out.println("Welcome to BATTLESHIP!");
			System.out.println("Select what rules to play:\n");
			System.out.println("1: Standard rules");
			
			int rulesChosen = in.nextInt();
			while (true) {
				if (rulesChosen == 1) {
					rules = new StandardRules();
					break;
				}
				else {
					System.out.println("Try again:\n");
					System.out.println("1: Standard rules");
					
					rulesChosen = in.nextInt();
				}
			}
			in.nextLine();//Absorbs the "\n" that nextInt() didn't.
			
			int boardWidth = rules.getBoardWidth();
			int boardHeight = rules.getBoardHeight();
			Board<IItem> boardAI = new Board<IItem>(boardWidth, boardHeight, null);
			Board<IItem> boardPlayer = new Board<IItem>(boardWidth, boardHeight, null);
			
			ArrayList<IShip> ships = rules.getShips();
			
			System.out.println("You need to place your ships.");
			System.out.println("These are your ships:\n");
			System.out.println(String.format("%-16s %s\n" , "Ship", "Length" ));
			
			for (int n = 0; n < ships.size(); n++) {
				System.out.println(String.format("%-16s %s" , ships.get(n).getType(), ships.get(n).getLength() ));
			}
			
			System.out.println("\nThis is your board\n");
			boardPlayer.draw(false);
			
			for (IShip ship : ships) {
				System.out.println("\nNow select starting point for your " + ship.getType() + "\n");
				System.out.println("Choose a coordinate on the board based on the axis.");
				System.out.println("(Needs to be typed like this: A-1)");
				
				String coord = in.nextLine();
				ArrayList<String> possibleCords = boardPlayer.possibleEndPoints(coord, ship);
				
				System.out.println("Choose end coordinate for your " + ship.getType() + ".");
				System.out.println("\nPossible end coordinates:\n");
				
				for (int n = 0; n < possibleCords.size(); n++) {
					System.out.println(n +1 + ": " + possibleCords.get(n));
				}
				
				int endCoordChosen = in.nextInt();
				in.nextLine();//Absorbs the "\n" that nextInt() didn't.
				
				int xStart = Coordinate.getX(coord);
				int yStart = Coordinate.getY(coord);
				int xEnd = Coordinate.getX(possibleCords.get(endCoordChosen -1));
				int yEnd = Coordinate.getY(possibleCords.get(endCoordChosen -1));
				
				ship.changePlacement(xStart, yStart, xEnd, yEnd);
				boardPlayer.put(ship);
				boardPlayer.draw(false);
			}
			
//			boardAI.put(stuart);
//			boardAI.put(kingKong);
//			
//			boardAI.draw(false);
//			boardPlayer.draw(false);
			
			gameRunning = false;
			in.close();
			
//			CheapInterface UI = new CheapInterface(10, 10);

//			UI.updateInterface();
			
//			UI.drawBoard(boardAI, false, true);
//			UI.drawBoard(boardPlayer, true, false);
			
		}
	}
}
