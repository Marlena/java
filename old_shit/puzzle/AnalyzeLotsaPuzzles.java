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

public class AnalyzeLotsaPuzzles {
	
	int numPuzzlesAttemptedSteepest;
	int numPuzzlesAttemptedRandom;
	int numPuzzlesAttemptedSA;
	
	int numPuzzlesSolvedSteepest;
	int numPuzzlesSolvedRandom;
	int numPuzzlesSolvedSA;
	
	
	public static void main(String[] args){
		
		float numPuzzlesAttemptedSteepest = 0;
		float numPuzzlesAttemptedRandom =0 ;
		int numPuzzlesAttemptedSA = 100;
		
		float numPuzzlesSolvedSteepest = 0;
		float numPuzzlesSolvedRandom = 0;
		int numPuzzlesSolvedSA = 0;
		
		
		
		ArrayList <Integer> numberStepsSolvedSteepest = new ArrayList <Integer>();
		
		//solve with Steepest Ascent Hill Climbing
		for (int i=0; i<75; i++){
			
			System.out.println("This is Puzzle number " + i + ".");
			SolveSteepest steepestAscent = new SolveSteepest();
			
			numPuzzlesAttemptedSteepest++;
			if (steepestAscent.isItSolved()){
				numPuzzlesSolvedSteepest++;
			}//end if
			
			numberStepsSolvedSteepest.add(i,steepestAscent.getSearchCost());
		
		}//end of for loop
		
		ArrayList <Integer> numberStepsSolved = new ArrayList <Integer>();
		//solve with random restart hill climbing
		for (int i=0; i< 10; i++){
			
			System.out.println("This is Puzzle number " + i + ".");
			SolveRandomRestart restartSolver = new SolveRandomRestart();
			numPuzzlesAttemptedRandom++;
			if (restartSolver.isItSolved()){
				numPuzzlesSolvedRandom++;
			}
			
			numberStepsSolved.add(i,restartSolver.getSearchCost());
			
		}
		
		float percentSolved = (numPuzzlesSolvedSteepest/numPuzzlesAttemptedSteepest)*100;
	
		//print out stats for steepest ascent
		System.out.println("Marlena's Puzzle Solver");
		System.out.println("Of 75 attempted hill climbing searches, the system solved:");
		System.out.println(numPuzzlesSolvedSteepest);
		System.out.println("That's " + percentSolved +"%");
		System.out.println("Here is the number of steps required for the first 10 solutions:");
		
		for (int i= 0;i<10;i++){
			System.out.println(numberStepsSolvedSteepest.get(i));
			
		}
		
		//print out stats for random restart
		System.out.println("Of 10 attempted random restart hill climbing searches, the system solved: " + numPuzzlesSolvedRandom);
		System.out.println("Here is the number of steps required for each solution:");
		
		for (Integer i: numberStepsSolved){
			System.out.println(i);
			
		}
		
		
		

	}
	


								
	

}
