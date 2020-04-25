package JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStage extends Application {

	@Override
	// Override the start method in the Application class
	public void start(Stage PrimaryStage) {
		// create a scene and place a button in the scene
		Scene scene = new Scene(new Button("ok"), 200, 250);
		PrimaryStage.setTitle("MyJavaFX");
		PrimaryStage.setScene(scene);
		PrimaryStage.show();

		Stage stage = new Stage(); // create a new stage
		stage.setTitle("Second Stage");
		// set a scene with a button in the stage
		stage.setScene(new Scene(new Button("new Stage"), 100, 100));
		stage.show();// display the stage
	}

}
