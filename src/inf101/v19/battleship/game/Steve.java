package inf101.v19.battleship.game;

import java.util.ArrayList;
import java.util.Random;

import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.grid.Coordinate;
import inf101.v19.battleship.objects.Hit;
import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.objects.IShip;
import inf101.v19.battleship.objects.Miss;

public class Steve implements INonPlayer {

	private Board<IItem> stevesBoard;
	private Random rand = new Random();
	public ArrayList<IShip> stevesShips;
	private ArrayList<String> stevesShots = new ArrayList<String>();;
	
	public Steve(Board<IItem> board, IRules rules) {
		this.stevesBoard = board;
		this.stevesShips = rules.getShips();
	}
	
	@Override
	public Board<IItem> fillBoard() {
		//Fills board with ships
		for (IShip ship : stevesShips) {
			//Runs to possible placement has been found
			while (true) {
				
				//Creates a random coordinate
				String randomStartCoord = randomCoord();
				ArrayList<String> possibleCoords; 
				//Find possible end points
				possibleCoords = stevesBoard.possibleEndPoints(randomStartCoord, ship, false);
				
				//If possible end points
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
	
	@Override
	public ArrayList<IShip> getShips() {
		return stevesShips;
	}
	
	@Override
	public boolean fireAtPlayer(Board<IItem> playerBoard) {
		//finds random coordinate
		int randomX;
		int randomY;
		String shotCoord;
		
		//Make sure Steve has not shot at that coordinate before;
		while (true) {
			randomX = rand.nextInt(playerBoard.getWidth());
			randomY = rand.nextInt(playerBoard.getHeight());
			shotCoord = Coordinate.getCoordinate(randomX +1, randomY +1);
			//If not shot not been made before add shot to list
			if (!stevesShots.contains(shotCoord)) {
				stevesShots.add(shotCoord);
				break;
			}
		}
		System.out.println("\nEnemy shot at " + shotCoord + ".");
		
		//Checks what is at shot location
		IItem item = playerBoard.get(randomX, randomY);
		
		//If there is something on the shot location
		if (item != null) {
			switch (item.getType()) {
				//Hit or miss should not be possible,
				//but in case it is a miss or hit
				//on the location not shot before,
				//it is implemented.
				case "Hit":
					item.hit();
					return false;
				case "Miss":
					item.hit();
					return false;
				default:
					System.out.println("It hits your " + item.getType() + ".");
					System.out.println("Remaining life: " + item.hit());
					playerBoard.put(new Hit(randomX +1, randomY +1));
					return true;
			}
		}
		//If nothing, it's a miss
		playerBoard.put(new Miss(randomX +1, randomY +1));
		System.out.println("Enemy missed.");
		return false;
	}
	
	private String randomCoord() {
		//Creates a random coordinate
		int randomX = rand.nextInt(stevesBoard.getWidth()) +1;
		int randomY = rand.nextInt(stevesBoard.getHeight()) +1;
		String randomCoordinate = Coordinate.getCoordinate(randomX, randomY);
		return randomCoordinate;
	}
}
