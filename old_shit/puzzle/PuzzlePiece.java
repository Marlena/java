package puzzle;
/**
 * @course CS6523
 * @author MarlenaCompton
 * @assignment 2
 * @duedate 20080228
 * 
 * Signature:
 * 
 * Score:
 *
 */
/**
 * Puzzle pieces contain the piece's symbol for output and the current location of the piece.  Past locations are not maintained
 * 
 * @author marlena
 *
 */
public class PuzzlePiece {
	
	char mySymbol;
	Location myLocation;
	
	
	public PuzzlePiece(char mySymbol, Location myLocation){
		
		if ( (myLocation.getRow()> 0) && (myLocation.getColumn()>0) ){
		
		this.setMyLocation(myLocation);
		this.setMySymbol(mySymbol);
		}
		else{
			System.out.print("FOR PIECE ");
			System.out.print(mySymbol);
			System.out.print(" LOCATION CANNOT HAVE ROW OR COLUMN OF 0");
		}
	}
	
	public char getMySymbol() {
		return mySymbol;
	}
	public void setMySymbol(char mySymbol) {
		this.mySymbol = mySymbol;
	}
	public Location getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
	public void moveNorth(){
		
		int newRow = this.getMyLocation().getRow() + 1;
		
		Location l = new Location(newRow, this.getMyLocation().getColumn());
		
		this.setMyLocation(l);
		
	}
	
	public void moveSouth(){
		
		int newRow = this.getMyLocation().getRow() - 1;
		
		Location l = new Location(newRow, this.getMyLocation().getColumn());
		
		this.setMyLocation(l);
		
	}
	
	

}
