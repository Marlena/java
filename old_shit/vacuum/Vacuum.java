package vacuum;

import java.util.*;
import floor.*;

/**
 * CS6523
 * @author Marlena Compton
 * Assignment 1: vacuum
 * Problem 2.6, vacuum object
 * Due: Feb. 11
 *
 */


public class Vacuum {
	
	
	Floor theFloor;
	
	private static int CLEAN = 0;
	private static int DIRTY = 1;

	
	int vacuumNumRow;
	int vacuumNumCol;
	
	int theVacuumSize;//total number of squares for the vacuum
	
	Location homeLocation;
	char orientation; //represented by ^,v,<,>

	LocationLookupTable nextMovesTable;
	
	//These two data members represent where the agent is currently, and what it knows about that location
	Location currentLocation;
	boolean currentLocationIsClean;

	
	
	 //This array list represents everything the agent has seen so far. 
	//A possible extra would be to include whether each location was dirty or clean.  With that info, the agent could eventually
	//predict where the dirt was more likely to occur
	ArrayList <Location> pastLocations; 
	
	
	LocationLookupTable nextMoveLookup;
	
	
	//Success for the agent occurs when this member is set to true;
	boolean time2GoHome;
	
	
	
	//This matrix contains a char representing the vacuums location and orientation.  
	//The vacuum is represented by the following characters ^v<>
	char theVacuum [][];

	public Vacuum(){
		
		this.initFloor();
		
		this.initVacuum();  //initialize the vacuum
		
		this.go();
		
		
		
		
		
	}
	
	/**
	 * The nextMovesTable maps where the vacuum can move from any of its other locations.  Since there are only four 
	 * squares, there aren't many entries for this table.
	 */
	public LocationLookupTable getNextMovesTable() {
		return nextMovesTable;
	}

	public void setNextMovesTable(LocationLookupTable nextMovesTable) {
		this.nextMovesTable = nextMovesTable;
	}

	
	public void initFloor(){
		
		Random generator = new Random();
		
		int numDirty = generator.nextInt(4);
		int percentDirty;
		
		switch(numDirty){
		
		case 0:		percentDirty = 25; break;
			
		case 1:		percentDirty = 50; break;
		
		case 2:		percentDirty = 75; break;
			
		case 3:		percentDirty = 100; break;
		
		default:	percentDirty = 50; break;//percent will be 50)
		}///end of switch statement
		
		theFloor = new Floor (2,2,percentDirty);  //default constructor of floor creates a 2x2 floor with 25% chance of being dirty

		
	}//end of init floor
	
	/**
	 * Everything to do with the vacuum matrix is set up here.
	 */
	public void initVacuum(){
		
		this.setVacuumNumCol(2);
		this.setVacuumNumRow(2);
		this.setTheVacuumSize(this.getVacuumNumCol(), this.vacuumNumRow);
		
		nextMovesTable = new LocationLookupTable();
		
		homeLocation = new Location(0,0);
		
		currentLocation = new Location (this.getHomeLocation());
		
		pastLocations = new ArrayList<Location>();
		
		
		this.setOrientation('<');
		
		this.setTime2GoHome(false);
		
		theVacuum = new char [this.getVacuumNumCol()][this.getVacuumNumRow()];
		
		/**
		 * The next four lines set up the vacuum matrix.  Empty spaces are added to keep everything aligned for 
		 * printing purposes.
		 */
		
		this.setVacuumLocationVal(this.getOrientation(), this.getHomeLocation());
		this.setVacuumLocationVal(' ', 1, 0);
		
		this.setVacuumLocationVal(' ', 0, 1);
		this.setVacuumLocationVal(' ', 1, 1);


		
		
	}
	
	
	
	public int getVacuumNumRow() {
		return vacuumNumRow;
	}



	public void setVacuumNumRow(int vacuumNumRow) {
		this.vacuumNumRow = vacuumNumRow;
	}



	public int getVacuumNumCol() {
		return vacuumNumCol;
	}


	public void setVacuumNumCol(int vacuumNumCol) {
		this.vacuumNumCol = vacuumNumCol;
	}



	public int getTheVacuumSize() {
		return theVacuumSize;
	}



	public void setTheVacuumSize(int col, int row) {
		this.theVacuumSize = col*row;
	}



