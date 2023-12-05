package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {

	static playerManagement p = new playerManagement();
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Ui.fxml"));
			Scene scene = new Scene(root);
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			
			stage.setTitle("Table tennis");
		    
		    stage.setScene(scene);
		    stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(final String[] args) { 
		p.loadFromFile();
		launch(args);
	}
}
