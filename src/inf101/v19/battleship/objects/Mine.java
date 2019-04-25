package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class Mine implements IItem{

	@Override
	public String getType() {
		return "Mine";
	}

	@Override
	public Area getArea() {
		return null;
	}

	@Override
	public int getLength() {
		return 1;
	}

}
