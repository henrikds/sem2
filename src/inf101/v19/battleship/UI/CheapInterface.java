package inf101.v19.battleship.UI;

import java.util.ArrayList;

import inf101.v19.battleship.grid.Board;
import inf101.v19.battleship.objects.IItem;

public class CheapInterface {

	private int interfaceWidth;
	private int interfaceHeight;
	private int squareWidth = 3;
	private ArrayList<StringBuilder> screen = new ArrayList<StringBuilder>();
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public CheapInterface(int boardWidth, int boardHeight) {
		this.interfaceWidth = boardWidth * squareWidth + 12; //Adding 10 for text beside the board and add 2 for frame
		this.interfaceHeight = boardHeight * 2 * squareWidth + 2; //Times 2 cause there is two boards and add 2 for frame
		
		for (int i = 0; i < interfaceHeight; i++) {
			StringBuilder row = new StringBuilder();
			for (int j = 0; j < interfaceWidth; j++) {
				row.append(' ');
			}
			screen.add(row);
		}
		
		for (int row = 0; row < interfaceHeight; row++) {
			StringBuilder rowString = new StringBuilder(interfaceWidth);
			for (int column = 0; column < interfaceWidth; column++) {
				
				//Make top border
				if (row == 0) {
					for (int n = 0; n < squareWidth; n++) rowString.setCharAt(n, 'x');
				}
				
				//Make bottom border
				else if (row == interfaceHeight -1) {
					for (int n = 0; n < squareWidth; n++) rowString.setCharAt(n, 'x');
				}
				
				//Make left border
				else if (column == 0) {
					rowString.setCharAt(0, 'x');
					for (int n = 1; n < squareWidth; n++) rowString.setCharAt(n, ' ');
				}
				
				//Make right border
				else if (column == interfaceWidth -1) {
					for (int n = 1; n < squareWidth; n++) rowString.setCharAt(n, ' ');
					rowString.setCharAt(-1, 'x');
				}
				
				//Make fill
				else if (column != 0 && column != interfaceWidth -1) {
					for (int n = 0; n < squareWidth; n++) rowString.setCharAt(n, ' ');
				}
				
				else if (column != 0 && row != 0) {
					for (int n = 0; n < squareWidth; n++) rowString.setCharAt(n, ' ');
				}
			}
			screen.add(rowString);
		}
	}
	
	public void drawBoard(Board<IItem> board, boolean playerBoard, boolean hidden) {
		
		final int width = board.getWidth();
		final int height = board.getHeight();
		int xStart = 1;
		int yStart = 1;
		
		if (!playerBoard) {
			xStart = 1 + width +1;//Adding one cause of axis labels
			yStart = 1 + height +1;//Adding one cause of axis labels
		}
		
		//Get row
		for (int y = yStart; y < yStart + height; y++) {
			StringBuilder row = screen.get(y);
			
			if (y == yStart) {
				//Draw x-axis labels with numbers
				for (int x = xStart +squareWidth; x < width + 1; x+=squareWidth) {
					row.setCharAt(x, (char)x);
				}
			}
			
			else {
				for (int x = xStart; x < width + 1; x+=squareWidth) {
					if (x == xStart) {
						row.setCharAt(x, alphabet.charAt(y -yStart -1));
					}
					else {
						//Check what to draw in grid
						int boardX = (x - xStart) / squareWidth;
						int boardY = (y - yStart) / squareWidth;
						IItem itemAtGrid = board.get(boardX, boardY);
						
						if (itemAtGrid != null) {
							row.setCharAt((x + squareWidth) / 2, 'O');
						}
					}
				}
			}
			screen.set(y, row);
		}
	}
	
	public void updateInterface() {
		for (StringBuilder outputRow : screen) System.out.println(outputRow);
	}
}



