package JavaFx;

import javafx.application.Application;
import javafx.stage.Stage;

public class FlowOfControl extends Application {
	public FlowOfControl() {
		System.out.println("JavaFxFlow constructor is invoked");
	}

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		System.out.println("start method is invoked");
	}

	public static void main(String[] args) {
		System.out.println("launch application");
		Application.launch();
	}
}
