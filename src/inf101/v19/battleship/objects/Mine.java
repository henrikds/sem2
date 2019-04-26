package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class Mine implements IItem{

	private int health = 2;
	
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
	
	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int hit() {
		this.health =- 1;
		return health;
	}

}
