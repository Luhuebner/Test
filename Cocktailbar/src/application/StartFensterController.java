package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartFensterController {
	@FXML
	private Button btnBestellung;

	@FXML
	private Button btnCocktailErstellen;

	@FXML
	private Button btnCloseGetStartet;

	//Zum Bestellungsfenster wechseln
	@FXML
	void doChangeToCocktailListe(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("BestellungFenster.fxml"));
			/*
			 * if "fx:controller" is not set in fxml
			 * fxmlLoader.setController(NewWindowController);
			 */
			Scene scene = new Scene(fxmlLoader.load(), 880, 580);
			Stage stage = new Stage();
			stage.setTitle("Cocktail Liste");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// Logger logger = Logger.getLogger(getClass().getName());
			// logger.log(Level.SEVERE, "Failed to create new Window.", e);
		}

	}
	
	//Zum Cocktail-Erstellungs- Fenster wechseln
	@FXML
	void doChangeToNewCocktail(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("CocktailErstellenFenster.fxml"));
			/*
			 * if "fx:controller" is not set in fxml
			 * fxmlLoader.setController(NewWindowController);
			 */
			Scene scene = new Scene(fxmlLoader.load(), 646, 400);
			Stage stage = new Stage();
			stage.setTitle("Neuen Cocktail erstellen");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// Logger logger = Logger.getLogger(getClass().getName());
			// logger.log(Level.SEVERE, "Failed to create new Window.", e);
		}

	}
	//Anwendung schlieﬂen
	@FXML
	void doCloseGetStarted(ActionEvent event) {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

}
