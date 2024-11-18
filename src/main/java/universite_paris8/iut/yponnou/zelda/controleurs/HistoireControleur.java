package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.Lanceur;

import java.io.IOException;

public class HistoireControleur {

    @FXML
    private Text texteHistoire;
    @FXML
    private Button boutonRetour;

    @FXML
    public void initialize() {
        String story = """
                \tVous allez suivre l'histoire de deux frères, JOSEPH et CESAR, deux villageois unis malgré eux contre les difficultés de la vie, vivant pésiblement dans le village MORIOH au bord d'un fleuve.\


                \tTandis que Joseph était parti au travail, César s'est FAIT ARRÊTER par les gardes du Royaume de Montreuil \
                car lui et Joseph n'avait payé à temps leur impôts mensuel.\


                \tEn rentrant, Joseph apprit la nouvelle par les villageois. Fou de rage, il prit sa fourche\
                 et partit en quête de récupérer son grand frère par la force de sa FOURCHE !!!\n""";

        texteHistoire.setText(story);
        texteHistoire.setOpacity(0);

        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), texteHistoire);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.3), texteHistoire);
        translate.setFromY(7);
        translate.setToY(5);
        SequentialTransition sequence = new SequentialTransition(fade, translate);
        sequence.play();
    }

    @FXML
    private void lancementRetourMenu() throws IOException {
        // Code pour retourner au menu principal
        Stage stage;

        stage = (Stage) boutonRetour.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("menu.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.requestFocus();
        stage.show();
    }
}

