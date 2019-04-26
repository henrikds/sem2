package inf101.v19.battleship.tests;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import inf101.v19.battleship.game.IRules;
import inf101.v19.battleship.game.StandardRules;
import inf101.v19.battleship.grid.Board;

//public class FireTest {
//	IRules rules = new StandardRules();
//	Board testBoard = new Board(rules.getBoardWidth(), rules.getBoardHeight(), null);
//	
//	    
//	    @Test
//	    void fire() {
//	        
//	        
//	        if (items.size() != 4) {
//	        	fail("Not all items added.");
//	        }
//	        
//	        for (int i = 0; i < items.size() - 1; i++) {
//	        	if (items.get(i).compareTo(items.get(i + 1)) < 0) {
//	        		fail("Not sorted correct.");
//	        	}
//	        }
//	    }
