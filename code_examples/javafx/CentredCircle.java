package JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CentredCircle extends Application {
	@Override
	public void start(Stage primaryStage) {
		// create a pane and hold the circle\
		Pane pane = new Pane();
		// create a circle and set the properties
		Circle circle = new Circle();
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		circle.setRadius(50);

		// circle.setStroke(Color.WHITE);
		// circle.setFill(Color.PINK);
		circle.setStyle("-fx:BLACK;-fx-fill:BLUE");
		pane.getChildren().add(circle);// add circle into the pane
		// create the scene and then place into the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("show Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}

}
