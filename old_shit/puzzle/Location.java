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


public class Location {
	
	int Column;
	int Row;
	
	Location(int r, int c){
		
		this.setRow(r);
		this.setColumn(c);
		
		
		
	}
	
	Location(Location l){
		
		this.setRow(l.getRow());
		this.setColumn(l.getColumn());
		
	}

	public int getColumn() {
		return Column;
	}

	public void setColumn(int column) {
		Column = column;
	}

	public int getRow() {
		return Row;
	}

	public void setRow(int row) {
		Row = row;
	}
	
	public void setLocation(int row, int col){
		
		this.setRow(row);
		this.setColumn(col);
	}
	
	public boolean equals(Location l){//1, Location l2){
		if ( (this.getColumn()==l.getColumn() )&& (this.getRow()==l.getRow()) )
			return true;
		else 
			return false;
	}
	
	public void print(){
		
		System.out.print("\nRow: ");
		System.out.print(this.getRow());
		
		
		System.out.print("\tColumn: ");
		System.out.print(this.getColumn());
		System.out.print("\n");
		

	}
	
	

}
