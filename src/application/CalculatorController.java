package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//Class for handling button clicks of the calculator
public class CalculatorController {
	
	//the string input keeps track of what the user has input
	private String input = "";
	
	//a placeholder variable for the answer
	private double answer; 
	
	//answerBox is where the current equation to be solved is placed, and the answer when the equals button is clicked
	@FXML
	private TextField answerBox;
	
	
	//i'm tired and not going to comment all these buttons, each button method says which button being pressed it handles, and
	//will add that number/operator to the input string and redisplay the new input string
	@FXML
	private void button1Clicked(ActionEvent event) {
		input = input.concat("1");
		answerBox.setText(input);
	}
	
	@FXML
	private void button2Clicked(ActionEvent event) {
		input = input.concat("2");
		answerBox.setText(input);
	}
	
	@FXML
	private void button3Clicked(ActionEvent event) {
		input = input.concat("3");
		answerBox.setText(input);
	}
	
	@FXML
	private void button4Clicked(ActionEvent event) {
		input = input.concat("4");
		answerBox.setText(input);
	}
	
	@FXML
	private void button5Clicked(ActionEvent event) {
		input = input.concat("5");
		answerBox.setText(input);
	}
	
	@FXML
	private void button6Clicked(ActionEvent event) {
		input = input.concat("6");
		answerBox.setText(input);
	}
	
	@FXML
	private void button7Clicked(ActionEvent event) {
		input = input.concat("7");
		answerBox.setText(input);
	}
	
	@FXML
	private void button8Clicked(ActionEvent event) {
		input = input.concat("8");
		answerBox.setText(input);
	}
	
	@FXML
	private void button9Clicked(ActionEvent event) {
		input = input.concat("9");
		answerBox.setText(input);
	}
	
	@FXML
	private void button0Clicked(ActionEvent event) {
		input = input.concat("0");
		answerBox.setText(input);
	}
	
	@FXML
	private void buttonDivideClicked(ActionEvent event) {
		input = input.concat("/");
		answerBox.setText(input);
	}
	
	@FXML
	private void buttonMultiplyClicked(ActionEvent event) {
		input = input.concat("*");
		answerBox.setText(input);
	}
	
	@FXML
	private void buttonSubtractClicked(ActionEvent event) {
		input = input.concat("-");
		answerBox.setText(input);
	}
	
	@FXML
	private void buttonAddClicked(ActionEvent event) {
		input = input.concat("+");
		answerBox.setText(input);
	}
	
	@FXML
	private void buttonClearClicked(ActionEvent event) {
		input = "";
		answerBox.setText(input);
	}
	
	
	//method for when the equals button is clicked
	@FXML 
	private void buttonCalculateClicked(ActionEvent event) {
		
		//create a character array of the input split into characters
		char[] inputTokens = input.toCharArray();
		
		//call the do calculation method which will return the answer
		answer = doCalculation(inputTokens, 0);
	
		//reset the input so the user can continue using the calculator if they want
		input = "";
		
		//display the answer in the text box
		answerBox.setText(String.valueOf(answer));
	}

	//method for performing the calculation
	public double doCalculation(char inputTokens[], int index) {
		
		//a string for building the current number, between the operators
		String currentNumber = "";
		
		//a double to convert the string currentNumber to
		double number = 0;
		
		//a character to hold which operator is to be used
		char operator = ' ';

		//while loop to build the currntNumber String (while the index is a number and not an operator)	
		while(inputTokens[index] != '*' && inputTokens[index] != '/' && inputTokens[index] != '+' && inputTokens[index] != '-') {
			
			//concat the digit at inputTokens current index to currentNumber and increment index 
			currentNumber = currentNumber.concat(Character.toString( inputTokens[index]) );
			index ++;
			
			//set number equal to the value of current number
			number = Double.valueOf(currentNumber);
			
			//if the method has looped through the entire array of input tokens then return just number
			if (index > inputTokens.length - 1) {
				return number;
			}
		}
		
		//set the next digit to be the operator and increment index
		operator = inputTokens[index];
		index ++;
		
		//switch statement to perform the correct ooperator, will recursively call doCalculation with inputTokens and the current index
		//until input index has been looped through
		
		switch (operator) {
			case '*':
				return number * doCalculation(inputTokens, index);
				
			case '/':
				return number / doCalculation(inputTokens, index);
				
			case '+':
				return number + doCalculation(inputTokens, index);
				
			case '-':
				return number - doCalculation(inputTokens, index);
				
		}
		
		//eclipse was yelling at me to have a return statement so heres one that will never be called
		return operator;
		
	}
	
	
	
	/*
	
	I couldnt figure out how to  do order or operations ill try and fix it
	
	public double subtraction(String inputString) {
		
		double answer = 0;
		
		String[] placeholder = inputString.split("\\-");
		
	
		for(int i = 0; i < placeholder.length - 1; i++) {
			answer = addition(placeholder[i]) - addition(placeholder[i + 1]);
		}
		
		System.out.println("subtr " + answer);
		return answer;
	}
	
	public double addition(String inputString) {
		
		double answer = 0;
		
		String[] placeholder = inputString.split("\\+");
		
		
			
		
		for(int i = 0; i < placeholder.length - 1; i++) {
			answer =+ division(placeholder[i] + division(placeholder[i + 1]));
		}
		
		
		
	
		System.out.println("addiiton " + answer);
		return answer;
		
	}
	
	public double division(String inputString) {
		double answer = 0;
		
		String[] placeholder = inputString.split("\\/");
		
		
		for(int i = 0; i < placeholder.length - 1; i++) {
			answer = multiplication(placeholder[i]) / multiplication(placeholder[i + 1]) ;
		}
	
				
		System.out.println("division " + answer);
		return answer;
	}
	
	public double multiplication(String inputString) {
		double answer = 0;
		String[] placeholder = inputString.split("\\*");
			
		for(int i = 0; i < placeholder.length - 1; i++) {
			answer = Double.valueOf(placeholder[i]) * Double.valueOf(placeholder[i + 1]);
		}
		
		System.out.println("multip " + answer);
		return answer;
	}
	

	*/

	

}
