package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameOverControleur {

    @FXML
    private Button boutonRejouer;

    @FXML
    private Button boutonQuitter;

    @FXML
    private void lancementRejouer() {
        // Code pour relancer le jeu
        System.out.println("Rejouer le jeu");
        // Naviguer vers la scène de jeu principal
    }

    @FXML
    private void quitterLeJeu() {
        // Code pour quitter le jeu
        System.out.println("Quitter le jeu");
        System.exit(0);
    }
}
