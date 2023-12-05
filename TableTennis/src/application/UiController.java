package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UiController {
	
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button playerButton, bracketButton, matchupButton, scoreButton;
	
	@FXML
	public void switchSceneplayer(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("player.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void switchSceneleader(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchScenebracket(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Bracket.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void switchSceneScoreBoard(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ScoreBoard.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
}
