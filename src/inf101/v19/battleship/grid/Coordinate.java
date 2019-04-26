package inf101.v19.battleship.grid;

public class Coordinate {

	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static int getX(String coord) {
		return Integer.parseInt(String.valueOf(coord.substring(2, coord.length())));
	}

	public static int getY(String coord) {
		return alphabet.indexOf(coord.charAt(0)) +1;
	}

	public static String getCoordinate(int x, int y) {
		return alphabet.charAt(y -1) + "-" + x;
	}
	
	public static <T> boolean validCoord(String coord, Board<T> board) {
		int x;
		int y;
		try {
			x = getX(coord);
			y = getY(coord);
		}
		catch (Exception e) {
			System.out.println("Please type coordinate correctly.");
			return false;
		}
		int height = board.getHeight();
		int width = board.getWidth();
		if (x < 1 || x > width || y < 1 || y > height) {
			System.out.println("Not a valid coordinate.");
			return false;
		}
		return true;
	}

}