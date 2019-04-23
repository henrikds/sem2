package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public interface IItem {
		
		/**
		 * @return The name of the item type.
		 */
		String getType();
		
		/**
		 * @return The area of the item.
		 */
		Area getArea();
}