package puzzle;

import java.util.*;
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
	

public class Board {
	

	private int BoardRow,BoardCol;//number of rows and columns
	private int numOccupied;//represents the number of occupied squares
	private char [][] theBoard;
	private int BoardSize; //indicates the number of squares used for calculating dirty squares
	private static char OPEN = '-';
	private static int OCCUPIED = 1;


	
	/**
	 * Generates a Board of size n x m where n and m are any number between 
	 * 8 and 15 inclusive.  5% of the Board will be dirty
	 * @return
	 */
	public Board(int boardSize, ArrayList <PuzzlePiece> myPieces){
		
		this.setBoardSize(boardSize);
		this.setBoardCol(this.getBoardSize());
		this.setBoardRow(this.getBoardSize());
		
		//this.setNumOccupied( num2Occupy);
		this.setTheBoard(myPieces);//where the Board gets pieces
		
	}

	
	public char[][] getTheBoard() {
		return theBoard;
	}

	/**
	 * In order to be a generic board that is capable of being set up for different types 
	 * of games, the board will receive an array of pieces and will set matrix theBoard to
	 * have the pieces in the list.  Since the location of the pieces is predetermined wherever
	 * they are created, the board is simply assigning pieces to their specified locations.
	 * @param col
	 * @param row
	 */
	public void setTheBoard(ArrayList <PuzzlePiece> pieces2Set) {
		
		
		int row = this.getBoardRow();
		int col = this.getBoardCol();

		theBoard = new char [row][col];
		
		//initialize everything to open
		for (int i=0; i< row; i++){
			
			for (int j = 0; j<col; j++){
				theBoard[i][j] = OPEN;
			}
			
		}
		
		
		/**
		 * for each piece in the list assign it to the correct place in the matrix
		 * 
		 */
		for (PuzzlePiece setThisPiece: pieces2Set){
			
			this.setBoardLoc(setThisPiece);
			
		}
		
		
		
		//this.printBoard();
			
	}//end setTheBoard
	
	/**
	 * 
	 * @param Col
	 * @param Row
	 * @return value contained in matrix at specified location
	 */
	
	public char getBoardLocChar(Location loc){
		int Row = loc.getRow()-1;
		int Col = loc.getColumn()-1;
		return theBoard[Row][Col];
	}
	
	//returns character at certain board location
	/*public char getBoardLocChar(int row, int col){
		
		Location l = new Location(row,col);
		
		return this.getBoardLocChar(row, col);
	}*/
	
	public void setBoardLoc(PuzzlePiece myPiece){
		
		//since subtracting one creates an underflow for positions [0,x][x,0][0,0]
		//will add not subtract for these cases.  
		
		theBoard[myPiece.getMyLocation().getRow() -1][myPiece.getMyLocation().getColumn() -1] = myPiece.getMySymbol();
	}
	
	public void setBoardLocOpen(Location l){
		
		theBoard[l.getRow() -1][l.getColumn() -1] = OPEN;
	}

	public int getBoardSize() {
		return BoardSize;
	}

	public void setBoardSize(int col,int row) {
		this.BoardSize = col * row;
	}
	
	public void setBoardSize(int size){
		this.BoardSize = size;
	}

	public int getNumOccupied() {
		return numOccupied;
	}

	public void setNumOccupied(int numOccupied) {
		this.numOccupied = numOccupied;
	}

	public int getBoardRow() {
		return BoardRow;
	}
	
	public char [] getBoardRow(int RowNum) {
		
		char [] myRow = new char [8];
		
		for (int i = 0; i < 8; i++){
			
			myRow[i] = theBoard[RowNum][i];
			
		}
	
		return myRow;
	}

	public void setBoardRow(int BoardRow) {
		this.BoardRow = BoardRow;
	}

	public int getBoardCol() {
		return BoardCol;
	}

	public void setBoardCol(int BoardCol) {
		this.BoardCol = BoardCol;
	}
	
	public boolean pieceAtLocation(Location l){
		
		boolean isThereAPiece = false;
		char locChar;		
		
		locChar = theBoard[l.getRow()-1][l.getColumn()-1];
		
		if (locChar != OPEN){
			isThereAPiece = true;
			return isThereAPiece;
		}
		else{
			return isThereAPiece;
		}
	}
	
