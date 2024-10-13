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

public class MenuControleur implements Initializable {

    @FXML
    public Button boutonLancer;
    @FXML
    public Button boutonHistoire;
    @FXML
    public Button boutonCommandes;

    private static final Son musiqueMenu  = new Son("/universite_paris8/iut/yponnou/zelda/Sons/musique/Loop_Minstrel_Dance.wav");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            musiqueMenu.jouer(0.05f,-1);
        }catch (Exception e){
            System.out.println("Son incompatible");
        }
    }

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
        musiqueMenu.stop();
    }

    @FXML
    private void lancementHistoire() throws IOException {
        Stage stage = (Stage) boutonHistoire.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("histoire.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.requestFocus();
        stage.show();
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
    }
}
