package inf101.v19.battleship;

import java.util.ArrayList;
import java.util.Scanner;

import inf101.v19.battleship.game.Events;
import inf101.v19.battleship.game.INonPlayer;
import inf101.v19.battleship.game.IRules;
import inf101.v19.battleship.game.Printer;
import inf101.v19.battleship.game.StandardRules;
import inf101.v19.battleship.game.Steve;
import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.grid.Coordinate;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class Main {

	public static void main(String[] args) {
		boolean gameRunning = true;
		Scanner in = new Scanner(System.in);
		
		while (gameRunning) {

			IRules rules;

			System.out.println("Welcome to BATTLESHIP!");
			System.out.println("Select which rules to play:\n");
			System.out.println("1: Standard rules");
			
			int rulesChosen = in.nextInt();
			in.nextLine();//Consumes the "\n" that nextInt() didn't.
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
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Do you know the rules of the game?");
			System.out.println("1. Yes    2. No");
			int helpRules = in.nextInt();
			in.hasNextLine();//Consumes the "\n" that nextInt() didn't.
			
			if (helpRules == 2) {
				rules.printRules();
			}
			
			System.out.println("Type anything to continue.");
			in.nextLine();
			in.nextLine();

			
			int boardWidth = rules.getBoardWidth();
			int boardHeight = rules.getBoardHeight();
			Board<IItem> boardAI = new Board<IItem>(boardWidth, boardHeight, null);
			Board<IItem> boardPlayer = new Board<IItem>(boardWidth, boardHeight, null);
			INonPlayer gerald = new Steve(boardAI, rules);
			boardAI = gerald.fillBoard();
			ArrayList<IShip> ships = rules.getShips();
			
			//
			//PLACING SHIPS
			//
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("You need to place your ships.");
			
			Printer.printShips(ships);
			
			System.out.println("\nThis is your board:\n");
			boardPlayer.draw(false);
			
			
			for (IShip ship : ships) {
				System.out.println("\nNow select starting point for your " + ship.getType() + "\n");
				System.out.println("Choose a coordinate on the board based on the axis.");
				System.out.println("(Needs to be typed like this: A-1)");
				
				String coord = in.nextLine();
				
				while (true) {
					ArrayList<String> possibleCoords = boardPlayer.possibleEndPoints(coord, ship, true);
				
					if (possibleCoords == null);
					else if (!possibleCoords.isEmpty()) {
						System.out.println("\nChoose end coordinate for your " + ship.getType() + ".");
						System.out.println("\nPossible end coordinates:");
						
						Printer.printNumericOptions(possibleCoords);
						
						int endCoordChosen;
						while (true) {
							System.out.println("\n");
							endCoordChosen = in.nextInt();
							in.nextLine();//Consumes the "\n" that nextInt() didn't.
							if (endCoordChosen <= possibleCoords.size()) break;
							System.out.println("Try again.");
						}
						
						int xStart = Coordinate.getX(coord);
						int yStart = Coordinate.getY(coord);
						int xEnd = Coordinate.getX(possibleCoords.get(endCoordChosen -1));
						int yEnd = Coordinate.getY(possibleCoords.get(endCoordChosen -1));
						
						ship.changePlacement(xStart, yStart, xEnd, yEnd);
						boardPlayer.put(ship);
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						Printer.printShips(ships);
						System.out.println("\n\n");
						boardPlayer.draw(false);

						break;
					}
					System.out.println("No possible placments with that start coordinate.");
					coord = in.nextLine();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				}
			}
			
			//
			//ROUNDS BEGINS
			//
			System.out.println("Great! You have now placed your ships.");
			System.out.println("\nIt is now time to start attacking another board.");
			System.out.println("But be aware, they will attack you too.\n");
			
			while (true) {
				//
				//Player turn
				//
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
				Printer.printShips(ships);

				System.out.println("\n\n");
				System.out.println("ENEMY BOARD");
				boardAI.draw(true);
				System.out.println("YOUR BOARD");	
				boardPlayer.draw(false);

				System.out.println("\nCoordinate to fire:");
				in.nextLine();
				String shot = in.nextLine();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				boardAI.fireFromPlayer(shot);
				
				//
				//Non-player turn
				//
				gerald.fireAtPlayer(boardPlayer);
				
				//
				//Check events of turn
				//
				System.out.println("\n\n");
				Events.sunkenShip(gerald.getShips());
				//Check if player won
				boolean won = Events.winCondition(gerald.getShips());
				//Check if non-player won
				boolean lost = Events.winCondition(ships);
				if (won || lost) {
					System.out.println("\n\n");
					Printer.printEndMessage(won);
					int tryAgain = in.nextInt();
					in.hasNextLine();//Consumes the "\n" that nextInt() didn't.
					if (tryAgain == 1) {
						gameRunning = true;
						break;
					}
					else {
						gameRunning = false;
						in.close();
						break;
					}
				}
				
				System.out.println("\nType anything to continue to next turn.");
				in.next();
				
				
			}
		}
	}
}
