package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class Submarine implements IShip {

	private Area shipArea;
	private String customName = this.getType();
	private int health = 3;
	
	public Submarine(int xStart, int yStart, int xEnd, int yEnd) {
		this.shipArea = new Area(xStart, yStart, xEnd, yEnd);
	}
	
	@Override
	public String getType() {
		return "Submarine";
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
		return 3;
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
