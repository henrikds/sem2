package inf101.v19.battleship.tests;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import inf101.v19.battleship.game.INonPlayer;
import inf101.v19.battleship.game.IRules;
import inf101.v19.battleship.game.StandardRules;
import inf101.v19.battleship.game.Steve;
import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class ShipPlacementAITest {
	IRules rules = new StandardRules();
	Board<IItem> testBoard = new Board<IItem>(rules.getBoardWidth(), rules.getBoardHeight(), null);
	ArrayList<IShip> testShips = rules.getShips();
	INonPlayer testBot = new Steve(testBoard, rules);
	    
	@Test
	void fire() {
		testBot.fillBoard();
		int numberOfShipCoords = 0;
		int expectedNumberOfShipCoords = 0;
		//Loop through whole board counting items
		for (int x = 0; x < testBoard.getWidth(); x++) {
			for (int y = 0; y < testBoard.getHeight(); y++) {
				if (testBoard.get(x, y) != null) numberOfShipCoords++;
			}
		}
		//Expected items
		for (IShip ship : testShips) expectedNumberOfShipCoords += ship.getLength();
		
		//If number of expected items is equal to actual items
		if (numberOfShipCoords != expectedNumberOfShipCoords) {
			fail("Not enough ship coordinates.");
		}
		testBoard.draw(false);
	}
}