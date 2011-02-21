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
/**
 * Puzzle is an abstract class that has a board, pieces and the ability to move pieces around on the board.  Moves will be implemented in this class for use by sub-classes.
 * @author marlena
 *
 */
public abstract class Puzzle {
	
	//ArrayList allPieces  //list of pieces can have varying lengths
	
	ArrayList<PuzzlePiece> myPieces;
	Board myBoard;
	
	/**
	 * Prints the puzzle with pieces in the correct place
	 */
	void print(){
		
	}
	
	//goal Test determines whether or not the puzzle is at a goal state.
	//this will be different for every type of puzzle, so it is an abstract method.
	public abstract boolean goalTest();
	
	

}


