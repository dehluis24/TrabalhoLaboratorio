package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			TabPane tabPane = (TabPane)FXMLLoader.load(this.getClass().getResource("layout.fxml"));
			Scene scene = new Scene(tabPane);
			
			primaryStage.setTitle("Cantinho Dos Bichos");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

