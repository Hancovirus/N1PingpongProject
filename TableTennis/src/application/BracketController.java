package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class BracketController implements Initializable {
	
	playerManagement p = new playerManagement();
	ArrayList<String> playerNameList = p.getplayerNameList();
	ArrayList<String> playingNameList = new ArrayList<String>();
	
	private static String player1str, player2str, player3str, player4str, player5str, player6str, player7str, player8str, player9str, player10str, player11str, player12str;
	
	private static String win12str, win34str, win56str, win78str, win910str, win1112str, lose1234str, lose5678str;
	
	private static String semi1str, semi2str, lsemi1str, lsemi2str, lfinal1str, lfinal2str, final1str, final2str, championstr;
	
	@FXML
	private ListView<String> playerList, playingList;
	
	@FXML
	private Label player1, player2, player3, player4, player5, player6, player7, player8, player9, player10, player11, player12;
	
	@FXML
	private Label win12, win34, win56, win78, win910, win1112, lose1234, lose5678;
	
	@FXML
	private Label semi1, semi2, lsemi1, lsemi2, lfinal1, lfinal2, final1, final2, champion;
	
	public void toWin12From1() {
		win12.setText(player1.getText());
		player9.setText(player2.getText());
	}
	
	public void toWin12From2() {
		win12.setText(player2.getText());
		player9.setText(player1.getText());
	}
	
	public void toWin34From3() {
		win34.setText(player3.getText());
		player10.setText(player4.getText());
	}
	
	public void toWin34From4() {
		win34.setText(player4.getText());
		player10.setText(player3.getText());
	}
	
	public void toWin56From5() {
		win56.setText(player5.getText());
		player11.setText(player6.getText());
	}

	public void toWin56From6() {
		win56.setText(player6.getText());
		player11.setText(player5.getText());
	}
	
	public void toWin78From7() {
		win78.setText(player7.getText());
		player12.setText(player8.getText());
	}
	
	public void toWin78From8() {
		win78.setText(player8.getText());
		player12.setText(player7.getText());
	}
	
	public void toWin910From9() {
		win910.setText(player9.getText());
	}
	
	public void toWin910From10() {
		win910.setText(player10.getText());
	}
	
	public void toWin1112From11() {
		win1112.setText(player11.getText());
	}
	
	public void toWin1112From12() {
		win1112.setText(player12.getText());
	}
	
	public void toSemi1FromWin12() {
		semi1.setText(win12.getText());
		lose1234.setText(win34.getText());
	}
	
	public void toSemi1FromWin34() {
		semi1.setText(win34.getText());
		lose1234.setText(win12.getText());
	}
	
	public void toSem21FromWin56() {
		semi2.setText(win56.getText());
		lose5678.setText(win78.getText());
	}
	
	public void toSemi2FromWin78() {
		semi2.setText(win78.getText());
		lose5678.setText(win56.getText());
	}
	
	public void toLsemi1FromLose1234() {
		lsemi1.setText(lose1234.getText());
	}
	
	public void toLsemi1FromWin910() {
		lsemi1.setText(win910.getText());
	}
	
	public void toLsemi2FromLose5678() {
		lsemi2.setText(lose5678.getText());
	}
	
	public void toLsemi2FromWin1112() {
		lsemi2.setText(win1112.getText());
	}
	
	public void toFinal1FromSemi1() {
		final1.setText(semi1.getText());
		lfinal1.setText(semi2.getText());
	}
	
	public void toFinal1FromSemi2() {
		final1.setText(semi2.getText());
		lfinal1.setText(semi1.getText());
	}
	
	public void toLfinal2FromLsemi1() {
		lfinal2.setText(lsemi1.getText());
	}
	
	public void toLfinal2FromLsemi2() {
		lfinal2.setText(lsemi2.getText());
	}
	
	public void toFinal2FromLfinal1() {
		final2.setText(lfinal1.getText());
	}
	
	public void toFinal2FromLfinal2() {
		final2.setText(lfinal2.getText());
	}
	
	public void toChampionFromFinal1() {
		champion.setText(final1.getText());
	}
	
	public void toChampionFromFinal2() {
		champion.setText(final2.getText());
	}
	
	public void shuffle() {	
	    if (playingNameList.size() == 1) {
	    	player1.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
		if (playingNameList.isEmpty()) {
			return;
		}
		Random random = new Random();
	    int i = random.nextInt(playingNameList.size() - 1);
	    player1.setText(playingNameList.get(i));
	    playingNameList.remove(i);
	    
	    if (playingNameList.size() == 1) {
	    	player2.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player2.setText(playingNameList.get(i));
	    playingNameList.remove(i);

	    if (playingNameList.size() == 1) {
	    	player3.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player3.setText(playingNameList.get(i));
	    playingNameList.remove(i);

	    if (playingNameList.size() == 1) {
	    	player4.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player4.setText(playingNameList.get(i));
	    playingNameList.remove(i);

	    if (playingNameList.size() == 1) {
	    	player5.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player5.setText(playingNameList.get(i));
	    playingNameList.remove(i);

	    if (playingNameList.size() == 1) {
	    	player6.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player6.setText(playingNameList.get(i));
	    playingNameList.remove(i);

	    if (playingNameList.size() == 1) {
	    	player7.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player7.setText(playingNameList.get(i));
	    playingNameList.remove(i);

	    if (playingNameList.size() == 1) {
	    	player8.setText(playingNameList.get(0));
	    	playingNameList.remove(0);
	    	return;
	    }
	    if (playingNameList.isEmpty()) {
			return;
		}
	    i = random.nextInt(playingNameList.size() - 1);
	    player8.setText(playingNameList.get(i));
	    playingNameList.remove(i);
	}
	
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public void switchSceneUi(ActionEvent e) throws IOException {
		player1str = player1.getText();
		player2str = player2.getText();
		player3str = player3.getText();
		player4str = player4.getText();
		player5str = player5.getText();
		player6str = player6.getText();
		player7str = player7.getText();
		player8str = player8.getText();
		player9str = player9.getText();
		player10str = player10.getText();
		player11str = player11.getText();
		player12str = player12.getText();
		win12str = win12.getText();
		win34str = win34.getText();
		win56str = win56.getText();
		win78str = win78.getText();
		win910str = win910.getText();
		win1112str = win1112.getText();
		lose1234str = lose1234.getText();
		lose5678str = lose5678.getText();
		semi1str = semi1.getText();
		semi2str = semi2.getText();
		lsemi1str = lsemi1.getText();
		lsemi2str = lsemi2.getText();
		lfinal1str = lfinal1.getText();
		lfinal2str = lfinal2.getText();
		final1str = final1.getText();
		final2str = final2.getText();
		championstr = champion.getText();
		root = FXMLLoader.load(getClass().getResource("Ui.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
	
	public void reset() {
		player1.setText("");
		player2.setText("");
		player3.setText("");
		player4.setText("");
		player5.setText("");
		player6.setText("");
		player7.setText("");
		player8.setText("");
		player9.setText("");
		player10.setText("");
		player11.setText("");
		player12.setText("");
		win12.setText("");
		win34.setText("");
		win56.setText("");
		win78.setText("");
		win910.setText("");
		win1112.setText("");
		lose1234.setText("");
		lose5678.setText("");
		semi1.setText("");
		semi2.setText("");
		lsemi1.setText("");
		lsemi2.setText("");
		lfinal1.setText("");
		lfinal2.setText("");
		final1.setText("");
		final2.setText("");
		champion.setText("");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playerList.getItems().setAll(playerNameList);
		
		player1.setText(player1str);
		player2.setText(player2str);
		player3.setText(player3str);
		player4.setText(player4str);
		player5.setText(player5str);
		player6.setText(player6str);
		player7.setText(player7str);
		player8.setText(player8str);
		player9.setText(player9str);
		player10.setText(player10str);
		player11.setText(player11str);
		player12.setText(player12str);
		win12.setText(win12str);
		win34.setText(win34str);
		win56.setText(win56str);
		win78.setText(win78str);
		win910.setText(win910str);
		win1112.setText(win1112str);
		lose1234.setText(lose1234str);
		lose5678.setText(lose5678str);
		semi1.setText(semi1str);
		semi2.setText(semi2str);
		lsemi1.setText(lsemi1str);
		lsemi2.setText(lsemi2str);
		lfinal1.setText(lfinal1str);
		lfinal2.setText(lfinal2str);
		final1.setText(final1str);
		final2.setText(final2str);
		champion.setText(championstr);
		
		playerList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				if (!playingNameList.contains(playerList.getSelectionModel().getSelectedItem()) && playingNameList.size() < 8) {
					playingNameList.add(playerList.getSelectionModel().getSelectedItem());
					playingList.getItems().setAll(playingNameList);
				}
			}
		});
		
		playingList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				for (int i = 0; i < playingNameList.size(); i++) {
					if (playingNameList.get(i).equals(playingList.getSelectionModel().getSelectedItem())) {
						playingNameList.remove(i);
						playingList.getItems().setAll(playingNameList);
						break;
					}
				}
			}
		});
	}
}
