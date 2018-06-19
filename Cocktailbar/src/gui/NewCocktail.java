package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class NewCocktail {

    @FXML
    private Label lblCocktailErstellen;

    @FXML
    private Label lblUserNewCocktail;

    @FXML
    private TextField tfNewCocktail;

    @FXML
    private TextField tfUserNewCocktail;

    @FXML
    private Label lblAlkohol;

    @FXML
    private Label lblSoftdrink;

    @FXML
    private Label lblSaefte;

    @FXML
    private Label lblExtras;

    @FXML
    private ChoiceBox<?> cbAlkohol;

    @FXML
    private ChoiceBox<?> cbSoftdrink;

    @FXML
    private ChoiceBox<?> cbSaefte;

    @FXML
    private ChoiceBox<?> cbExtras;

    @FXML
    private TableView<?> tblZutaten;

    @FXML
    private TableColumn<?, ?> tblColumnZutat;

    @FXML
    private TableColumn<?, ?> tblColumnMenge;

    @FXML
    private Button btnBestellen;

    @FXML
    private Label lblKcal;

    @FXML
    private Label lblAlkoholgeahalt;

    @FXML
    private Label lblPreis;

    @FXML
    private TextField tfGrammAlkohol;

    @FXML
    private TextField tfGrammSoftdrink;

    @FXML
    private TextField tfGrammSaefte;

    @FXML
    private TextField tfGrammExtras;

    @FXML
    private Label lblGrammAlkohol;

    @FXML
    private Label lblGrammSoftdrink;

    @FXML
    private Label lblGrammSaefte;

    @FXML
    private Label lblGrammExtras;

    @FXML
    private Button btnAddAlkohol;

    @FXML
    private Button btnAddSoftdrink;

    @FXML
    private Button btnAddSaefte;

    @FXML
    private Button btnAddExtras;

    @FXML
    private Label lblKcalAnzeige;

    @FXML
    private Label lblPreisAnzeige;

    @FXML
    private Label lblAlkoholgehaltAnzeige;

}

