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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BracketController implements Initializable {
	
	playerManagement p = new playerManagement();
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private static String str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29;
	
	@FXML
	private ChoiceBox<String> choice1, choice2, choice3, choice4, choice5, choice6, choice7, choice8, choice9;
	@FXML
	private ChoiceBox<String> choice10, choice11, choice12, choice13, choice14, choice15, choice16, choice17, choice18, choice19;
	@FXML
	private ChoiceBox<String> choice20, choice21, choice22, choice23, choice24, choice25, choice26, choice27, choice28, choice29;
	
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
		choice1.setValue(str1);
		choice2.setValue(str2);
		choice3.setValue(str3);
		choice4.setValue(str4);
		choice5.setValue(str5);
		choice6.setValue(str6);
		choice7.setValue(str7);
		choice8.setValue(str8);
		choice9.setValue(str9);
		choice10.setValue(str10);
		choice11.setValue(str11);
		choice12.setValue(str12);
		choice13.setValue(str13);
		choice14.setValue(str14);
		choice15.setValue(str15);
		choice16.setValue(str16);
		choice17.setValue(str17);
		choice18.setValue(str18);
		choice19.setValue(str19);
		choice20.setValue(str20);
		choice21.setValue(str21);
		choice22.setValue(str22);
		choice23.setValue(str23);
		choice24.setValue(str24);
		choice25.setValue(str25);
		choice26.setValue(str26);
		choice27.setValue(str27);
		choice28.setValue(str28);
		choice29.setValue(str29);
		choice1.getItems().addAll(p.getplayerNameList());
		choice2.getItems().addAll(p.getplayerNameList());
		choice3.getItems().addAll(p.getplayerNameList());
		choice4.getItems().addAll(p.getplayerNameList());
		choice5.getItems().addAll(p.getplayerNameList());
		choice6.getItems().addAll(p.getplayerNameList());
		choice7.getItems().addAll(p.getplayerNameList());
		choice8.getItems().addAll(p.getplayerNameList());
		choice9.getItems().addAll(p.getplayerNameList());
		choice10.getItems().addAll(p.getplayerNameList());
		choice11.getItems().addAll(p.getplayerNameList());
		choice12.getItems().addAll(p.getplayerNameList());
		choice13.getItems().addAll(p.getplayerNameList());
		choice14.getItems().addAll(p.getplayerNameList());
		choice15.getItems().addAll(p.getplayerNameList());
		choice16.getItems().addAll(p.getplayerNameList());
		choice17.getItems().addAll(p.getplayerNameList());
		choice18.getItems().addAll(p.getplayerNameList());
		choice19.getItems().addAll(p.getplayerNameList());
		choice20.getItems().addAll(p.getplayerNameList());
		choice21.getItems().addAll(p.getplayerNameList());
		choice22.getItems().addAll(p.getplayerNameList());
		choice23.getItems().addAll(p.getplayerNameList());
		choice24.getItems().addAll(p.getplayerNameList());
		choice25.getItems().addAll(p.getplayerNameList());
		choice26.getItems().addAll(p.getplayerNameList());
		choice27.getItems().addAll(p.getplayerNameList());
		choice28.getItems().addAll(p.getplayerNameList());
		choice29.getItems().addAll(p.getplayerNameList());
		
		choice1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
	                str1 = choice1.getSelectionModel().getSelectedItem();
	        }
		});
		choice2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str2 = choice2.getSelectionModel().getSelectedItem();
		        }
		});
		choice3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str3 = choice3.getSelectionModel().getSelectedItem();
		        }
		});
		choice4.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str4 = choice4.getSelectionModel().getSelectedItem();
		        }
		});
		choice5.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str5 = choice5.getSelectionModel().getSelectedItem();
		        }
		});
		choice6.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str6 = choice6.getSelectionModel().getSelectedItem();
		        }
		});
		choice7.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str7 = choice7.getSelectionModel().getSelectedItem();
		        }
		});
		choice8.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str8 = choice8.getSelectionModel().getSelectedItem();
		        }
		});
		choice9.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str9 = choice9.getSelectionModel().getSelectedItem();
		        }
		});
		choice10.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str10 = choice10.getSelectionModel().getSelectedItem();
		        }
		});
		choice11.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str11 = choice11.getSelectionModel().getSelectedItem();
		        }
		});
		choice12.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str12 = choice12.getSelectionModel().getSelectedItem();
		        }
		});
		choice13.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str13 = choice13.getSelectionModel().getSelectedItem();
		        }
		});
		choice14.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str14 = choice14.getSelectionModel().getSelectedItem();
		        }
		});
		choice15.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str15 = choice15.getSelectionModel().getSelectedItem();
		        }
		});
		choice16.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str16 = choice16.getSelectionModel().getSelectedItem();
		        }
		});
		choice17.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str17 = choice17.getSelectionModel().getSelectedItem();
		        }
		});
		choice18.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str18 = choice18.getSelectionModel().getSelectedItem();
		        }
		});
		choice19.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str19 = choice19.getSelectionModel().getSelectedItem();
		        }
		});
		choice20.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str20 = choice20.getSelectionModel().getSelectedItem();
		        }
		});
		choice21.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str21 = choice21.getSelectionModel().getSelectedItem();
		        }
		});
		choice22.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str22 = choice22.getSelectionModel().getSelectedItem();
		        }
		});
		choice23.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str23 = choice23.getSelectionModel().getSelectedItem();
		        }
		});
		choice24.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str24 = choice24.getSelectionModel().getSelectedItem();
		        }
		});
		choice25.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str25 = choice25.getSelectionModel().getSelectedItem();
		        }
		});
		choice26.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str26 = choice26.getSelectionModel().getSelectedItem();
		        }
		});
		choice27.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str27 = choice27.getSelectionModel().getSelectedItem();
		        }
		});
		choice28.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str28 = choice28.getSelectionModel().getSelectedItem();
		        }
		});
		choice29.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		                str29 = choice29.getSelectionModel().getSelectedItem();
		        }
		});
	}
}
