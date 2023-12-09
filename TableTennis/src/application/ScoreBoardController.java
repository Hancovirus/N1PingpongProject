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
    	Elo1.setText("Elo:" + Integer.toString(ph1.getElo()));
    	Elo2.setText("Elo:" + Integer.toString(ph2.getElo()));
    	int elo1 = ph1.getElo();
    	int elo2 = ph2.getElo();
    	double ex = 1 / (Math.pow(10, (elo2-elo1)/400) + 1);
    	Win1.setText("Up " + (int)(25 * (1 - ex)));
    	Lose1.setText("Down " + (int)(25 - (25 * (ex))));
    	Win2.setText("Up " + (int)(25 * (ex)));
    	Lose2.setText("Down " + (int)(25 - (25 * (1 - ex))));
	}
	
	public void Update() {
		int temp1 = Integer.parseInt(score1.getText());
		int temp2 = Integer.parseInt(score2.getText());
		matchHistory mh1 = null;
		matchHistory mh2 = null;
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
		
        for (int i = ph1.getmatchHistoryList().size() - 1; i >= 0; --i) {
        	if(ph1.getmatchHistoryList().get(i).getopponent().equals(player2.getSelectionModel().getSelectedItem()))
            {
                mh1 = ph1.getmatchHistoryList().get(i);
            }
        }
        
        for (int i = ph2.getmatchHistoryList().size() - 1; i >= 0; --i) {
        	if(ph2.getmatchHistoryList().get(i).getopponent().equals(player1.getSelectionModel().getSelectedItem()))
            {
                mh2 = ph2.getmatchHistoryList().get(i);
            }
        }
		
		if (ph1 == null || ph2 == null || mh1 == null || mh2 == null) {
			return;
		}

		int elo1 = ph1.getElo();
		int elo2 = ph2.getElo();
		
		double ex = 1 / (Math.pow(10, (elo2-elo1)/400) + 1);
		
        ph1.setGamePlayed(ph1.getGamePlayed() + 1);
        ph1.setPd(ph1.getPd() + temp1 - temp2);
        
        ph2.setGamePlayed(ph2.getGamePlayed() + 1);
        ph2.setPd(ph2.getPd() + temp2 - temp1);
        
        mh1.setGamePlayed(mh1.getGamePlayed() + 1);
        mh1.setdifferent(mh1.getdifferent() + temp1 - temp2);
        
        mh2.setGamePlayed(mh2.getGamePlayed() + 1);
        mh2.setdifferent(mh2.getdifferent() + temp2 - temp1);
        
        if (temp1 > temp2) {
        	ph1.setWin(ph1.getWin() + 1);
        	mh1.setwin(mh1.getwin() + 1);
        	ph2.setLose(ph2.getLose() + 1);
        	mh2.setlose(mh2.getlose() + 1);
        	ph1.setElo(ph1.getElo() + (int)(25 * (1 - ex)));
        	ph2.setElo(ph2.getElo() - (int)(25 - (25 * (1 - ex))));
        } else {
        	ph1.setLose(ph1.getLose() + 1);
        	mh1.setlose(mh1.getlose() + 1);
        	ph2.setWin(ph2.getWin() + 1);
        	mh2.setwin(mh2.getwin() + 1);
        	ph1.setElo(ph1.getElo() - (int)(25 - (25 * (ex))));
        	ph2.setElo(ph2.getElo() + (int)(25 * (ex)));
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
