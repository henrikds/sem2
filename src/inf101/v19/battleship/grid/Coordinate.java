package inf101.v19.battleship.grid;

public class Coordinate {

	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static int getX(String coord) {
		return Integer.parseInt(String.valueOf(coord.charAt(2)));
	}

	public static int getY(String coord) {
		return alphabet.indexOf(coord.charAt(0)) +1;
	}

	public static String getCoordinate(int x, int y) {
		return alphabet.charAt(y -1) + "-" + x;
	}

}
