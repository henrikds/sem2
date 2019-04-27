package inf101.v19.battleship.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import inf101.v19.battleship.game.IRules;
import inf101.v19.battleship.game.StandardRules;
import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.objects.Carrier;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class FireTest {
	IRules rules = new StandardRules();
	Board<IItem> testBoard = new Board<IItem>(rules.getBoardWidth(), rules.getBoardHeight(), null);
	IShip testCarrier = new Carrier(1,1,5,1);
	    
	@Test
	void fire() {
		//Put carrier into board
		testBoard.put(testCarrier);
		testBoard.draw(false);
		//Fire five shots at carrier
		for (int n = 1; n <= 5; n++) {
			testBoard.fireFromPlayer("A-" + n);
			testBoard.draw(false);
			//If there is no carrier at location
			if (testBoard.get(n -1, 0) == null) {
				fail("There is no boat here.");
			}
			//If shot does not hit carrier
			if (testBoard.get(n -1, 0).getType() != "Hit") {
				fail("Shot did not hit Carrier");
			}
		}
	}
}