	/**
	 * Prints a graphic representation of the Board and its size to the console. 
	 * For example:
	 * Columns 3
	 * Rows 2
	 * 
	 * xxx
	 * xxx
	 * 
	 * If values are assigned, they will print.  X is printed by default.
	 * 
	 */
	public void printBoard(){
		
		//Print Board information first
		/*
		System.out.println("\nBoard Information\n");
		System.out.print("Number of Rows:\t");
		System.out.print(this.getBoardRow());
		System.out.print("\nNumber of Columns:\t");
		System.out.print(this.getBoardCol());
		System.out.print("\nThis is the number of squares included in the Board:\t");
		System.out.print(this.getBoardSize());
		System.out.print("\nThis is the number of dirty squares in the Board\t");
		System.out.print(this.getNumOccupied());
		System.out.print("\nThis is an ascii representation of the Board.  Clean =  0 and dirty = 1\n");
		*/
		
		for (int i=0; i<this.getBoardRow();i++){
			for (int j = 0; j< this.getBoardCol(); j++){
				
				
				System.out.print(theBoard[i][j]);
 			}
			System.out.print("\n");

		}
		
	}
	
	/**
	 * BOARD MOVES, methods that will move a piece north, south, east, west, northeast, northwest, southeast, southwest.
	 */
	
