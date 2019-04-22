package inf101.v19.battleship;

import inf101.v19.battleship.grid.MyGrid;
import inf101.v19.battleship.objects.FishingBoat;
import inf101.v19.battleship.objects.IItem;

public class Main {

	public static void main(String[] args) {
		boolean gameRunning = true;
		
		while (gameRunning) {
//		    initialize the game
			MyGrid<IItem> boardAI = new MyGrid<IItem>(10, 10, null);
			MyGrid<IItem> boardPlayer = new MyGrid<IItem>(10, 10, null);
			FishingBoat stuart = new FishingBoat(2, 3);
			
			boardAI.put(stuart);
			
			gameRunning = false;
			
			for(int y=0; y<10; y++) {
				for (int x=0; x<10; x++) {
					IItem print = boardAI.get(x, y);
					if (print != null) {
						System.out.print("Fish ");
					}
					else System.out.print(print+" ");
				}
				System.out.println("\n");
			}
		}
//		loop until program should stop {
//		    initialize the game;
//		    loop per single game {
//		        reset the board to prepare for a new round;
//		        loop per round {
//		            do things required in each round;
//		        }
//		    }
	}
}
