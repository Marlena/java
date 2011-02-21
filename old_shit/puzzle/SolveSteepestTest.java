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
public class SolveSteepestTest extends TestCase {
	
	public SolveSteepestTest(String s){
		super(s);
	}
	

	public void testSearchCost(){
		
		Location a = new Location (3,1);
		Location b = new Location (7,2);
		Location c = new Location (3,3);
		Location d = new Location (8,4);
		Location e = new Location (2,5);
		Location f = new Location (5,6);
		Location g = new Location (1,7);
		Location h = new Location (6,8);

		
		
		
		ArrayList <PuzzlePiece> myPieces = new ArrayList <PuzzlePiece>();
		
		
		
		myPieces.add(new PuzzlePiece('Q',a));
		myPieces.add(new PuzzlePiece('Q',b));
		myPieces.add(new PuzzlePiece('Q',c));
		myPieces.add(new PuzzlePiece('Q',d));
		myPieces.add(new PuzzlePiece('Q',e));
		myPieces.add(new PuzzlePiece('Q',f));
		myPieces.add(new PuzzlePiece('Q',g));
		myPieces.add(new PuzzlePiece('Q',h));

		
		
		QueensPuzzle testPuzzle = new QueensPuzzle(myPieces);
		
		QueensPuzzleNode nodeA = new QueensPuzzleNode(testPuzzle);
		
		//SolveSteepest solverA = new SolveSteepest(nodeA);
		
		
		SolveSteepest solverB = new SolveSteepest();
		
		
	}
}
