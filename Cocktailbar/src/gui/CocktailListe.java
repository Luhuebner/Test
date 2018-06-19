package gui;

import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CocktailListe {

    @FXML
    private Label lblCocktailSuchen;

    @FXML
    private AutoCompleteTextField<?> tfSuch;

    @FXML
    private Label lblZutaten;

    @FXML
    private Button btnSuch;

    @FXML
    private TableView<?> tblAusgewaehlteZutaten;

    @FXML
    private TableColumn<?, ?> tcZutaten;

    @FXML
    private ChoiceBox<?> cbAuswahl1;

    @FXML
    private Label lblErsteAuswahl;

    @FXML
    private Label lblZweiteAuswahl;

    @FXML
    private ChoiceBox<?> cbAuswahl2;

    @FXML
    private Button btnHinzufuegen;

    @FXML
    private Button btnFiltern;

    @FXML
    private Label lblWarenkorb;

    @FXML
    private TableView<?> tblWarenkorb;

    @FXML
    private TableColumn<?, ?> tblWKCocktail;

    @FXML
    private TableColumn<?, ?> tblWKPreis;

    @FXML
    private TableColumn<?, ?> tblWKMenge;

    @FXML
    private Label lblPreis;

    @FXML
    private Label llblPreisWarenkorb;

    @FXML
    private Label lblEuroZeichen;

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

    @FXML
    private Label lblListeCocktails;

    @FXML
    private Label lblListeSortieren;

    @FXML
    private ChoiceBox<?> cbListeSortieren;

    @FXML
    private Button btnListeSortieren;

}
