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

public class CommandesControleur {

    @FXML
    private Text texteCommandes;
    @FXML
    private Button boutonRetour;

    @FXML
    public void initialize() {
        String story = "- Z / ↑ : Haut\t\t\t\t\t\t\t\t- & : selection Objet n°1\n\n- S / ↓ : Bas\t\t\t\t\t\t\t\t- é : selection Objet n°2\n\n- Q / ← : Gauche\t\t\t\t\t\t\t- \" : selection Objet n°3\n\n- D / → : Droite\t\t\t\t\t\t\t- ' : selection Objet n°4\n\n- E : Prendre\t\t\t\t\t\t\t\t- ( : selection Objet n°5\n\n- K : Déposer\n\n- A : Interagir (PNJ)\n\n- J : Attaquer\n\n- M : Manger\n\n- I : Montrer/Cacher l'inventaire";
        texteCommandes.setText(story);
        texteCommandes.setOpacity(0);

        FadeTransition fade = new FadeTransition(Duration.seconds(0.7), texteCommandes);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), texteCommandes);

        SequentialTransition sequence = new SequentialTransition(fade, translate);
        sequence.play();
    }

    @FXML
    private void lancementRetourJeu() throws IOException {
        Stage stage;

        stage = (Stage) boutonRetour.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("menu.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.requestFocus();
        stage.show();
    }
}
