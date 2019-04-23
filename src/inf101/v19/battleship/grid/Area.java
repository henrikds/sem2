package inf101.v19.battleship.grid;

public class Area implements IArea {
	
	private int x;
	private int y;
	private int length;
	private int height;
	
	/**
	 * 
	 * Construct a area with the given dimensions.
	 * 
	 * @param x
	 * @param y
	 * @param height
	 * @param length
	 */
	
	public Area(int x, int y, int length, int height) {
		if(x <= 0 || y <= 0 || length <= 0 || height <= 0)
			throw new IllegalArgumentException();
		
		this.x = x;
		this.y = y;
		this.height = height;
		this.length = length;
		}
	
	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getXStart() {
		return x;
	}

	@Override
	public int getYStart() {
		return y;
	}

	@Override
	public int getXEnd() {
		return x + length - 1;
	}

	@Override
	public int getYEnd() {
		return y + height - 1;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

}
