package javafxgui;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import chatclient.ChatServiceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL resource = this.getClass().getResource("./Hello.fxml");
			
			File file = new File(resource.toURI());
			// Create the FXMLLoader
			        FXMLLoader loader = new FXMLLoader();
			        FileInputStream fxmlStream = new FileInputStream(file);
			        AnchorPane root = (AnchorPane) loader.load(fxmlStream);

			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}