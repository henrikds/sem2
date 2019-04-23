package inf101.v19.battleship.grid;

import java.util.ArrayList;
import java.util.List;

import inf101.v19.battleship.objects.IItem;

/**
 * 
 * A Grid contains a set of cells in a square 2D matrix.
 *
 */
public class MyGrid<T> implements IGrid<T> {
	private List<IItem> cells;
	private int height;
	private int width;

	/**
	 * 
	 * Construct a grid with the given dimensions.
	 * 
	 * @param width
	 * @param height
	 * @param initElement
	 *            What the cells should initially hold (possibly null)
	 */
	public MyGrid(int width, int height, IItem item) {
		if(width <= 0 || height <= 0)
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

		for (int y = yStart; y <= yEnd; y++) {
			for (int x = xStart; x <= xEnd; x++) {
				cells.set(x + (y * width), item);
			}
		}
	}

	@Override
	public IItem get(int x, int y) {
		if(x < 0 || x >= width)
			throw new IndexOutOfBoundsException();
		if(y < 0 || y >= height)
			throw new IndexOutOfBoundsException();

		return cells.get(y + (x * width));
	}

//	@Override
//	public IGrid<T> copy() {
//		MyGrid<T> newGrid = new MyGrid<>(getWidth(), getHeight(), null);
//
//		for (int x = 0; x < width; x++)
//			for(int y = 0; y < height; y++)
//				newGrid.set(x,  y,  get(x, y));
//		return newGrid;
//	}
}