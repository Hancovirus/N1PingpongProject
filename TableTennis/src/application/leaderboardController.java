package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class leaderboardController implements Initializable {
	
	playerManagement p = new playerManagement();
	
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private ListView<String> leaderBoard;
	
	@FXML
	private ListView<Integer> leaderBoardElo;
	
	@FXML
	public void switchSceneUi(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Ui.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ArrayList<player> playerList = p.getplayerList();
		Collections.sort(playerList, new Comparator<player>() {
			@Override
			public int compare(player o1, player o2) {
				return o2.getElo() - o1.getElo();
			}
        });
		int i = 1;
		int previousElo = 0;
		ArrayList<String> playerNameList = new ArrayList<String>();
		ArrayList<Integer> playerEloList = new ArrayList<Integer>();
		for (player p : playerList) {
			String temp;
			if (p.getElo() != previousElo) {
				temp = i + ".\t" + p.getName();
				i++;
			} else {
				temp = "-\t" + p.getName();
			}
			playerNameList.add(temp);
			playerEloList.add(p.getElo());
			previousElo = p.getElo();
		}
		leaderBoard.getItems().setAll(playerNameList);
		leaderBoardElo.getItems().setAll(playerEloList);
	}
}
