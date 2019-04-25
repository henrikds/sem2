package inf101.v19.battleship.grid;

import java.util.ArrayList;
import java.util.List;

import inf101.v19.battleship.objects.IItem;
import inf101.v19.battleship.grid.Coordinate;

/**
 * 
 * A Grid contains a set of cells in a square 2D matrix.
 *
 */
public class Board<T> implements IGrid<T> {
	private List<IItem> cells;
	private int height;
	private int width;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 
	 * Construct a grid with the given dimensions.
	 * 
	 * @param width
	 * @param height
	 * @param item
	 *            What the cells should initially hold (possibly null)
	 */
	public Board(int width, int height, IItem item) {
		if(width <= 0 || height <= 0 || width > 27 || height > 27)
			throw new IllegalArgumentException();

		this.height = height;
		this.width = width;
		cells = new ArrayList<IItem>(height * width);
		for (int i = 0; i < height * width; ++i) {
			cells.add(item);
		}
	}
	
	@Override
	public int getHeight() {
		return width;
		}

	@Override
	public int getWidth() {
		return height;
	}

	@Override
	public void put(IItem item) {
		int yStart = item.getArea().getYStart() -1;
		int xStart = item.getArea().getXStart() -1;
		int yEnd = item.getArea().getYEnd() -1;
		int xEnd = item.getArea().getXEnd() -1;
		
		//Cheap fix for for-loop to be able to put
		//ship into board from down-to-up
		if (xStart > xEnd) {
			int xTemp = xEnd;
			xEnd = xStart;
			xStart = xTemp;
		}
		
		//Same with y
		if (yStart > yEnd) {
			int yTemp = yEnd;
			yEnd = yStart;
			yStart = yTemp;
		}

		for (int y = yStart; y <= yEnd; y++) {
			for (int x = xStart; x <= xEnd; x++) {
				cells.set(x + (y * width), item);
			}
		}
	}
	
	@Override
	public ArrayList<String> possibleEndPoints(String startCoord, IItem item) {
		ArrayList<String> endPoints = new ArrayList<String>();
		int itemLength = item.getLength();
		
		final int xStart = Coordinate.getX(startCoord);
		final int yStart = Coordinate.getY(startCoord);
		
		int xEnd = xStart + itemLength -1;
		int yEnd = yStart;
		
		if (!(xEnd < 1 || yEnd < 1 || xEnd > width || yEnd > height)) {
			for (int n = 0; n < itemLength; n++) {
				if (this.get(xEnd - n, yEnd) != null) break;
				if (n == itemLength -1) {
					endPoints.add(Coordinate.getCoordinate(xEnd, yEnd));
				}
			}
		}
		
		xEnd = xStart - itemLength +1;
		yEnd = yStart;
		
		if (!(xEnd < 1 || yEnd < 1 || xEnd > width || yEnd > height)) {
			for (int n = 0; n < itemLength; n++) {
				if (this.get(xEnd + n, yEnd) != null) break;
				if (n == itemLength -1) {
					endPoints.add(Coordinate.getCoordinate(xEnd, yEnd));
				}
			}
		}
		
		xEnd = xStart;
		yEnd = yStart + itemLength -1;
		
		if (!(xEnd < 1 || yEnd < 1 || xEnd > width || yEnd > height)) {
			for (int n = 0; n < itemLength; n++) {
				if (this.get(xEnd, yEnd - n) != null) break;
				if (n == itemLength -1) {
					endPoints.add(Coordinate.getCoordinate(xEnd, yEnd));
				}
			}
		}
		
		xEnd = xStart;
		yEnd = yStart - itemLength +1;
		
		if (!(xEnd < 1 || yEnd < 1 || xEnd > width || yEnd > height)) {
			for (int n = 0; n < itemLength; n++) {
				if (this.get(xEnd, yEnd + n) != null) break;
				if (n == itemLength -1) {
					endPoints.add(Coordinate.getCoordinate(xEnd, yEnd));
				}
			}
		}
		
		return endPoints;
	}

	@Override
	public IItem get(int x, int y) {
		if(x < 0 || x > width)
			throw new IndexOutOfBoundsException();
		if(y < 0 || y > height)
			throw new IndexOutOfBoundsException();

		return cells.get(x + (y * width));
	}
	
	public void draw(boolean hidden) {
		
		//Draw x-axis values (numbers)
		for(int x = 0; x < width + 1; x++) {
			
			if (x != 0) {
				if (x < 9) System.out.print(x + "   ");
				else System.out.print(x + "  ");
				}
			else System.out.print("    ");
		}
		System.out.print("\n");
		
		for(int y = 0; y < height; y++) {
			for (int x = -1; x < width; x++) {
				//Draw y-axis value (letter)
				if (x == -1) {
					System.out.print(alphabet.charAt(y) + " ");
				}
				else {
					IItem item = this.get(x, y);
					
					if (item != null) {
						System.out.print(" <> ");
					}
					else System.out.print("|__|");
				}
			}
			System.out.println("\n");
		}
	}
}
