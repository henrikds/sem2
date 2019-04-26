package inf101.v19.battleship.game;

import java.util.ArrayList;
import java.util.Random;

import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.grid.Coordinate;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;

public class Steve implements INonPlayer {

	private Board<IItem> stevesBoard;
	private ArrayList<IShip> stevesShips;
	private Random rand = new Random();
	
	public Steve(Board<IItem> board, IRules rules) {
		this.stevesBoard = board;
		this.stevesShips = rules.getShips();
	}
	
	@Override
	public Board<IItem> fillBoard() {
		for (IShip ship : stevesShips) {
			while (true) {
				
				String randomStartCoord = randomCoord();
				ArrayList<String> possibleCoords; 
				possibleCoords = stevesBoard.possibleEndPoints(randomStartCoord, ship, false);
				
				if (!possibleCoords.isEmpty()) {
					int n = rand.nextInt(possibleCoords.size());
					
					int xStart = Coordinate.getX(randomStartCoord);
					int yStart = Coordinate.getY(randomStartCoord);
					int xEnd = Coordinate.getX(possibleCoords.get(n));
					int yEnd = Coordinate.getY(possibleCoords.get(n));
					ship.changePlacement(xStart, yStart, xEnd, yEnd);
					
					this.stevesBoard.put(ship);
					break;
				}
			}
		}
		return stevesBoard;
	}
	
	private String randomCoord() {
		int randomX = rand.nextInt(stevesBoard.getWidth()) +1;
		int randomY = rand.nextInt(stevesBoard.getHeight()) +1;
		String randomCoordinate = Coordinate.getCoordinate(randomX, randomY);
		return randomCoordinate;
	}
}
