package puzzle;

import junit.framework.*;
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
public class QueensPuzzleNodeTest extends TestCase {
	
	public QueensPuzzleNodeTest(String s){
		super(s);
	}
	
	public void testHeuristicScore(){
		
		//this is a solved puzzle
		Location a = new Location (1,4);
		Location b = new Location (2,7);
		Location c = new Location (3,3);
		Location d = new Location (4,8);
		Location e = new Location (5,2);
		Location f = new Location (6,5);
		Location g = new Location (7,1);
		Location h = new Location (8,6);
		
		ArrayList <PuzzlePiece> myPieces = new ArrayList <PuzzlePiece>();
		myPieces.add(new PuzzlePiece('Q',a));
		myPieces.add(new PuzzlePiece('Q',b));
		myPieces.add(new PuzzlePiece('Q',c));
		myPieces.add(new PuzzlePiece('Q',d));
		myPieces.add(new PuzzlePiece('Q',e));
		myPieces.add(new PuzzlePiece('Q',f));
		myPieces.add(new PuzzlePiece('Q',g));
		myPieces.add(new PuzzlePiece('Q',h));
		
		
		QueensPuzzle currentPuzzle = new QueensPuzzle(myPieces);
		
		currentPuzzle.myBoard.printBoard();
		
		System.out.println("MOVE NORTH");
		
		//execute move on new copy of puzzle
		
		
		currentPuzzle.myBoard.moveNorth(myPieces.get(1));
		
		currentPuzzle.myBoard.printBoard();
		
		//QueensPuzzle
		
		//QueensPuzzleNode currentNode = new QueensPuzzleNode();
		//QueensPuzzleNode neighborNode = new QueensPuzzleNode();
		
	}
	
	public void testSetItSolved(){
		
		QueensPuzzleNode current = new QueensPuzzleNode();
		
		assertFalse("new node probably isn't solved",current.getMyPuzzle().goalTest());
		
		
	}

}
