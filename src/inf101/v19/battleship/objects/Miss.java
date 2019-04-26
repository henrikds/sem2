package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class Miss implements IItem {

	Area missArea;
	
	public Miss(int x, int y) {
		this.missArea = new Area(x, y, x, y);
	}
	
	@Override
	public String getType() {
		return "Miss";
	}

	@Override
	public Area getArea() {
		return missArea;
	}

	@Override
	public int getLength() {
		return 1;
	}

	@Override
	public int getHealth() {
		return 0;
	}

	@Override
	public int hit() {
		System.out.println("This is already a miss...");
		return 0;
	}

}
