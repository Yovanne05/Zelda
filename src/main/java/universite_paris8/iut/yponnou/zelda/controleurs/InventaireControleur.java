package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

import java.net.URL;
import java.util.ResourceBundle;

public class InventaireControleur implements Initializable {

    @FXML
    private GridPane gridPaneInventaire;
    @FXML
    private Pane paneInventaire;

    private ObservableList<Objet> inventaire;

    private static final int NB_COLONNES = 4;
    private int ligneSelectionne = 0;
    private int colonneSelectionne = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Ajouter un listener pour les événements de clavier
        paneInventaire.addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPress);
    }

    // Méthode pour définir la liste des objets
    public void setInventaire(ObservableList<Objet> inventaire) {
        this.inventaire = inventaire;
        populateGridPane();
    }

    private void populateGridPane() {
        gridPaneInventaire.getChildren().clear();
        for (int i = 0; i < inventaire.size(); i++) {
            Objet obj = inventaire.get(i);
            ImageView imageView = new ImageView(new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/carre/carre.png"));
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            int row = i / NB_COLONNES;
            int col = i % NB_COLONNES;
            gridPaneInventaire.add(imageView, col, row);
        }
        highlightSelectedCell();
    }

    // Méthode pour surligner la cellule sélectionnée
    private void highlightSelectedCell() {
        for (Node node : gridPaneInventaire.getChildren()) {
            node.setStyle("");
        }
        Node selectedNode = getNodeByRowColumnIndex(ligneSelectionne, colonneSelectionne, gridPaneInventaire);
        if (selectedNode != null) {
            selectedNode.setStyle("-fx-border-color: blue; -fx-border-width: 2;");
        }
    }

    // Obtenir le noeud du GridPane par l'index de la ligne et de la colonne
    private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == row &&
                    GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) == column) {
                return node;
            }
        }
        return null;
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case Z:
                deplacementHaut();
                break;
            case S:
                deplacementBas();
                break;
            case Q:
                deplacementGauche();
                break;
            case D:
                deplacementDroit();
                break;
            case I:
                closeInventory();
                break;
        }
    }

    private void deplacementHaut() {
        if (ligneSelectionne > 0) {
            ligneSelectionne--;
            highlightSelectedCell();
        }
    }

    private void deplacementBas() {
        if (ligneSelectionne < (inventaire.size() - 1) / NB_COLONNES) {
            ligneSelectionne++;
            highlightSelectedCell();
        }
    }

    private void deplacementGauche() {
        if (colonneSelectionne > 0) {
            colonneSelectionne--;
            highlightSelectedCell();
        }
    }

    private void deplacementDroit() {
        if (colonneSelectionne < NB_COLONNES - 1 && (ligneSelectionne * NB_COLONNES + colonneSelectionne + 1) < inventaire.size()) {
            colonneSelectionne++;
            highlightSelectedCell();
        }
    }

    private void closeInventory() {
        Stage stage = (Stage) paneInventaire.getScene().getWindow();
        stage.close();
    }
}