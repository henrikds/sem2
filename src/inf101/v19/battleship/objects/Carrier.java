package inf101.v19.battleship.objects;

import inf101.v19.battleship.grid.Area;

public class Carrier implements IShip{

	private Area shipArea;
	private int length = 5;
	private String customName;
	
	public Carrier(int x, int y) {
		if(x < 0 || y < 0)
			throw new IllegalArgumentException();
		
		this.shipArea = new Area(x, y, length, 1);
	}
	
	@Override
	public String getType() {
		return "Carrier";
	}

	@Override
	public Area getArea() {
		return shipArea;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setCustomName(String name) {
		this.customName = name;
		
	}

	@Override
	public String getCustomName(String name) {
		return customName;
	}

}
