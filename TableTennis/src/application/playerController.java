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
import javafx.scene.control.*;
import javafx.stage.Stage;

public class playerController implements Initializable {
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button addButton, compareButton;
	
	@FXML
	private TextField nameField, nickNameField;
	
	@FXML
	private TextArea info1, info2, compareArea;
	
	@FXML
	private ListView<String> infoList1, infoList2;
	
	@FXML
	private ChoiceBox<String> DeleteBox;
	
	playerManagement p = new playerManagement();
	
	private void updateList() {
		infoList1.getItems().clear();
		infoList2.getItems().clear();
		DeleteBox.getItems().clear();
		infoList1.getItems().addAll(p.getplayerNameList());
		infoList2.getItems().addAll(p.getplayerNameList());
		DeleteBox.getItems().addAll(p.getplayerNameList());
	}
	
	public void addPlayer(ActionEvent e) {
		p.addPlayer(nameField.getText(), nickNameField.getText());
		p.ExportToFile();
		nameField.setText("");
		nickNameField.setText("");
		updateList();
	}
	
	public void deletePlayer(ActionEvent e) {
		p.deletePlayer(DeleteBox.getValue());
		p.ExportToFile();
		updateList();
	}
	
	public void compare(ActionEvent e) {
		for(int i = p.getplayerList().size() - 1; i >= 0; --i) 
        {
        	if(p.getplayerList().get(i).getName().equals(infoList1.getSelectionModel().getSelectedItem()))
            {
        		compareArea.setText(p.getplayerList().get(i).matchHistoryLookUp(infoList2.getSelectionModel().getSelectedItem()));
            }
        }
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
		updateList();
		
		infoList1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				info1.setText(p.playerLookUp(infoList1.getSelectionModel().getSelectedItem()));
			}
		});
		
		infoList2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				info2.setText(p.playerLookUp(infoList2.getSelectionModel().getSelectedItem()));
			}
		});
	}
}
