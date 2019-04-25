package inf101.v19.battleship.grid;

public class Area implements IArea {
	
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	
	/**
	 * 
	 * Construct a area with the given dimensions.
	 * 
	 * @param xStart
	 * @param yStart
	 * @param xEnd
	 * @param yEnd
	 */
	
	public Area(int xStart, int yStart, int xEnd, int yEnd) {
		if(xStart <= 0 || yStart <= 0 || xEnd <= 0 || yEnd <= 0)
			throw new IllegalArgumentException();
		
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		}

	@Override
	public int getXStart() {
		return xStart;
	}

	@Override
	public int getYStart() {
		return yStart;
	}

	@Override
	public int getXEnd() {
		return xEnd;
	}

	@Override
	public int getYEnd() {
		return yEnd;
	}
}
