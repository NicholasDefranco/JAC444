package JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFXTest extends Application {
	@Override
	// override the start method in the Application class
	public void start(Stage Primarystage) {
		Button btok = new Button("ok");
		Scene scene = new Scene(btok, 1000, 250);
		Primarystage.setTitle("MyJavFX");
		Primarystage.setScene(scene);
		Primarystage.show();

	}

	public static void main(String args[]) {
		Application.launch();
	}
}
