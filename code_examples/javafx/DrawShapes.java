package JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawShapes extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStroke(Color.BLACK);
		circle.setFill(null);

		Ellipse ellipse = new Ellipse(100, 100, 75, 25);
		ellipse.setStroke(Color.BLACK);
		ellipse.setFill(null);

		Line line = new Line(50, 150, 150, 50);

		Arc arc = new Arc(100, 200, 75, 25, 90, 270);
		arc.setStroke(Color.BLACK);
		arc.setFill(null);

		Pane pane = new Pane();
//		pane.getChildren().add(circle);
//		pane.getChildren().add(ellipse);
//		pane.getChildren().add(line);
//		pane.getChildren().add(arc);
		pane.getChildren().addAll(circle, ellipse, line, arc);

		Scene scene = new Scene(pane, 200, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
