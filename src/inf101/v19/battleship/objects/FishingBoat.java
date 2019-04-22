package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class FishingBoat implements IShip{

	private Area shipArea;
	private int length = 2;
	private String customName;
	
	public FishingBoat(int x, int y) {
		if(x < 0 || y < 0)
			throw new IllegalArgumentException();
		
		this.shipArea = new Area(x, y, length, 1);
	}
	
	@Override
	public String getType() {
		return "Fishing Boat";
	}

	@Override
	public int getLength() {
		return length;
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

}
