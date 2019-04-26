package inf101.v19.battleship.objects;

public class ShipFactory {
	
	   public static IShip getShip(String type){
	      if(type == null){
	         return null;
	      }		
	      if(type == ("Carrier")) {
	    	  return new Carrier(1, 1, 1, 1);
	      } 
	      if(type == ("Battleship")) {
		      return new Battleship(1, 1, 1, 1);
		  } 
	      if(type == ("Destroyer")) {
		      return new Destroyer(1, 1, 1, 1);
		  } 
	      if(type == ("Submarine")) {
		      return new Submarine(1, 1, 1, 1);
		  } 
	      if(type == ("PatrolBoat")) {
		      return new PatrolBoat(1, 1, 1, 1);
		  }
	      return null;
	   }
	}