	//moveNorth
	/**
	 * Move North takes a puzzle piece, moves it north 1 space on the board if it is not at the edge. Changes the location of the puzzle piece and 
	 * returns the piece.  
	 * 
	 */
	public PuzzlePiece moveNorth (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that row is greater than 0 
		if(myPiece.getMyLocation().getRow() > 1){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//decrement 1 to row of puzzle piece's location
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getRow() - 1;
			l.setRow(r);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already in the top row, cannot move NORTH");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	
	
	//moveSouth...row number increases
	public PuzzlePiece moveSouth (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that row is less than 8
		if(myPiece.getMyLocation().getRow() < 8){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//increment 1 to row of puzzle piece's location
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getRow() + 1;
			l.setRow(r);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move SOUTH");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	
	
	//moveEast...column increases
	public PuzzlePiece moveEast (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that column is less than 8
		if(myPiece.getMyLocation().getColumn() < 8){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//increment 1 to COLUMN of puzzle piece's location
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getColumn() + 1;
			l.setColumn(r);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move EAST");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	
	//moveWest
	public PuzzlePiece moveWest (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that column is less than 8
		if(myPiece.getMyLocation().getColumn() > 1 ){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//decrement 1 to COLUMN of puzzle piece's location
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getColumn() - 1;
			l.setColumn(r);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move WEST");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}	
	
	
	//moveNorthWest
	public PuzzlePiece moveNorthWest (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that column is less than 8
		if(myPiece.getMyLocation().getColumn() > 1 || myPiece.getMyLocation().getRow() > 1){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//row decreases, column decreases
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getRow() - 1;
			int c = myPiece.getMyLocation().getColumn() - 1;
			l.setRow(r);
			l.setColumn(c);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move NORTHWEST");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	
	//moveNorthEast
	public PuzzlePiece moveNorthEast (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that column is less than 8
		if(myPiece.getMyLocation().getColumn() < 8 || myPiece.getMyLocation().getRow() > 1){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//row decreases, column decreases
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getRow() - 1;
			int c = myPiece.getMyLocation().getColumn() + 1;
			l.setRow(r);
			l.setColumn(c);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move NORTHEAST");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	
	//moveSouthEast
	public PuzzlePiece moveSouthEast (PuzzlePiece myPiece){
		
		//System.out.println("before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that move is not out of bounds
		if(myPiece.getMyLocation().getColumn() < 8 || myPiece.getMyLocation().getRow() < 8){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//row decreases, column decreases
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getRow() + 1;
			int c = myPiece.getMyLocation().getColumn() + 1;
			l.setRow(r);
			l.setColumn(c);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move SOUTHEAST");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	//moveSouthWest
public PuzzlePiece moveSouthWest (PuzzlePiece myPiece){
		
		//System.out.println("SOUTHWEST before moving");
		//this.printBoard();
		
		//check that piece exists at location
		if (this.pieceAtLocation(myPiece.getMyLocation())){
		
		//check that move is not out of bounds
		if(myPiece.getMyLocation().getColumn() < 8 || myPiece.getMyLocation().getRow() > 1){ 
			

			//set current location of piece on board to open
			this.setBoardLocOpen(myPiece.getMyLocation());
			
			//System.out.println("after clearing the space");
			//this.printBoard();
			
			//MOVE CALCULATION
			//row decreases, column decreases
			Location l = myPiece.getMyLocation();
			int r = myPiece.getMyLocation().getRow() + 1;
			int c = myPiece.getMyLocation().getColumn() - 1;
			l.setRow(r);
			l.setColumn(c);
			myPiece.setMyLocation(l);
			
			//pass the puzzle piece to the board
			this.setBoardLoc(myPiece);
			
			//System.out.println("the piece is now set");
			//this.printBoard();
			return myPiece;
			
			
		}//out side this bracket, piece is already in the top row
			System.out.println("Piece is already at the edge, cannot move SOUTHWEST");
			return myPiece;
		}//outside this bracket, the test for is there a piece failed
		
		System.out.println("Piece does not exist at this location:");
		myPiece.getMyLocation().print();
		return myPiece;
	}
	
	
	/**
	 * CALCULATE MOVE SCORE will calculate a score for each of the possible directions to move. 
	 * The score is calcuated based on the number of queens that can attack from that spot.
	 * 
	 * won't need north or south since there will only be 1 queen per column
	 * 
	 */
	
	public int calculateScoreRow(PuzzlePiece p){
		
		//System.out.println("CALCULATE SCORE:");
		
		int score = 0;
		
		//count the number of queens on the row number for p and subtract 1
		int row = p.getMyLocation().getRow() - 1;
		
		//get the corresponding board row into a local array for querying
		char [] myRow = this.getBoardRow(row);
		
		for (int i=0;i<8;i++){
			
			//System.out.print(myRow[i]);
			
			if (myRow[i] != OPEN){
				score++;
			}//end for loop
			
		}//end of for loop
		
		//subtract 1 from the score to represent the puzzle piece
		if (score > 0)
		score--;
	
	return score;
	}//end of score method
	
	/*
	[1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8]
	[2,1][2,2][2,3][2,4][2,5][2,6][2,7][2,8]
	[3,1][3,2][3,3][3,4][3,5][3,6][3,7][3,8]
	[4,1][4,2][4,3][4,4][4,5][4,6][4,7][4,8]
	*/
	
	public int calculateScoreEast(PuzzlePiece p){
		
		//System.out.println("CALCULATE SCORE:");
		
		int score = 0;
		
		//count the number of queens on the row number for p 
		int row = p.getMyLocation().getRow()-1;
		
		//get the corresponding board row into a local array for querying
		char [] myRow = this.getBoardRow(row);
		
		for (int i=p.getMyLocation().getColumn();i<8;i++){
			
			//System.out.print(myRow[i]);
			
			if (myRow[i] != OPEN){
				score++;
			}//end for loop
			
		}//end of for loop
	
	return score;
	}//end of score method
	
	public int calculateScoreWest(PuzzlePiece p){
		
		//System.out.println("CALCULATE SCORE:");
		
		int score = 0;
		
		//count the number of queens on the row number for p 
		int row = p.getMyLocation().getRow()-1;
		
		//get the corresponding board row into a local array for querying
		char [] myRow = this.getBoardRow(row);
		
		for (int i=p.getMyLocation().getColumn()-2;i>1;i--){
			
			//System.out.print(myRow[i]);
			
			if (myRow[i] != OPEN){
				score++;
			}//end for loop
			
		}//end of for loop
		
		//subtract 1 from the score to represent the puzzle piece
		//if (score > 0)
		//score--;
	
	return score;
	}//end of score method
	
	
	//calculateScoreNorthEast
	public int calculateScoreNorthEast(PuzzlePiece p){
		
		//System.out.println("CALCULATE NORTHEAST:");
		
		int score = 0;	
		//check that the piece is not already at an edge
		if (p.getMyLocation().getRow()>1 && p.getMyLocation().getColumn()<8){
			
		int myRow = p.getMyLocation().getRow()-1;
		int myCol = p.getMyLocation().getColumn()+1;
		
		Location scoreLocation = new Location(myRow,myCol);
		boolean quitLoop = false;
		//keeps looping until gets to the edge
		do {
				if (myRow==1 || myCol==8)
					quitLoop = true;
				
				//scoreLocation.print();
				if (this.getBoardLocChar(scoreLocation) != OPEN){
					score++;
				}
				
				//move the score location
				if (myRow>1 || myCol<8){
					myRow--;
					myCol++;
				scoreLocation.setLocation(myRow,myCol);
				}
			
		}while( !quitLoop);//end while
			
			
		//subtract 1 from the score to represent the puzzle piece
		//if (score > 0)
		//score--;
	
	return score;
	}//end if statement

	
	//if piece is already at an edge there won't be a score for northeast
	return score;//this is already set to 0
	
	}//end of score method
	

	
	//calculateScoreNorthWest
	public int calculateScoreNorthWest(PuzzlePiece p){
		
		//System.out.println("CALCULATE NORTHWEST:");
		
		int score = 0;	
		//check that the piece is not already at an edge
		if (p.getMyLocation().getRow()>1 && p.getMyLocation().getColumn()>1){
			
		int myRow = p.getMyLocation().getRow()-1;
		int myCol = p.getMyLocation().getColumn()-1;
		
		Location scoreLocation = new Location(myRow,myCol);
		boolean quitLoop = false;
		//keeps looping until gets to the edge
		do {
				if (myRow==1 || myCol==1)
					quitLoop = true;
				
				//scoreLocation.print();
				if (this.getBoardLocChar(scoreLocation) != OPEN){
					score++;
				}
				
				//move the score location
				if (myRow>1 || myCol>1){
					myRow--;
					myCol--;
					scoreLocation.setLocation(myRow,myCol);
				}
			
		}while( !quitLoop);//end while
			
	
	return score;
	}//end if statement

	
	//if piece is already at an edge there won't be a score for northeast
	return score;//this is already set to 0
	
	}//end of score method
	
	public int calculateScoreSouthWest(PuzzlePiece p){
		
		//System.out.println("CALCULATE SouthWEST:");
		
		int score = 0;	
		//check that the piece is not already at an edge
		if (p.getMyLocation().getRow()<8 && p.getMyLocation().getColumn()>1){
			
		int myRow = p.getMyLocation().getRow()+1;
		int myCol = p.getMyLocation().getColumn()-1;
		
		Location scoreLocation = new Location(myRow,myCol);
		boolean quitLoop = false;
		//keeps looping until gets to the edge
		do {
				if (myRow==8 || myCol==1)
					quitLoop = true;
				
				//scoreLocation.print();
				if (this.getBoardLocChar(scoreLocation) != OPEN){
					score++;
				}
				
				//move the score location
				if (myRow<8 || myCol>1){
					myRow++;
					myCol--;
				scoreLocation.setLocation(myRow,myCol);
				}
			
		}while( !quitLoop);//end while
			
	
	return score;
	}//end if statement

	
	//if piece is already at an edge there won't be a score for northeast
	return score;//this is already set to 0
	
	}//end of score method	
	
	public int calculateScoreSouthEast(PuzzlePiece p){
		
		//System.out.println("CALCULATE SouthWEST:");
		
		int score = 0;	
		//check that the piece is not already at an edge
		if (p.getMyLocation().getRow()<8 && p.getMyLocation().getColumn()<8){
			
		int myRow = p.getMyLocation().getRow()+1;
		int myCol = p.getMyLocation().getColumn()+1;
		
		Location scoreLocation = new Location(myRow,myCol);
		boolean quitLoop = false;
		//keeps looping until gets to the edge
		do {
				if (myRow==8 || myCol==8)
					quitLoop = true;
				
				//scoreLocation.print();
				if (this.getBoardLocChar(scoreLocation) != OPEN){
					score++;
				}
				
				//move the score location
				if (myRow<8 || myCol<8){
					myRow++;
					myCol++;
				scoreLocation.setLocation(myRow,myCol);
				}
			
		}while( !quitLoop);//end while
			
	
	return score;
	}//end if statement

	
	//if piece is already at an edge there won't be a score for northeast
	return score;//this is already set to 0
	
	}//end of score method	

	int calculateScoreBoard(PuzzlePiece myPiece){
		
		int score = 0;
		
		score = this.calculateScoreRow(myPiece) + this.calculateScoreNorthEast(myPiece) 
				+ this.calculateScoreNorthWest(myPiece) + this.calculateScoreSouthEast(myPiece)
				+ this.calculateScoreSouthWest(myPiece);
		
		return score;
		
		
	}
	
	boolean atRowBoundary (PuzzlePiece p){
		
		if (p.getMyLocation().getRow() <= 1 || p.getMyLocation().getRow()>= 8){
			return true;
		}
		
		return false;
	}
	
	boolean atColumnBoundary (PuzzlePiece p){
		
		if (p.getMyLocation().getColumn() <= 1 || p.getMyLocation().getColumn() >= 8)
			return true;
		
		return false;
	}

}
