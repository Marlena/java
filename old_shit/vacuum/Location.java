package vacuum;

/**
 * CS6523
 * @author Marlena Compton
 * Assignment 1: vacuum
 * Problem 2.6, Location objects used by vacuum
 * Due: Feb. 11
 *
 */


public class Location {
	
	int Column;
	int Row;
	
	Location(int c, int r){
		
		this.setColumn(c);
		this.setRow(r);
		
		
	}
	
	Location(Location l){
		
		this.setColumn(l.getColumn());
		this.setRow(l.getRow());
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
	
	public void setLocation(int col, int row){
		this.setColumn(col);
		this.setRow(row);
	}
	
	public boolean equals(Location l){//1, Location l2){
		if ( (this.getColumn()==l.getColumn() )&& (this.getRow()==l.getRow()) )
			return true;
		else 
			return false;
	}
	
	public void print(){
		
		System.out.print("\nColumn:\t");
		System.out.print(this.getColumn());
		System.out.print("\t");
		
		System.out.print("Row:\t");
		System.out.print(this.getRow());
		System.out.print("\n");
	}

}
