package puzzle;

import junit.framework.*;

public class SimulatedAnnealingTest extends TestCase {
	
	public SimulatedAnnealingTest(String s){
		
		super(s);
	}
	
	public void testGetNext(){
		
		//QueensPuzzleNode testNode = new QueensPuzzleNode();
		QueensPuzzleNode nextNode;
		
		SimulatedAnnealing solver = new SimulatedAnnealing();
		
		System.out.println("hcost is: " + solver.getCurrent().getHeuristicCost());
		solver.getCurrent().getMyPuzzle().getMyBoard().printBoard();
		
		nextNode = solver.getNext(solver.getCurrent());
		
		//System.out.println("hcost is: " + testNode.getHeuristicCost());
		//testNode.getMyPuzzle().getMyBoard().printBoard();
		
		System.out.println("hcost is: " + nextNode.getHeuristicCost());
		nextNode.getMyPuzzle().getMyBoard().printBoard();
		
	}

}