	public char getOrientation() {
		return orientation;
	}



	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}



	public Location getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(Location homeLocation) {
		this.homeLocation = homeLocation;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public void setCurrentLocation(int col, int row) {
		this.currentLocation.setLocation(col, row);
	}

	public boolean getCurrentLocationIsClean() {
		return currentLocationIsClean;
	}

	public void setCurrentLocationIsClean(boolean currentLocationIsClean) {
		this.currentLocationIsClean = currentLocationIsClean;
	}

	public ArrayList<Location> getPastLocations() {
		return pastLocations;
	}

	public void setPastLocations(ArrayList<Location> pastLocations) {
		this.pastLocations = pastLocations;
	}
	
	public void addPastLocation(Location l){
		
		this.pastLocations.add(l);
	}

	public boolean isTime2GoHome() {
		return time2GoHome;
	}

	public void setTime2GoHome(boolean time2GoHome) {
		this.time2GoHome = time2GoHome;
	}

	public Floor getTheFloor() {
		return theFloor;
	}

	public void setTheFloor(Floor theFloor) {
		this.theFloor = theFloor;
	}


	public char[][] getTheVacuum() {
		return theVacuum;
	}

	public void setTheVacuum(char[][] theVacuum) {
		this.theVacuum = theVacuum;
	}

	public void setVacuumLocationVal (char c, Location l){
		
		theVacuum[l.getColumn()][l.getRow()] = c;
	}
	
	public void setVacuumLocationVal(char c, int col, int row){
		
		theVacuum[col][row] = c;
		
	}
	
	public char getVacuumLocationVal(int col, int row){
		
		return theVacuum[col][row];
		
	}
	
	public char getVacuumLocationVal(Location l){
			
			return theVacuum[l.getColumn()][l.getRow()];
			
		}
		
	public void printVacuum(){
		
		System.out.println("The vacuum's current Location is:\t");
		this.getCurrentLocation().print();
		
		
		//print the floor
		for (int i=0; i<this.getVacuumNumCol(); i++){
			
			for (int j=0; j< this.getVacuumNumRow(); j++){
				
				System.out.print(this.getTheFloor().getFloorLoc(i, j));
				//print the location of the vacuum on the floor
				if (this.getCurrentLocation().getColumn() == i && this.getCurrentLocation().getRow()==j){
					System.out.print(this.getOrientation());
				
				}
				else{
					System.out.print(" ");
				}
				
			}
		
			
		System.out.print("\n");
		}//end of the for loop 
		
		System.out.print("\n");
		
	}
	

	/**
	 * Vacuum checks where it is in the matrix and decides where it can move next.  The only moves it can execute are up, down, left, right.
	 * It cannot move diagonally.  Example:  if the vacuum is in its home position of [0][0],  it can only execute a move to the right or a move down.
	 * The choice will be randomly from the two selections possible for the position.  If the vacuum has already been to 1, the other will be chosen.
	 * @return Location
	 */
	public Location decideNextMove(Location l){
		
		//change so that this doesn't care about home or not home, it only cares if it's 
		//visited every location 
		
		//after that create a loop in go() that will go home
		//keep subtracting row and column until vacuum is at 00
		
		boolean haveIBeenThere = true;
		Location nextLoc;
		do {
		
			nextLoc=nextMovesTable.getRandomLocationValue(l);
			//check if location is in past locations list

			
			if ( nextLoc.equals(this.getHomeLocation() )&&  this.pastLocations.size()>3)//nextLoc is home && pastLocations.length==3 means time to go home

				haveIBeenThere=false; //time to go home so break out of the loop and return home as location

			else if (haveIBeenThere(nextLoc));//nextLoc is NOT IN pastLocations
			{
				haveIBeenThere = true;
			}
			
			//have haven't been too this location before
			haveIBeenThere=false;
			
			
		}while (haveIBeenThere == true);		
		
		return nextLoc;//it has been decided to move to this location next
		
	}
	
	/**
	 * Does a sequential search of the items in the pastLocations array list.  Since there will not be more than 3 or 4 items, 
	 * sequential search should be fine.  If the square were to be larger, another search algorithm might be preferred.
	 * @return
	 */
	public boolean haveIBeenThere(Location l){
		
		
		for (int i=0; i < this.getPastLocations().size(); i++){
			
			if (this.getPastLocations().get(i).equals(l) ){
				return true;
			}
			
			
		}
		
		return false;
		
	}
	

	
	/**
	 * Sets the location of the floor to CLEAN
	 */
	public void cleanFloorSquare(Location l){
		
		//set the floor location to clean
		this.theFloor.setFloorLoc(l.getColumn(), l.getRow(), CLEAN);
		
	}
	
	public void cleanFloorSquare(int col, int row){
		
		//set the floor location to clean
		this.theFloor.setFloorLoc(col, col, CLEAN);
		
	}
	
	/**
	 * Where the vacuum meets the floor.  This method represents the main algorithm for cleaning the floor.
	 * The initial state of the vacuum world gets printed out followed by each iteration of the main loop.
	 * The vacuum will appear as this character: < in its current floor location.
	 * 
	 * Floor locations:
	 * 						[0,0][1,0]
	 * 						[0,1][1,1]
	 * 
	 * Possible moves:			[0][0] -> down || right
	 * 									 [0][1]  [1][0]
	 * 							[1][0] -> down || left
	 * 									 [1][1]  [0][0]
	 * 							[0][1] -> up  || right
	 * 									 [0][0]  [1][1]
	 * 							[1][1] -> up  || left
	 * 									 [1][0]  [0][1]
	 * 
	 */
	public void go(){
		
		//print the vacuum's initial state
		System.out.println("Vacuum is initialized");
		this.printVacuum();
		
		//vacuum works in this loop until its success condition is met and it is time to go home
		while (this.time2GoHome == false){
			
			//if the floor is dirty, clean
			if (this.theFloor.getFloorLoc(this.currentLocation.getColumn(), this.currentLocation.getRow() ) == DIRTY) {
				
				this.cleanFloorSquare(this.getCurrentLocation());
			}
			
			//add currentLocation to list of past locations
			//if and only if the location isn't already in the list
			if(this.haveIBeenThere(this.getCurrentLocation())==false){
				this.pastLocations.add(this.currentLocation);
			}
			
			
			
			this.printVacuum();
			//this.setTime2GoHome(true);

			//decide next location 
			Location nextLocation = this.decideNextMove(this.getCurrentLocation());
			
			//next location becomes current location
			this.setCurrentLocation(nextLocation);
			this.moveTheVacuum(this.getCurrentLocation());
			
			if (this.currentLocation.equals(this.getHomeLocation()) && (this.pastLocations.size()>3)){
				this.setTime2GoHome(true);
				//execute goHome()
				this.goHome();
			}
			
			
		}//end while loop

		
	}//end go method

	
	public void goHome(){
		
		System.out.println("The vacuum is going home");
		//move to home row
		//base case = location i0
		do{
			
			Location nextLoc = new Location(this.getCurrentLocation());
			
			int nextRow = this.getCurrentLocation().getRow();
			if (nextRow == 0){
				
				System.out.println("Already on row 0");
				
			}
			else{
			
			nextRow--;
			System.out.println("Now going back to row 0");
			nextLoc.setRow(nextRow);
			
			this.setCurrentLocation(nextLoc);
			this.moveTheVacuum(this.getCurrentLocation());
			
			this.printVacuum();
			}
			
		}while (this.currentLocation.getRow()>0);//not on row 0
		
		
		do {
			
			Location nextLoc = new Location(this.getCurrentLocation());
			
			int nextColumn = this.getCurrentLocation().getColumn();
			if (nextColumn == 0){
				
				System.out.println("Already on column 0");
				
			}
			else{
			
			nextColumn--;
			System.out.println("Now going back to row 0");
			nextLoc.setRow(nextColumn);
			
			this.setCurrentLocation(nextLoc);
			this.moveTheVacuum(this.getCurrentLocation());
			
			this.printVacuum();
			}			
			
			System.out.println("\nThe vacuum is home.\n");
			this.printVacuum();
			
		}while (this.getCurrentLocation().getColumn()>0);//not at column 0
		
		
		//move to home column
		//base case = location 00
		
	}
	
	

	/**
	 * Changes the position of the char in the vacuum matrix to Location l.
	 */	
	public void moveTheVacuum(Location l){
		
		//set the vacuum matrix to all white space
		this.setVacuumLocationVal(' ', 0, 0);
		this.setVacuumLocationVal(' ', 0, 1);
		this.setVacuumLocationVal(' ', 1, 0);
		this.setVacuumLocationVal(' ', 1, 1);
		
		//reset the vacuum location within the vacuum matrix
		this.setVacuumLocationVal('<', l);
		
		
	}
	
	
	/**
	 * Changes the position of the char in the vacuum matrix to col, row.
	 */	
	public void moveTheVacuum(int col, int row){
		
		Location l = new Location(col,row);
		
		//set the vacuum matrix to all white space
		this.setVacuumLocationVal(' ', 0, 0);
		this.setVacuumLocationVal(' ', 0, 1);
		this.setVacuumLocationVal(' ', 1, 0);
		this.setVacuumLocationVal(' ', 1, 1);
		
		//reset the vacuum location within the vacuum matrix
		this.setVacuumLocationVal('<', l);
		
		
	}


	
	
	

}//end outer class
