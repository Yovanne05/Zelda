package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import universite_paris8.iut.yponnou.zelda.Lanceur;
import universite_paris8.iut.yponnou.zelda.vue.son.Son;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VictoireControleur implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            musiqueVictoire.jouer(0.5f,-1);
        }catch (Exception e){
            System.out.println("Son incompatible");
        }

    }

    @FXML
    private Button boutonRejouerV;
    @FXML
    private Button boutonRetourV;
    @FXML
    private Button boutonQuitterV;

    private static final Son musiqueVictoire = new Son("/universite_paris8/iut/yponnou/zelda/Sons/musique/Win.wav");


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
        musiqueVictoire.stop();
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
        musiqueVictoire.stop();
    }

    @FXML
    private void quitterLeJeu() {
        Stage stage = (Stage) boutonQuitterV.getScene().getWindow();
        stage.close();
    }
}