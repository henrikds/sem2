package inf101.v19.battleship;

import inf101.v19.battleship.UI.CheapInterface;
import inf101.v19.battleship.game.IRules;
import inf101.v19.battleship.game.StandardRules;
import inf101.v19.battleship.grid.MyGrid;
import inf101.v19.battleship.objects.Carrier;
import inf101.v19.battleship.objects.FishingBoat;
import inf101.v19.battleship.objects.IItem;

public class Main {

	public static void main(String[] args) {
		boolean gameRunning = true;
		
		while (gameRunning) {
//		    Initialise the game
			IRules rules = new StandardRules();
			
			int boardWidth = rules.getBoardWidth();
			int boardHeight = rules.getBoardHeight();
			MyGrid<IItem> boardAI = new MyGrid<IItem>(boardWidth, boardHeight, null);
			MyGrid<IItem> boardPlayer = new MyGrid<IItem>(boardWidth, boardHeight, null);
			
			FishingBoat stuart = new FishingBoat(2, 3);
			Carrier kingKong = new Carrier(5,6);
			
			boardAI.put(stuart);
			boardAI.put(kingKong);
			
			gameRunning = false;
			
			CheapInterface UI = new CheapInterface(10, 10);
			
			UI.updateInterface();
			
//			UI.drawBoard(boardAI, false, true);
//			UI.drawBoard(boardPlayer, true, false);
			
			
//			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//			
//			for(int y = 0; y < boardHeight + 1; y++) {
//				
//				if (y != 0) System.out.print(y + "   ");
//				else System.out.print("    ");
//			}
//			System.out.print("\n");
//			
//			for(int y = 0; y < boardHeight; y++) {
//				for (int x = -1; x < boardWidth; x++) {
//					if (x == -1) {
//						System.out.print(alphabet.charAt(y) + " ");
//					}
//					else {
//						IItem print = boardAI.get(x, y);
//						
//						if (print != null) {
//							System.out.print("Item");
//						}
//						else System.out.print("|__|");
//					}
//				}
//				System.out.println("\n");
//			}
//			
//			for(int y = 0; y < boardHeight + 1; y++) {
//				
//				if (y != 0) System.out.print(y + "   ");
//				else System.out.print("    ");
//			}
//			System.out.print("\n");
//			
//			for(int y = 0; y < boardHeight; y++) {
//				for (int x = -1; x < boardWidth; x++) {
//					if (x == -1) {
//						System.out.print(alphabet.charAt(y) + " ");
//					}
//					else {
//						IItem print = boardPlayer.get(x, y);
//						
//						if (print != null) {
//							System.out.print("Item");
//						}
//						else System.out.print("|__|");
//					}
//				}
//				System.out.println("\n");
//			}
		}
	}
}
