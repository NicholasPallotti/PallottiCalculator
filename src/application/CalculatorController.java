package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//Class for handling button clicks of the calculator
public class CalculatorController {
	
	//the string input keeps track of what the user has input
	private String input = "";	
	
	//answerBox is where the current equation to be solved is placed, and the answer when the equals button is clicked
	@FXML
	private TextField answerBox;
	
	
	//each button method says which button being pressed it handles, and
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
		
		//create a new Calculator model instance with the input called answer
		CalculatorModel answer = new CalculatorModel(input);
		
		//call the do calculation method on answer and display it as a String
		answerBox.setText(String.valueOf(answer.doCalculation()));
				
		//reset the input so the user can continue using the calculator if they want
		input = "";	
		
	}

}
