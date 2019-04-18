package inf101.v19.battleship.grid;

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
	 * Set the contents of the cell in the given x,y location. 
	 * 
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param x The column of the cell to change the contents of.
	 * @param y The row of the cell to change the contents of.
	 * @param item The contents the cell is to have.
	 */
	void set(int x, int y, IItem item);

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
	 * Make a copy
	 *
	 * @return A fresh copy of the grid, with the same elements
	 */
	IGrid<T> copy();

}
