package puzzle;

import java.util.ArrayList;
import java.util.Random;

public class QueensPuzzle  {

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
	
	//ArrayList allPieces  //list of pieces can have varying lengths
	
	ArrayList<PuzzlePiece> myPieces;
	Board myBoard;
	
	/**
	 * initBoard sets up the board with 8 queens randomly placed on the board
	 * @return
	 */
	
	public QueensPuzzle(){
		
		this.setMyPieces();
		this.setMyBoard(this.getMyPieces());
		
	}
	
	/**
	 * This constructor used for testing.  
	 * @param myPieces
	 */
	public QueensPuzzle(ArrayList <PuzzlePiece> myPieces){
		
		this.setMyPieces(myPieces);
		this.setMyBoard(myPieces);
		
	}
	
	/**
	 * move north executes a move north for a piece on the board and returns a 
	 * puzzle
	 */
	
	public QueensPuzzle (PuzzlePiece p){
		
		this.myBoard.moveNorth(p);
		
	}
	
	/**
	 * goalTest returns true if the total score of the board for all 8 pieces is 0
	 * @return boolean
	 */
	public boolean goalTest() {
		
		int score = 0;
		
		for (int i=0;i<myPieces.size();i++){
			
			score += myBoard.calculateScoreBoard(myPieces.get(i));
		}
		
		if (score == 0){
			return true;
		}
		
		return false;
	}
	
	//returns the heuristic cost of a puzzle
	public int getHeuristicCost() {
		
		int score = 0;
		
		for (int i=0;i<myPieces.size();i++){
			
			score += myBoard.calculateScoreBoard(myPieces.get(i));
		}
		return score;
	}

	/**
	 * getMoveScore creates a puzzle for scoring a certain  
	 * @return
	 */


	public Board getMyBoard() {
		return myBoard;
	}




	public void setMyBoard(ArrayList<PuzzlePiece> pieces2Set ) {
		
		myBoard = new Board(8, pieces2Set);
		
		
	}




	public ArrayList<PuzzlePiece> getMyPieces() {
		return myPieces;
	}



/**
 * Sets the list of pieces with 8 pieces that have unique randomly generated locations
 *
 */
	public void setMyPieces() {
		
		myPieces = new ArrayList <PuzzlePiece>();
		for (int i= 0; i < 8; i++){
			
			Location myLoc;  

			//generateRandomLocation
			myLoc = new Location(generateRandomLocation());
			
			//just realized that there is one queen per column
			//which means there's no need to check if there are repeat locations
			myLoc.setColumn(i +1);
			myPieces.add(new PuzzlePiece('Q',myLoc));
		}
		
	}
	
	/**
	 * Sets the list of pieces with 8 pieces NON-random pieces.  Used 
	 * for testing.
	 *
	 */
		public void setMyPieces(ArrayList <PuzzlePiece> passedInPieces) {
			
			myPieces = new ArrayList <PuzzlePiece>();
			for (int i= 0; i < 8; i++){
				
				myPieces.add(passedInPieces.get(i));
			}
			
		}
		
	/**
	 * setAPiece will set the array at index i to PuzzlePiece p and make sure the
	 * board is changed to reflect the new piece.  
	 * @param i
	 * @param p
	 */
		public void setAPiece(int i, PuzzlePiece p){
			
			//change the piece in myPieces
			PuzzlePiece oldPiece = myPieces.get(i-1);
			oldPiece.setMySymbol('-');
			
			this.getMyBoard().setBoardLoc(oldPiece);
			
			//change the board, remove old piece set new piece
			myPieces.set(i-1, p);
			this.getMyBoard().setBoardLoc(p);
			
			
			
		}
	
	/**
	 * generates random location based on the board
	 * does NOT check whether there is already piece at that 
	 * spot on the board
	 * @return
	 */
	public Location generateRandomLocation(){
		
		//generate random row...adding 1 to correct for board problem
		Random randNum = new Random();
		int randRow = randNum.nextInt(8) + 1;
		
		//generate random column...adding 1 to correct for board problem
		int randCol = randNum.nextInt(8) +1;
		Location randLoc = new Location(randRow,randCol);
		
		return randLoc;
	}
	
	
	public QueensPuzzle copyPuzzle (){
		
		//copy pieces
		ArrayList <PuzzlePiece> copyPieces = new ArrayList<PuzzlePiece>();
		
		for (int i=0;i<8;i++){
			
			//get location of piece i from this.myPieces
			Location l = this.getMyPieces().get(i).getMyLocation();
			copyPieces.add(new PuzzlePiece('Q',l));

		}
		
		QueensPuzzle copyOfPuzzle = new QueensPuzzle(copyPieces);
		
		return  copyOfPuzzle;
		
	}


}
