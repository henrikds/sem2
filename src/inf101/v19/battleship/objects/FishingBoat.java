package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class FishingBoat implements IShip{

	private Area shipArea;
	private String customName;
	private int health = 1;
	
	public FishingBoat(int xStart, int yStart, int xEnd, int yEnd) {
		
		this.shipArea = new Area(xStart, yStart, xEnd, yEnd);
	}
	
	@Override
	public String getType() {
		return "Fishing Boat";
	}

	@Override
	public void setCustomName(String name) {
		customName = name;
	}

	@Override
	public String getCustomName(String name) {
		return customName;
	}

	@Override
	public Area getArea() {
		return shipArea;
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
	public void changePlacement(int xStart, int yStart, int xEnd, int yEnd) {
		this.shipArea = new Area(xStart, yStart, xEnd, yEnd);
	}

	@Override
	public int hit() {
		return 0;
	}

}
