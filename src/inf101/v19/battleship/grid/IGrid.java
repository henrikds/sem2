package inf101.v19.battleship.grid;

import java.util.ArrayList;
import inf101.v19.battleship.objects.IItem;

public interface IGrid<T> {

	/**
	 * @return The height of the grid.
	 */
	int getHeight();

	/**
	 * @return The width of the grid.
	 */
	int getWidth();

	/**
	 * 
	 * Put item into the grid. 
	 * 
	 * @param item The contents the cell is to have.
	 */
	void put(IItem item);
	
	/**
	 * Find available end points for item
	 * 
	 * @param start coordinate
	 * @param item
	 * 
	 */
	ArrayList<String> possibleEndPoints (String startCoord, IItem item, boolean doValidCheck);

	/**
	 * 
	 * Get the contents of the cell in the given x,y location. 
	 * 
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param x The column of the cell to get the contents of.
	 * @param y The row of the cell to get contents of.
	 */
	IItem get(int x, int y);
	
	/**
	 * 
	 * Draw gird to console
	 * @param If IItems should be hidden
	 * 
	 */
	void draw(boolean hidden);
}
