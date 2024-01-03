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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class leaderboardController implements Initializable {
	
	playerManagement p = new playerManagement();
	
	@FXML
	private VBox leaderBoard;
	
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
		HBox title = new HBox(); 
		Label titlenums = new Label(" " + "Nums");
		titlenums.setMinWidth(70);
		Label titlelabel = new Label("Name");
		titlelabel.setMinWidth(200);
		Label titleelolabel = new Label("Elo");
		titleelolabel.setMinWidth(30);
		title.getChildren().addAll(titlenums, titlelabel, titleelolabel); 
		leaderBoard.getChildren().add(title);
		for (player p : playerList) {
			HBox hbox = new HBox(); 
			if (p.getElo() != previousElo) {
				Label nums = new Label(" " + Integer.toString(i) + ".");
				nums.setMinWidth(70);
				Label label = new Label(p.getName());
				label.setMinWidth(200);
				Label elolabel = new Label(Integer.toString(p.getElo()));
				elolabel.setMinWidth(30);
				hbox.getChildren().addAll(nums,label, elolabel); 
				i++;
			} else {
				Label nums = new Label(" " + "-");
				nums.setMinWidth(70);
				Label label = new Label(p.getName());
				label.setMinWidth(200);
				Label elolabel = new Label(Integer.toString(p.getElo()));
				elolabel.setMinWidth(30);
				hbox.getChildren().addAll(nums, label, elolabel); 
			}
			leaderBoard.getChildren().add(hbox);
			previousElo = p.getElo();
		}
	}
}
