package JavaFx;

//import java.awt.Font;
//import java.awt.Label;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
//import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontTest extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new StackPane();
		// create a circle
		Circle circle = new Circle();
		circle.setRadius(50);
		circle.setStroke(Color.PURPLE);
		circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
		pane.getChildren().add(circle);
		// create a lable
		Label lable1 = new Label("JAVAFX");
		lable1.setFont(Font.font("Times new Roman", FontWeight.BOLD,
				FontPosture.ITALIC, 20));
		pane.getChildren().add(lable1);
		Scene scene = new Scene(pane);
		primaryStage.setTitle("FONT DEMO");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String args[]) {
		Application.launch();
	}

}
