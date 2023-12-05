package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ScoreBoardController implements Initializable {
	playerManagement p = new playerManagement();
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextArea score1, score2, name1, name2;
	@FXML
	private ChoiceBox<String> player2, player1;
	@FXML
	private Label Elo1, Elo2, Win1, Win2, Lose1, Lose2; 
	
	public void reset() {
		score1.setText("0");
		score2.setText("0");
	}
	
	public void Up1() {
		int temp = Integer.parseInt(score1.getText());
		temp++;
		score1.setText(Integer.toString(temp));
	}
	
	public void Up2() {
		int temp = Integer.parseInt(score2.getText());
		temp++;
		score2.setText(Integer.toString(temp));
	}
	
	public void Down1() {
		int temp = Integer.parseInt(score1.getText());
		if (temp == 0) {
			return;
		}
		temp--;
		score1.setText(Integer.toString(temp));
	}
	
	public void Down2() {
		int temp = Integer.parseInt(score2.getText());
		if (temp == 0) {
			return;
		}
		temp--;
		score2.setText(Integer.toString(temp));
	}
	
	public void compare() {
		player ph1 = null;
		player ph2 = null;
		for(int i = p.getplayerList().size() - 1; i >= 0; --i) 
        {
        	if(p.getplayerList().get(i).getName().equals(player1.getSelectionModel().getSelectedItem()))
            {
        		ph1 = p.getplayerList().get(i);
            }
        	if(p.getplayerList().get(i).getName().equals(player2.getSelectionModel().getSelectedItem()))
            {
        		ph2 = p.getplayerList().get(i);
            }
        }
    	if (ph1 == null || ph2 == null) {
			return;
		}
    	String UpDown = "Up ";
    	Elo1.setText("Elo:" + Integer.toString(ph1.getElo()));
    	Elo2.setText("Elo:" + Integer.toString(ph2.getElo()));
    	int temp = 400 * (ph1.getWin() + 1 - ph1.getLose());
    	temp += ph1.getOpponentRatingTotal() + ph2.getElo();
    	temp /= (ph1.getGamePlayed() + 1);
    	temp -= ph1.getElo();
    	if (temp < 0) {
    		temp = -temp;
    		UpDown = "Down ";
    	} else {
    		UpDown = "Up ";
    	}
    	Win1.setText(UpDown + Integer.toString(temp));
    	temp = 400 * (ph2.getWin() + 1 - ph2.getLose());
    	temp += ph2.getOpponentRatingTotal() + ph1.getElo();
    	temp /= (ph2.getGamePlayed() + 1);
    	temp -= ph2.getElo();
    	if (temp < 0) {
    		temp = -temp;
    		UpDown = "Down ";
    	} else {
    		UpDown = "Up ";
    	}
    	Win2.setText(UpDown + Integer.toString(temp));
    	temp = 400 * (ph1.getWin() - 1 - ph1.getLose());
    	temp += ph1.getOpponentRatingTotal() + ph2.getElo();
    	temp /= (ph1.getGamePlayed() + 1);
    	temp -= ph1.getElo();
    	if (temp < 0) {
    		temp = -temp;
    		UpDown = "Down ";
    	} else {
    		UpDown = "Up ";
    	}
    	Lose1.setText(UpDown + Integer.toString(temp));
    	temp = 400 * (ph2.getWin() - 1 - ph2.getLose());
    	temp += ph2.getOpponentRatingTotal() + ph1.getElo();
    	temp /= (ph2.getGamePlayed() + 1);
    	temp -= ph2.getElo();
    	if (temp < 0) {
    		temp = -temp;
    		UpDown = "Down ";
    	} else {
    		UpDown = "Up ";
    	}
    	Lose2.setText(UpDown + Integer.toString(temp));
	}
	
	public void Update() {
		int temp1 = Integer.parseInt(score1.getText());
		int temp2 = Integer.parseInt(score2.getText());
		matchHistory mh = null;
		if (temp1 == temp2) {
			return;
		}
		player ph1 = null;
		player ph2 = null;
		
		for(int i = p.getplayerList().size() - 1; i >= 0; --i) 
        {
        	if(p.getplayerList().get(i).getName().equals(player1.getSelectionModel().getSelectedItem()))
            {
        		ph1 = p.getplayerList().get(i);
            }
        	
        	if(p.getplayerList().get(i).getName().equals(player2.getSelectionModel().getSelectedItem()))
            {
        		ph2 = p.getplayerList().get(i);
            }
        }
		
		if (ph1 == null || ph2 == null) {
			return;
		}
		
		ph1.setOpponentRatingTotal(ph1.getOpponentRatingTotal() + ph2.getElo());
		ph2.setOpponentRatingTotal(ph1.getElo() + ph2.getOpponentRatingTotal());
        ph1.setGamePlayed(ph1.getGamePlayed() + 1);
        ph1.setPd(ph1.getPd() + temp1 - temp2);
        ph2.setGamePlayed(ph2.getGamePlayed() + 1);
        ph2.setPd(ph2.getPd() + temp2 - temp1);
		
        for (int j = ph1.getmatchHistoryList().size() - 1; j >= 0; --j) {
        	if(ph1.getmatchHistoryList().get(j).getopponent().equals(player2.getSelectionModel().getSelectedItem()))
            {
                mh = ph1.getmatchHistoryList().get(j);
            }
        }
        
        mh.setGamePlayed(mh.getGamePlayed() + 1);
        mh.setdifferent(mh.getdifferent() + temp1 - temp2);
        
        if (temp1 > temp2) {
        	ph1.setWin(ph1.getWin() + 1);
        	mh.setwin(mh.getwin() + 1);
        } else {
        	ph1.setLose(ph1.getLose() + 1);
        	mh.setlose(mh.getlose() + 1);
        }
        for (int j = ph2.getmatchHistoryList().size() - 1; j >= 0; --j) {
        	if(ph2.getmatchHistoryList().get(j).getopponent().equals(player1.getSelectionModel().getSelectedItem()))
            {
                mh = ph2.getmatchHistoryList().get(j);
            }
        }
        
        mh.setGamePlayed(mh.getGamePlayed() + 1);
        mh.setdifferent(mh.getdifferent() + temp2 - temp1);
        
        if (temp1 < temp2) {
        	ph2.setWin(ph2.getWin() + 1);
        	mh.setwin(mh.getwin() + 1);
        } else {
        	ph2.setLose(ph2.getLose() + 1);
        	mh.setlose(mh.getlose() + 1);
        }
		reset();
		p.ExportToFile();
	}
	
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
		reset();
		player1.getItems().addAll(p.getplayerNameList());
		player2.getItems().addAll(p.getplayerNameList());
		player1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				name1.setText(player1.getSelectionModel().getSelectedItem());
			}
		});
		
		player2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				name2.setText(player2.getSelectionModel().getSelectedItem());
			}
		});
	}
}
