package JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btOk = new Button("OK");
		StackPane pane = new StackPane();
		pane.getChildren().add(btOk);
//		pane.setStyle("-fx-background-color: yellow");
//		pane.setStyle("-fx-background-color: #FFFF00");
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
