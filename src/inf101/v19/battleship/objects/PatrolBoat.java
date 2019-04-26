package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class PatrolBoat implements IShip {

	private Area shipArea;
	private String customName = this.getType();
	private int health = 2;
	
	public PatrolBoat(int xStart, int yStart, int xEnd, int yEnd) {
		this.shipArea = new Area(xStart, yStart, xEnd, yEnd);
	}
	
	@Override
	public String getType() {
		return "PatrolBoat";
	}

	@Override
	public Area getArea() {
		return shipArea;
	}

	@Override
	public void setCustomName(String name) {
		this.customName = name;
	}

	@Override
	public String getCustomName(String name) {
		return customName;
	}

	@Override
	public int getLength() {
		return 2;
	}	
	
	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public int hit() {
		return this.health =- 1;
	}

	@Override
	public void changePlacement(int xStart, int yStart, int xEnd, int yEnd) {
		this.shipArea = new Area(xStart, yStart, xEnd, yEnd);
		
	}
}
