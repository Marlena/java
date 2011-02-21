package perceptron;
/**
 * Course:  CS6523
 * Marlena Compton
 * Test 2 Part 2
 * Due Date: 04/22/2008
 */


import examples.*;
import java.math.*;
import java.util.*;

public class Perceptron {

	//list of weights
	double [] weights;
	int SIZEWEIGHTS ;
	ExampleSet mySet;
	double trainingTotal;
	int examplesCorrect, examplesIncorrect;
	int epochNumber;
	
	
	


	public Perceptron(){
		
		mySet = new ExampleSet();
		this.setTrainingTotal(0);
		this.setExamplesCorrect(0);
		
		this.setSIZEWEIGHTS(this.getMySet().getExampleSetIndex(0).getSIZEOF());
		
		weights = new double [this.getSIZEWEIGHTS()];
		this.setRandomWeights();
		
		this.go();
		
		
	}
	
	
	public void go(){
		
		
		this.setExamplesCorrect(0);
		
		//simulation of epochs
		//while there is at least one incorrect answer in a set
		do{
			this.incrementEpochNumber();
			//for each example in example set
			for (int i=0;i<this.mySet.getSetSize();i++){
				//obtain a correct or incorrect from the threshold
				
				
				boolean hitsTarget = this.isCorrect(this.getMySet().getExampleSetIndex(i) );
				if (hitsTarget){
					this.incrementExamplesCorrect();
					//System.out.print("correct for ");
					//this.getMySet().getExampleSetIndex(i).print();
					//this.printWeights();
				}
				
				
				//if incorrect, change weights
				if (!hitsTarget && this.getTrainingTotal()< 0.5 ){	
					//add each input to its corresponding weight
					for (int j=0; j<this.getMySet().getExampleSetIndex(i).getSIZEOF(); j++){
						
						double newWeight = weights[j] + this.getMySet().getExampleSetIndex(i).getExampleIndex(j);
											
						this.setWeightIndex(j, newWeight);
					}
				}
				
				else if (!hitsTarget && this.getTrainingTotal() >=0.5 ){
	
					//if total > 1+ threshold actual output is 1
					
					//subtract each input from its corresponding weight
					for (int j=0; j<this.getMySet().getExampleSetIndex(i).getSIZEOF(); j++){
						
						
						double newWeight = weights[j] - this.getMySet().getExampleSetIndex(i).getExampleIndex(j);
						
						this.setWeightIndex(j, newWeight);
						
						
					}
					
					
				}//end else if
				
				//this.getMySet().getExampleSetIndex(i).print();
				//this.printWeights();
					
			}//end for loop
		
			
		}while (this.getExamplesCorrect()< this.getMySet().getSetSize() );//end while loop for epoch
		
		System.out.println("Found correct weights in " + this.getEpochNumber() + " epoch(s).");
		this.printWeights();
	}//end go
	
	
	
	public boolean isCorrect(Example myExample){
		
		//clear out previous training total
		this.setTrainingTotal(0);
		double total = 0;
		
		for (int i=0;i<myExample.getSIZEOF();i++){
			
			total += weights[i] * myExample.getExampleIndex(i);

			
		}
		
		this.setTrainingTotal(total);
		
		if ((total >= 0.5 && myExample.getTarget()==1)||(total < 0.5 && myExample.getTarget()==0 )){
			return true;
		}
		
		return false;
		
	}
	
	public void printWeights(){
		
		System.out.print("Weights:\t");
		for (int i=0;i<this.SIZEWEIGHTS;i++){
			System.out.print(weights[i] + ",");
			
		}
		System.out.print("\n");
	}
	
	public int getExamplesCorrect() {
		return examplesCorrect;
	}


	public void setExamplesCorrect(int examplesCorrect) {
		this.examplesCorrect = examplesCorrect;
	}
	
	public void incrementExamplesCorrect(){
		this.examplesCorrect++;
	}
	
	public double getTrainingTotal() {
		return trainingTotal;
	}

	public void setTrainingTotal(double trainingTotal) {
		this.trainingTotal = trainingTotal;
	}

	public void setRandomWeights(){
		
		Random generator = new Random();
		
		for (int i=0;i<this.getSIZEWEIGHTS();i++){
			weights[i] = generator.nextDouble();
		}
	}
	
	

	public ExampleSet getMySet() {
		return mySet;
	}

	public void setMySet(ExampleSet mySet) {
		this.mySet = mySet;
	}

	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}

	public int getSIZEWEIGHTS() {
		return SIZEWEIGHTS;
	}

	public void setSIZEWEIGHTS(int sizeweights) {
		SIZEWEIGHTS = sizeweights;
	}
	
	public void setWeightIndex(int index, int value){
		weights[index] = value;
	}
	
	public void setWeightIndex(int index, double value){
		weights[index] = value;
	}
	//generate weights based on example


	public int getEpochNumber() {
		return epochNumber;
	}


	public void setEpochNumber(int epochNumber) {
		this.epochNumber = epochNumber;
	}
	
	public void incrementEpochNumber(){
		this.epochNumber++;
	}
}
