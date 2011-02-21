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
public class BoardTest extends TestCase	{
	
	public BoardTest (String s){
		super(s);
	}
	
	public void testSetPieceA(){
		
		Location aLoc = new Location(8,8);
		PuzzlePiece a = new PuzzlePiece('a',aLoc);
		
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(a);

		Board myBoard = new Board (8,myPieces);
		
		//myBoard.printBoard();
		
		assertEquals("location 8,8 is a", myBoard.getBoardLocChar(aLoc), 'a');
		
		
	}
	
	public void testSetPieceB(){
		
		Location bLoc = new Location(1,1);
		PuzzlePiece b = new PuzzlePiece('b', bLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(b);
		
		Board myBoard = new Board (8,myPieces);
		//myBoard.printBoard();
		
		assertEquals("location 0,0 is b", myBoard.getBoardLocChar(bLoc), 'b');
		
	}
	
	public void testSetPieceC(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//myBoard.printBoard();
		
		assertEquals("location 6,7 is c", 'c', myBoard.getBoardLocChar(cLoc));
		
	}
	
	public void testSetPieceD(){
		
		Location dLoc = new Location(7,6);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(d);
		
		Board myBoard = new Board (8,myPieces);
		//myBoard.printBoard();
		
		assertEquals("location 7,6 is d", 'd', myBoard.getBoardLocChar(dLoc));
		
	}
	
	public void testGetBoardLoc(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		
		//Location intConLoc = myBoard.getBoardLoc(6, 7);
		
		//assertEquals("use location consctructor", myBoard.)
		
	}
	
	public void testMoveCNorth(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveNorth(p));
		
		Location l57 = new Location (5,7);
		
		
		assertEquals("new location of c is 5,7",'c',myBoard.getBoardLocChar(l57));
		
	}
	
	
	
	public void testMoveCSouth(){
		
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveSouth(p));
		
