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
public class QueensPuzzleTest extends TestCase	{

	public QueensPuzzleTest(String s){
		super(s);
	}
	
	public void testSetMyPieces(){
		
		QueensPuzzle myPuzzle = new QueensPuzzle();
		
		//Location myLoc = new Location(myPuzzle.generateRandomLocation());
		//myLoc.print();
		for (int i=0; i < 100; i++){
			myPuzzle.setMyPieces();
			assertEquals("setPieces has size 8", myPuzzle.getMyPieces().size(),8);
			
		}
		
	}
	
	/*public void testSetMyBoard(){
		
		QueensPuzzle myPuzzle = new QueensPuzzle();
		
		myPuzzle.setMyBoard(myPuzzle.getMyPieces());
		
		myPuzzle.myBoard.printBoard();
	}*/
	
	public void testGoalTest(){
		
		//this is a solved puzzle
		Location a = new Location (1,4);
		Location b = new Location (2,7);
		Location c = new Location (3,3);
		Location d = new Location (4,8);
		Location e = new Location (5,2);
		Location f = new Location (6,5);
		Location g = new Location (7,1);
		Location h = new Location (8,6);
		
		
		Location fail = new Location (3,4);
		
		
		
		ArrayList <PuzzlePiece> myPieces = new ArrayList <PuzzlePiece>();
		myPieces.add(new PuzzlePiece('Q',a));
		myPieces.add(new PuzzlePiece('Q',b));
		myPieces.add(new PuzzlePiece('Q',c));
		myPieces.add(new PuzzlePiece('Q',d));
		myPieces.add(new PuzzlePiece('Q',e));
		myPieces.add(new PuzzlePiece('Q',f));
		myPieces.add(new PuzzlePiece('Q',g));
		myPieces.add(new PuzzlePiece('Q',h));
		
		
		QueensPuzzle myPuzzle = new QueensPuzzle(myPieces);
		
		myPieces.remove(0);
		myPieces.add(new PuzzlePiece('Q',fail));
		
		QueensPuzzle myPuzzle2 = new QueensPuzzle(myPieces);
		
		//myPuzzle.myBoard.printBoard();
				
		assertTrue("Score for solved puzzle is 0",myPuzzle.goalTest());
		assertFalse("Score for puzzle is now 2",myPuzzle2.goalTest());
		assertEquals("h score for puzzle 2 is 4",4,myPuzzle2.getHeuristicCost());
		assertEquals("h score for puzzle is 0",0,myPuzzle.getHeuristicCost());
		
		QueensPuzzle testGoalPuzzle = new QueensPuzzle();
		assertFalse("randomly generated puzzle probably not solved",testGoalPuzzle.goalTest());
		
		
	}
	
	public void testSetAPiece(){
		
		Location a = new Location (4,1);
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
		
		
		QueensPuzzle myPuzzle = new QueensPuzzle(myPieces);
		
		
		myPuzzle.getMyBoard().printBoard();
		
		Location newLoc = new Location (1,1);
		PuzzlePiece newPiece = new PuzzlePiece ('Q',newLoc);
		
		myPuzzle.setAPiece(1, newPiece);
		
		System.out.println("piece has moved");
		
		myPuzzle.getMyBoard().printBoard();
	}
	
	
	
	
	
}
