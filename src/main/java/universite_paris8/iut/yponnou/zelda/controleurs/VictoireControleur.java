package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import universite_paris8.iut.yponnou.zelda.Lanceur;

import java.io.IOException;

public class VictoireControleur {

    @FXML
    private Button boutonRejouerV;
    @FXML
    private Button boutonRetourV;
    @FXML
    private Button boutonQuitterV;

    @FXML
    private void lancementRejouer() throws IOException {
        System.out.println("Rejouer le jeu");
        Stage oldStage, newStage;

        newStage = new Stage();
        oldStage = (Stage) boutonRejouerV.getScene().getWindow();
        oldStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("map.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        BorderPane root = (BorderPane) scene.getRoot();
        root.requestFocus();
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void lancementRetourMenu() throws IOException {
        System.out.println("Retour au Menu");
        Stage stage;

        stage = (Stage) boutonRetourV.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("menu.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.requestFocus();
        stage.show();
    }

    @FXML
    private void quitterLeJeu() {
        Stage stage = (Stage) boutonQuitterV.getScene().getWindow();
        stage.close();
    }
}
