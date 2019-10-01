package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage primaryStage){ //load the calculator
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Calculator.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("JavaFX Events");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//main method
	public static void main(String[] args) {
		launch(args);
	}

}
