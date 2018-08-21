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

public class CocktailErstellenFensterController {
	
	//ID für die Labels
	@FXML
    private Label lblCocktailErstellen;
	@FXML
    private Label lblUserNewCocktail;
	@FXML
    private Label lblAlkohol;
    @FXML
    private Label lblSoftdrink;
    @FXML
    private Label lblSaefte;
    @FXML
    private Label lblExtras;
    @FXML
    private Label lblGrammSoftdrink;
    @FXML
    private Label lblGrammSaefte;
    @FXML
    private Label lblGrammExtras;
    @FXML
    private Label lblGrammAlkohol;
    @FXML
    private Label lblKcal;
    @FXML
    private Label lblPreis;
    @FXML
    private Label lblAlkoholgeahalt;
    
    //Diese Labels verändern sich nach der Zutatenliste
    @FXML
    private Label lblKcalAnzeige;
    @FXML
    private Label lblPreisAnzeige;
    @FXML
    private Label lblAlkoholgehaltAnzeige;
    
    //ID für Textfelder
    @FXML
    private TextField tfNewCocktail;
    @FXML
    private TextField tfUserNewCocktail;
    @FXML
    private TextField tfGrammAlkohol;
    @FXML
    private TextField tfGrammSoftdrink;
    @FXML
    private TextField tfGrammSaefte;
    @FXML
    private TextField tfGrammExtras;

    //ID für ChoiceBoxen
    @FXML
    private ChoiceBox<?> cbAlkohol;
    @FXML
    private ChoiceBox<?> cbSoftdrink;
    @FXML
    private ChoiceBox<?> cbSaefte;
    @FXML
    private ChoiceBox<?> cbExtras;

    //ID für Buttons   
    @FXML
    private Button btnAddAlkohol;
    @FXML
    private Button btnAddSoftdrink;
    @FXML
    private Button btnAddSaefte;
    @FXML
    private Button btnAddExtras;
    @FXML
    private Button btnErstellen;
    @FXML
    private Button btnBackCocktailErstellen;

    //ID für die Tabelle und Spalten
    @FXML
    private TableView<?> tblZutaten;
    @FXML
    private TableColumn<?, ?> tblColumnZutat;
    @FXML
    private TableColumn<?, ?> tblColumnMenge;
    
    //Actions

    //Namen für Cocktail eingeben
    @FXML
    void writeCocktailErsteller(ActionEvent event) {

    }
    
    //Namen des Cocktail Erstellers
    @FXML
    void writeCocktailName(ActionEvent event) {

    }
    
    //Grammeingabe des Alkohols
    @FXML
    void writeGrammAlkohol(ActionEvent event) {

    }
    
  //Grammeingabe des Softdrinks
    @FXML
    void writeGrammSoftdrink(ActionEvent event) {

    }
    
    //Grammeingabe des Saftes
    @FXML
    void writeGrammSaefte(ActionEvent event) {

    }
    
  //Grammeingabe des Extras
    @FXML
    void writeGrammExtras(ActionEvent event) {

    }
    
    //Button- den Cocktail speichern
    @FXML
    void doCocktailErstellen(ActionEvent event) {

    }
    
    //Button- zurück zum Startfenster
    @FXML
     void doGoBackCocktailErstellen(ActionEvent event) {
    	final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
    }
    
}