		Location newLoc = new Location (7,7);
		
		
		assertEquals("new location of c is 7,7",'c',myBoard.getBoardLocChar(newLoc));
		
		
		
	}
	
	public void testMoveCEast(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveEast(p));
		
		Location newLoc = new Location (6,8);
		Location oldLoc = new Location (6,7);
		
		assertEquals("new location of c is 6,8",'c',myBoard.getBoardLocChar(newLoc));
		
		assertEquals("old location is open",'-',myBoard.getBoardLocChar(oldLoc));
	
		
	}
	
	public void testMoveCWest(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveWest(p));
		
		Location newLoc = new Location (6,6);
		Location oldLoc = new Location (6,7);
		
		assertEquals("new location of c is 6,8",'c',myBoard.getBoardLocChar(newLoc));
		
		assertEquals("old location is open",'-',myBoard.getBoardLocChar(oldLoc));
	
		
	}
	
	public void testMoveCNorthWest(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveNorthWest(p));
		
		Location newLoc = new Location (5,6);
		Location oldLoc = new Location (6,7);
		
		assertEquals("new location of c is 5,6",'c',myBoard.getBoardLocChar(newLoc));
		
		assertEquals("old location is open",'-',myBoard.getBoardLocChar(oldLoc));
	
		
	}	
	
	public void testMoveCNorthEast(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveNorthEast(p));
		
		Location newLoc = new Location (5,8);
		Location oldLoc = new Location (6,7);
		
		assertEquals("new location of c is 5,8",'c',myBoard.getBoardLocChar(newLoc));
		
		assertEquals("old location is open",'-',myBoard.getBoardLocChar(oldLoc));
	
		
	}
	
	public void testMoveCSouthWest(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveSouthWest(p));
		
		Location newLoc = new Location (7,6);
		Location oldLoc = new Location (6,7);
		
		assertEquals("new location of c is 7,6",'c',myBoard.getBoardLocChar(newLoc));
		
		assertEquals("old location is open",'-',myBoard.getBoardLocChar(oldLoc));
	
		
	}
	
	public void testMoveCSouthEast(){
		
		Location cLoc = new Location(6,7);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		
		Board myBoard = new Board (8,myPieces);
		//get piece from the list
		PuzzlePiece p = myPieces.remove(0);
		
		//add piece to the list, this piece is returned by moveNorth(p)
		myPieces.add(0,myBoard.moveSouthEast(p));
		
		Location newLoc = new Location (7,8);
		Location oldLoc = new Location (6,7);
		
		assertEquals("new location of c is 7,8",'c',myBoard.getBoardLocChar(newLoc));
		
		assertEquals("old location is open",'-',myBoard.getBoardLocChar(oldLoc));
	
		
	}
	
	public void testCalculateScoreRow(){

		Location cLoc = new Location(1,8);
		Location dLoc = new Location(1,7);
		Location eLoc = new Location(1,6);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		Board myBoard = new Board (8,myPieces);
		
		//System.out.println("CALCULATE EAST SCORE");
		//myBoard.printBoard();

		int score = myBoard.calculateScoreRow(c);
		
		assertEquals("score for Row is 2",2,score);
		
		
	}
	
	/*
	[1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8]
	[2,1][2,2][2,3][2,4][2,5][2,6][2,7][2,8]
	[3,1][3,2][3,3][3,4][3,5][3,6][3,7][3,8]
	[4,1][4,2][4,3][4,4][4,5][4,6][4,7][4,8]
	*/
	
	public void testCalculateScoreEast(){

		Location cLoc = new Location(1,8);
		Location dLoc = new Location(1,7);
		Location eLoc = new Location(1,6);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		Board myBoard = new Board (8,myPieces);
		
		//System.out.println("CALCULATE EAST SCORE");
		//myBoard.printBoard();

		int score = myBoard.calculateScoreEast(e);
		
		assertEquals("score for Row is 2",2,score);
		
		
	}
	
	public void testCalculateScoreWest(){

		Location cLoc = new Location(1,8);
		Location dLoc = new Location(1,7);
		Location eLoc = new Location(1,6);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		Board myBoard = new Board (8,myPieces);
		
		//System.out.println("CALCULATE EAST SCORE");
		//myBoard.printBoard();

		int score = myBoard.calculateScoreWest(c);
		
		assertEquals("score for Row is 2",2,score);
		
		
	}
	
	public void testCalculateScoreNorthEast(){

		Location cLoc = new Location(1,8);
		Location dLoc = new Location(2,7);
		Location eLoc = new Location(3,6);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		
		
		Board myBoard = new Board (8,myPieces);
		
		
		
		//System.out.println("CALCULATE EAST SCORE");
		//myBoard.printBoard();

		int scoreC = myBoard.calculateScoreNorthEast(c);
		int scoreD = myBoard.calculateScoreNorthEast(d);
		int scoreE = myBoard.calculateScoreNorthEast(e);
		
		assertEquals("score for C is 0",0,scoreC);
		assertEquals("score for D is 1",1,scoreD);
		assertEquals("score for E is 2",2,scoreE);
		
		
	}
	
	public void testCalculateScoreNorthWest(){

		Location cLoc = new Location(1,5);
		Location dLoc = new Location(2,6);
		Location eLoc = new Location(3,7);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		
		
		Board myBoard = new Board (8,myPieces);
		
		
		
		//System.out.println("CALCULATE NORTHWEST SCORE");
		//myBoard.printBoard();

		int scoreC = myBoard.calculateScoreNorthWest(c);
		int scoreD = myBoard.calculateScoreNorthWest(d);
		int scoreE = myBoard.calculateScoreNorthWest(e);
		
		assertEquals("score for C is 0",0,scoreC);
		assertEquals("score for D is 1",1,scoreD);
		assertEquals("score for E is 2",2,scoreE);
		
		
	}
	
	/*
	[1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8]
	[2,1][2,2][2,3][2,4][2,5][2,6][2,7][2,8]
	[3,1][3,2][3,3][3,4][3,5][3,6][3,7][3,8]
	[4,1][4,2][4,3][4,4][4,5][4,6][4,7][4,8]
	*/
	
	public void testCalculateScoreSouthWest(){

		Location cLoc = new Location(2,4);
		Location dLoc = new Location(3,3);
		Location eLoc = new Location(4,2);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		
		
		Board myBoard = new Board (8,myPieces);
		
		
		
		//System.out.println("CALCULATE NORTHWEST SCORE");
		//myBoard.printBoard();

		int scoreC = myBoard.calculateScoreSouthWest(c);
		int scoreD = myBoard.calculateScoreSouthWest(d);
		int scoreE = myBoard.calculateScoreSouthWest(e);
		
		assertEquals("score for C is 2",2,scoreC);
		assertEquals("score for D is 1",1,scoreD);
		assertEquals("score for E is 0",0,scoreE);
		
		
	}
	
	/*
	[1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8]
	[2,1][2,2][2,3][2,4][2,5][2,6][2,7][2,8]
	[3,1][3,2][3,3][3,4][3,5][3,6][3,7][3,8]
	[4,1][4,2][4,3][4,4][4,5][4,6][4,7][4,8]
	*/
	
	public void testCalculateScoreSouthEast(){

		Location cLoc = new Location(2,4);
		Location dLoc = new Location(3,5);
		Location eLoc = new Location(4,6);
		
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		
		
		
		Board myBoard = new Board (8,myPieces);
		
		
		
		//System.out.println("CALCULATE NORTHWEST SCORE");
		//myBoard.printBoard();

		int scoreC = myBoard.calculateScoreSouthEast(c);
		int scoreD = myBoard.calculateScoreSouthEast(d);
		int scoreE = myBoard.calculateScoreSouthEast(e);
		
		assertEquals("score for C is 2",2,scoreC);
		assertEquals("score for D is 1",1,scoreD);
		assertEquals("score for E is 0",0,scoreE);
		
		
	}
	
	public void testCalculateScoreBoard(){
		
		/*  12345678
		 * 1-------B
		 * 2--------
		 * 3--------
		 * 4-AD-----
		 * 5C-------
		 * 6---HF--G
		 * 7--------
		 * 8E-------
		 * 
		 */
		
		Location aLoc = new Location(4,2);
		Location bLoc = new Location(1,8);
		Location cLoc = new Location(5,1);
		Location dLoc = new Location(4,3);
		Location eLoc = new Location(8,1);
		Location fLoc = new Location(6,5);
		Location gLoc = new Location(6,8);
		Location hLoc = new Location(6,4);
		
		PuzzlePiece a = new PuzzlePiece('a', aLoc);
		PuzzlePiece b = new PuzzlePiece('b', bLoc);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		PuzzlePiece	f = new PuzzlePiece('f', fLoc);
		PuzzlePiece g = new PuzzlePiece('g', gLoc);
		PuzzlePiece h = new PuzzlePiece('h',hLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(a);
		myPieces.add(b);
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		myPieces.add(f);
		myPieces.add(g);
		myPieces.add(h);
		
		Board myBoard = new Board (8,myPieces);
		
		int scoreF = myBoard.calculateScoreBoard(f);
		int scoreB = myBoard.calculateScoreBoard(b);
		int scoreA = myBoard.calculateScoreBoard(a);
		
		assertEquals("score for f is 3",3,scoreF);
		assertEquals("score for b is 1",1,scoreB);
		assertEquals("score for a is 3",3,scoreA);
		
	}
	
	public void testBoundary(){
		
		Location aLoc = new Location(4,2);
		Location bLoc = new Location(1,8);
		Location cLoc = new Location(5,1);
		Location dLoc = new Location(8,8);
		Location eLoc = new Location(8,1);
		Location fLoc = new Location(1,1);
		
		PuzzlePiece a = new PuzzlePiece('a', aLoc);
		PuzzlePiece b = new PuzzlePiece('b', bLoc);
		PuzzlePiece c = new PuzzlePiece('c', cLoc);
		PuzzlePiece d = new PuzzlePiece('d', dLoc);
		PuzzlePiece e = new PuzzlePiece('e', eLoc);
		PuzzlePiece	f = new PuzzlePiece('f', fLoc);
		
		ArrayList<PuzzlePiece> myPieces = new ArrayList <PuzzlePiece> ();
		myPieces.add(a);
		myPieces.add(b);
		myPieces.add(c);
		myPieces.add(d);
		myPieces.add(e);
		myPieces.add(f);

		
		Board myBoard = new Board (8,myPieces);
		
		assertFalse("a is not row boundary",myBoard.atRowBoundary(a));
		assertFalse("a is not column boundary",myBoard.atColumnBoundary(a));
		
		assertTrue("b is row boundary",myBoard.atRowBoundary(b));
		assertTrue("b is column boundary",myBoard.atColumnBoundary(b));
		
		assertFalse("c is not row boundary",myBoard.atRowBoundary(c));
		assertTrue("c is column boundary",myBoard.atColumnBoundary(c));
		
		assertTrue("d is row boundary",myBoard.atRowBoundary(d));
		assertTrue("d is column boundary",myBoard.atColumnBoundary(d));
		
		assertTrue("e is row boundary",myBoard.atRowBoundary(e));
		assertTrue("e is column boundary",myBoard.atColumnBoundary(e));
		
		assertTrue("f is row boundary",myBoard.atRowBoundary(f));
		assertTrue("f is column boundary",myBoard.atColumnBoundary(f));

		
	}
	

}//end test class
