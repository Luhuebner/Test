package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BestellungFensterController {
	
	//ID der Labels
	@FXML
    private Label lblCocktailSuchen;
	@FXML
    private Label lblErsteAuswahl;
	@FXML
    private Label lblZutaten;
	@FXML
    private Label lblZweiteAuswahl;
	@FXML
    private Label lblPreis;
    @FXML
    private Label lblEuroZeichen;
    @FXML
    private Label lblListeCocktails;
    @FXML
    private Label lblListeSortieren;
    
    //Preis des Warenkorbs- muss sich verändern
    @FXML
    private Label lblPreisWarenkorb;
    
    //ID der Buttons
    @FXML
    private Button btnSuch;
    @FXML
    private Button btnAuswahlHinzufuegen;
    @FXML
    private Button btnZutatenFiltern;
    @FXML
    private Button btnWKBestellen;
    @FXML
    private Button btnListeSortieren;
    @FXML
    private Button btnBackWindowCocktail;
    
    //ID Textfeld
    @FXML
    private TextField tfCocktailSuche;
    
    //ID Tabelle und Spalten der Zutaten
    @FXML
    private TableView<?> tblAusgewaehlteZutaten;
    @FXML
    private TableColumn<?, ?> tcZutaten;

    //ID Tabelle und Spalten Warenkorb
    @FXML
    private TableView<?> tblWarenkorb;
    @FXML
    private TableColumn<?, ?> tblWKCocktail;
    @FXML
    private TableColumn<?, ?> tblWKMenge;
    @FXML
    private TableColumn<?, ?> tblWKPreis;
    
    //ID Tabelle und Spalten gefundener Cocktails
    @FXML
    private TableView<?> tblListeCocktail;
    @FXML
    private TableColumn<?, ?> tblLCName;
    @FXML
    private TableColumn<?, ?> tblLCAlkoholgehalt;
    @FXML
    private TableColumn<?, ?> tblLCKcal;
    @FXML
    private TableColumn<?, ?> tblLCPreis;
    
    //ID Choiceboxen
    @FXML
    private ChoiceBox<?> cbAuswahl1;
    @FXML
    private ChoiceBox<?> cbAuswahl2;
    @FXML
    private ChoiceBox<?> cbListeSortieren;

    //Actions

    //Choicebox Auswahl1 wenn ausgewählt wird
    /*@FXML
    void chooseAuswahl1(MouseEvent event) {

    }
    
	//Choicebox Auswahl2 wenn ausgewählt wird
    @FXML
    void chooseAuswahl2(MouseEvent event) {

    }
    
    //Choicebox Liste sortieren, nach welchem Kriterium sortiert werden soll
    @FXML
    void chooseListeSortieren(MouseEvent event) {

    }
*/ 
    
    //Button- ausgewählten Zutaten aus den Choiceboxen der Tabelle hinzufügen
    @FXML
    void doAuswahlHinzufuegen(ActionEvent event) {

    }
    
    //Button- Liste gefundenener Cocktails nach dem Kriterium der Choicebox sortieren
    @FXML
    void doListeSortieren(ActionEvent event) {

    }

    //Button- Namenssuche nach einem Cocktail aus Textfeld
    @FXML
    void doSearchCocktail(ActionEvent event) {

    }

    //Button- Cocktails aus dem Warenkorb bestellen und aus dem Inventar reduzieren
    @FXML
    void doWKBestellen(ActionEvent event) {

    }

    //Button Zutaten filtern (Überhaupt nötig?)
    @FXML
    void doZutatenFiltern(ActionEvent event) {

    }

    //Textfeld Cocktail nach Namen suchen
    @FXML
    void writeCocktailSuche(ActionEvent event) {

    }
    
    //Zurück zum Startfenster
    @FXML
    void doGoBackWindowCocktail(ActionEvent event) {
    	final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
}
