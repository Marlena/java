package puzzle;

import java.math.*;
import java.util.*;


public class SimulatedAnnealing {
	
	/**These notes are from 
	 * Programming Collective Intelligence by Toby Segaran  chapter on Optimization
	 * if the new cost is lower, the new solution becomes the current solution, 
	 * which is very much like the hill-climbing method. However, if the cost is higher, 
	 * the new solution can still become the current solution with a certain probability.
	 * 
	 * The probability of a higher-cost solution being accepted is given by this formula:
	*((-highcost-lowcost)/temp)
	*
	*initially set temp to 10000.0
	*cool = 0.95
	*
	*Since the temperature (the willingness to accept a worse solution) starts very high, 
	*the exponent will always be close to 0, so the probability will almost be 1. As the 
	*temperature decreases, the difference between the high cost and the low cost becomes 
	*more important—a bigger difference leads to a lower probability, so the algorithm will 
	*favor only slightly worse solutions over much worse ones.
	*
	*From Norvig:  
	*One can prove that if the schedule lowers T slowly enough, the algorithm will find a global
	*optimum with probability approaching 1.
	*
	*English Translation:  If the random moves around the board are too large, they will move past
	*the solution.
	*
	*
	*double natLog = Math.E;
	*costCurrent
	*costNext
	*
	*probability = pow(math.e,(-costNext-costCurrent)/temp)
	 */
	QueensPuzzleNode current;
	
	int searchCost;
	boolean isItSolved;
	boolean swapOccurred;
	ArrayList <Integer> whatItCost;
	
	SimulatedAnnealing(){
		
		this.setItSolved(false);
		this.setSearchCost(0);
		current = new QueensPuzzleNode();
		boolean swapOccurred = false;
		whatItCost = new ArrayList <Integer>();

		
		//this.go();
		
	}
	
	SimulatedAnnealing(QueensPuzzleNode myNode){
		
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
		
//		****goes in the outer loop in go() method
		//calculate the current cost and the new cost after the move
		//costCurrent
		//costNext
		
		System.out.println("Initial board state: ");
		this.getCurrent().getMyPuzzle().getMyBoard().printBoard();
		
		int swapCount = 0;
		//outer loop quits if the puzzle is solved, or a better score is found
		do{
		
				this.incrementSearchCost();
				this.setSwapOccurred(false);
				swapCount=0;
				
				QueensPuzzleNode nextNode = this.getNext(this.getCurrent());
					
				
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

	public QueensPuzzleNode getNext(QueensPuzzleNode currentNode){
		
		
		
		int step = 0;
		
		
		
		
			//choose a Queen randomly from the Queens on the Board
				//calculate random index between 0 and 7 (inclusive)
				Random generator = new Random();
				int nextIndex = generator.nextInt(8);
				
				
				PuzzlePiece p = currentNode.myPuzzle.getMyPieces().get(nextIndex);
				
			
			//choose randomly to move it north or south
			
			int moveDir = generator.nextInt(3)-1;
			//if 0, move north, if 1, move south
			if (moveDir >1){
				
				p.moveSouth();
			}
			else{
				p.moveNorth();
			}
			
			//create a new board with the queen moved
			QueensPuzzleNode nextNode = new QueensPuzzleNode(currentNode.getMyPuzzle());
			
			
			nextNode.setAPiece(nextIndex, p);
			
			
			return nextNode;
			
		
		
		
		
	}

}
