package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class Hit implements IItem {

	Area hitArea;
	
	public Hit(int x, int y) {
		this.hitArea = new Area(x, y, x, y);
	}
	
	@Override
	public String getType() {
		return "Hit";
	}

	@Override
	public Area getArea() {
		return hitArea;
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
		System.out.println("This is already a hit...");
		return 0;
	}

}
