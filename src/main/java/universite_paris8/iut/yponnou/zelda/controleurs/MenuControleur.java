package universite_paris8.iut.yponnou.zelda.controleurs;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import universite_paris8.iut.yponnou.zelda.Lanceur;

import java.io.IOException;

public class MenuControleur {

    @FXML
    public Button boutonLancer;
    @FXML
    public Button boutonHistoire;
    @FXML
    public Button boutonCommandes;

    @FXML
    private void lancementJeu() throws IOException {
        Stage oldStage, newStage;

        newStage = new Stage();
        oldStage = (Stage) boutonLancer.getScene().getWindow();
        oldStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("map.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        BorderPane root = (BorderPane) scene.getRoot();
        root.requestFocus();
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void lancementHistoire() throws IOException {
        Stage stage = (Stage) boutonHistoire.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("histoire.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.requestFocus();
        stage.show();
        System.out.println("Affichage Histoire");

    }

    @FXML
    private void lancementCommandes() throws IOException {
        // Code pour afficher les commandes du jeu
        Stage stage = (Stage) boutonCommandes.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("commandes.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.requestFocus();
        stage.show();
        System.out.println("Affichage Commandes");
    }
}
