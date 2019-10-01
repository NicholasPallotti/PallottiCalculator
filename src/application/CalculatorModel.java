package application;

public class CalculatorModel {
	
	//class variables
	private String input;
	private double answer;
	
	//booleans that keep track of whether an operator is being used
	boolean subtraction;
	boolean addition;
	boolean division;
	boolean multiplication;
	
	
	//Constructor for Calculator model
	CalculatorModel(String input){
		this.input = input;
		
		//finds what operators will be needed and for the operators needed sets the corresponding boolean to true
		if(input.contains("-")) {
			subtraction = true;
			System.out.println("sub true");
		}

		if(input.contains("+")) {
			addition = true;
			System.out.println("add true");
		}

		if(input.contains("/")) {
			division = true;
			System.out.println("div true");
		}

		if(input.contains("*")) {
			multiplication = true;
			System.out.println("mult true");
		}
		
	}
	
	//method for doing the calculation
	public double doCalculation() {
		
		//in order to make the programming easier the program will skip the methods of unused operators
		//the lowest level operator the input string contains (pemdas going backwards) is used first
		if(subtraction == true) {
			return answer = subtraction(input);
		}
		
		else if(addition == true) {
			return answer = addition(input);
		}
		
		else if(division == true) {
			return answer = division(input);
		}
		
		else if(multiplication == true) {
			return answer = multiplication(input);
		}
		//this else statement is in case the user only enters a number with no operators
		else {
			return Double.valueOf(input);
		}
		
	}
	
	//method for doing subtraction
	public double subtraction(String inputString) {
		
		//split the input string into sub blocks that need to be subtracted from each other
		String[] placeHolder = inputString.split("\\-");
		
		double answerHolder = Double.valueOf(placeHolder[0]);
		
		//like earlier the program only calls calculation methods it needs to use
		//i starts at 1 since we set answerHolder equal to placeHolder[0]
		if(addition == true) {
			for(int i = 1; i < placeHolder.length; i++) {
				answerHolder -= addition(placeHolder[i]);
			}
		}
		
		else if(division == true) {
			for(int i = 1; i < placeHolder.length; i++) {
				answerHolder -= division(placeHolder[i]);
			}
		}
		
		else if(multiplication == true) {
			for(int i = 1; i < placeHolder.length; i++) {
				answerHolder -= multiplication(placeHolder[i]);
			}
		}
		
		//the else is in case there is only subtraction
		else {
			for(int i = 1; i < placeHolder.length; i++) {
				answerHolder -= Double.valueOf(placeHolder[i]);
			}
		}

		return answerHolder;
	}
	
	//method for doing addition
	public double addition(String inputString) {
		
		double answerHolder = 0;
		
		//split the input string into sub blocks that need to be added to each other
		String[] placeHolder = inputString.split("\\+");
		
		//like earlier the program only calls calculation methods it needs to use
		if(division == true) {
			for(int i = 0; i < placeHolder.length; i++) {
				answerHolder += division(placeHolder[i]);
			}
		}
		
		else if(multiplication == true) {
			for(int i = 0; i < placeHolder.length; i++) {
				answerHolder += multiplication(placeHolder[i]);
			}
		}
		
		//the else is in case there is only addition
		else {
			for(int i = 0; i <placeHolder.length; i++) {
				answerHolder += Double.valueOf(placeHolder[i]);
			}
		}
		
		return answerHolder;
		
	}
	
	//method for performing division
	public double division(String inputString) {
			
		String[] placeHolder = inputString.split("\\/");
		
		//split the input string into sub blocks that need to be divided by each other
		double answerHolder = Double.valueOf(placeHolder[0]);
		
		//like earlier the program only calls calculation methods it needs to use
		if(multiplication == true) {
			for(int i = 1; i < placeHolder.length; i++) {
				answerHolder /= multiplication(placeHolder[i]);
			}
		}
		
		//the else is in case no multiplication is needed
		else {
			for(int i = 1; i <placeHolder.length; i++) {
				answerHolder /= Double.valueOf(placeHolder[i]);
			}
		}
		
		return answerHolder;
	}
	
	//method for performing multiplication
	public double multiplication(String inputString) {
		
		double answerHolder = 1;
		
		//split the input string into sub blocks that need to be divided by each other
		String[] placeHolder = inputString.split("\\*");
		
		//see we are at the last level of operators we dont need to check if any other operators need to be done and can just do the multiplication
		for(int i = 0; i <placeHolder.length; i++) {
			answerHolder *= Double.valueOf(placeHolder[i]);
		}

		return answerHolder;
	}
}
