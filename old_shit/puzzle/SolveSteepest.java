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
 * The puzzle solver class will generate a number of puzzles and solve them.  Once the puzzles are solved, it will generate 
 * statistics about the puzzles.
 * @author marlena
 *
 */
public class SolveSteepest {
	
	QueensPuzzleNode current;
	
	int searchCost;
	boolean isItSolved;
	boolean swapOccurred;
	ArrayList <Integer> whatItCost;
	
	SolveSteepest(){
		
		this.setItSolved(false);
		this.setSearchCost(0);
		current = new QueensPuzzleNode();
		boolean swapOccurred = false;
		whatItCost = new ArrayList <Integer>();

		
		this.go();
		
	}
	
	SolveSteepest(QueensPuzzleNode myNode){
		
		this.setItSolved(false);
		this.setSearchCost(0);
		current = myNode;
		boolean swapOccurred = false;
		whatItCost = new ArrayList <Integer>();
		
		this.go();
		
	}
	
	/**
	 * go attempts to search by looking for a global minima
	 * it generates a random current puzzle, 
	 * 				generates neighbor with a better possible h score.
	 * 				if it finds a neighbor with a better possible score, it swaps.  
	 * 				if it doesn't find a neighbor that has a better h score, it leaves current as the solution
	 */
	public void go(){
		
		System.out.println("Initial board state: ");
		this.getCurrent().getMyPuzzle().getMyBoard().printBoard();
		
		int swapCount = 0;
		//outer loop quits if the puzzle is solved, or a better score is found
		do{
		
				this.incrementSearchCost();
				this.setSwapOccurred(false);
				swapCount=0;
				
				QueensPuzzleNode nextNode = this.getMinSuccessorNode(this.getCurrent());
					
				
				//now the current node and neighbor are compared
				if (nextNode.getHeuristicCost()<this.getCurrent().getHeuristicCost()){
					
					//if the score of the neighbor is better, they are swapped.
					System.out.println("Heuristic cost of current is: " + this.getCurrent().getHeuristicCost());
					System.out.println("Heuristic cost of next node is: " + nextNode.getHeuristicCost());
					this.setCurrent(nextNode);
					this.setSwapOccurred(true);
					swapCount++;
					
				}//end if 
			
			
			
		
		}while (this.getCurrent().getHeuristicCost()> 0 &&  swapCount>0);//this.isSwapOccurred() == false);//end while
		
		
		if(this.getCurrent().getHeuristicCost()==0){
			this.setItSolved(true);
		}
		System.out.println("It took " + this.getSearchCost()+" steps to get this result:");
		this.getCurrent().getMyPuzzle().getMyBoard().printBoard();
		
	
	}//end go method
	
	
	public int getSearchCost() {
		return searchCost;
	}


	public void setSearchCost(int searchCost) {
		this.searchCost = searchCost;
	}
	
	public void incrementSearchCost(int moreSearchCost){
		
		this.searchCost += moreSearchCost;
	}
	
	public void incrementSearchCost(){
		this.searchCost++;
	}
	


	public boolean isItSolved() {
		return isItSolved;
	}


	public void setItSolved(boolean isItSolved) {
		this.isItSolved = isItSolved;
	}
	
	public QueensPuzzleNode swapCurrentNode(QueensPuzzleNode n){
		
		this.swapCurrentNode(n);
		this.setSwapOccurred(true);
		
		return n;
		
	}


	public boolean isSwapOccurred() {
		return swapOccurred;
	}


	public void setSwapOccurred(boolean swapOccurred) {
		this.swapOccurred = swapOccurred;
	}


	public QueensPuzzleNode getCurrent() {
		return current;
	}


	public void setCurrent(QueensPuzzleNode current) {
		this.current.copyNode(current);
	}


	/**
	 * Takes a node and expands a list of possible successor nodes
	 * From the list of successor nodes, the one with the lowest h score is returned.
	 * @param myNode
	 * @return
	 */
	public QueensPuzzleNode getMinSuccessorNode(QueensPuzzleNode myNode){
		
		//change the 1st row, 1st column of the puzzle in myNode to queen, removing the original position of the queen in the first column
		//starting with the heuristic cost for this position move into the inner loop which will start by creating a node for the second
		//position.  This will be compared with the node that started at the first spot.  Keep repeating for every row in the column.  Then
		//start the compare for the next row.  
		
		
		QueensPuzzleNode outerNode = new QueensPuzzleNode(myNode.getMyPuzzle() );
		
		int StepCost = 0;
		
		//for each column
		for (int j=1; j<9; j++){
			
			
			
			//for each row in the column
			for (int i=1; i<9; i++){
			
				StepCost++;
				System.out.println("Step number: " + StepCost);
				
				QueensPuzzleNode innerNode = new QueensPuzzleNode(outerNode.getMyPuzzle());
				//create a node with puzzle from my node with a piece in spot i,j
				
				//System.out.println("OUTER NODE BOARD");
				//outerNode.getMyPuzzle().getMyBoard().printBoard();
				
				Location newLoc = new Location(i,j);
				
				PuzzlePiece p = new PuzzlePiece('Q',newLoc);
				
				//generate the heuristic cost of the new puzzle
				innerNode.setAPiece(j, p);
				
				System.out.println("INNER NODE BOARD");
				innerNode.getMyPuzzle().getMyBoard().printBoard();	
				
				System.out.println("heuristic cost of inner node is: " + innerNode.getHeuristicCost());
				
				System.out.println("heuristic cost of outer node is: " + outerNode.getHeuristicCost());
				
				
				if (innerNode.getHeuristicCost() < outerNode.getHeuristicCost()){
					
					
					//outernode = innernode
					outerNode.copyNode(innerNode);
					System.out.print("inner node should be outer node");
				}
				
				
			}
		}
		
		this.incrementSearchCost(StepCost);
		return outerNode;
	}
	
	


}
