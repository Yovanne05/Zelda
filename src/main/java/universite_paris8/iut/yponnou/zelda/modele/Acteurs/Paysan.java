
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Paysan extends Acteur {
    public Paysan(double x, double y, Environnement environnement, Direction direction) {
        super("Paysan", x, y, 20, 0.03, environnement, direction);
    }

    public String parler() {
        return "Bonjour, je suis un paysan de ce village. J'ai appris que votre frère a été capturé et que la clé se trouverait peut-être dans un royaume." +
                "\n La personne qui garde votre frère s'appelle M. Homps il me semble. Il aurait caché une clé dans un labyrinthe.";
    }
}
