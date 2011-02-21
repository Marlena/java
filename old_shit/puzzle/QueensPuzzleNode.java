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
/*
 * Puzzle Nodes are used as the nodes of a search containing an 8 Queens Puzzle
 */
public class QueensPuzzleNode {
	
	QueensPuzzle myPuzzle;
	
	
	//the following three variables will be used for performance metrics.
	
	//for each new puzzle moved into the current state, this cost will be incremented
	int searchCost;
	boolean isItSolved; //performs the goal test
	int heuristicCost;
	
	//this constructor is used if a completely new puzzle is being constructed.  
	//It will construct a puzzle with randomly placed queens
	QueensPuzzleNode(){
		
		myPuzzle = new QueensPuzzle();
		this.setItSolved(myPuzzle.goalTest());
		this.setHeuristicCost(myPuzzle.getHeuristicCost());
		
	}
	
	//this constructor is used when it is already known where the pieces should
	//be on the board.
	//for example:  new QueensPuzzleNode = new QueensPuzzleNode(myPuzzle.moveNorth(p) )
	QueensPuzzleNode(QueensPuzzle passedInPuzzle){
		
		//make new puzzle with same values copyPuzzle
		
		//myPuzzle = passedInPuzzle;  //this was passing by reference..very, very BAD
		
		this.setMyPuzzle(passedInPuzzle.copyPuzzle());
		this.setItSolved(myPuzzle.goalTest());
		this.setHeuristicCost(myPuzzle.getHeuristicCost());
		
		
	}

	public int getHeuristicCost() {
		return heuristicCost;
	}

	public void setHeuristicCost(int heuristicCost) {
		this.heuristicCost = heuristicCost;
	}

	public boolean isItSolved() {
		return isItSolved;
	}

	public void setItSolved(boolean isItSolved) {
		this.isItSolved = isItSolved;
	}

	public QueensPuzzle getMyPuzzle() {
		return myPuzzle;
	}

	public void setMyPuzzle(QueensPuzzle myPuzzle) {
		this.myPuzzle = myPuzzle;
	}

	public int getSearchCost() {
		return searchCost;
	}

	public void setSearchCost(int searchCost) {
		this.searchCost = searchCost;
	}
	
	public void setAPiece(int i, PuzzlePiece p){
		
		this.getMyPuzzle().setAPiece(i, p);
		this.setHeuristicCost(this.getMyPuzzle().getHeuristicCost() );
		
	}
	
	/**
	 * creates a new queens puzzle object with same information as node being copied.
	 * @return
	 */
	public void copyNode(QueensPuzzleNode node2Copy){
		
		this.setMyPuzzle(node2Copy.getMyPuzzle().copyPuzzle());
		this.setHeuristicCost(this.getMyPuzzle().getHeuristicCost());
		
		
	}
	

}
