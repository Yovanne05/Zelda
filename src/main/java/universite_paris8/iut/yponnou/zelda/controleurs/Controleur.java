package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Monde;
import universite_paris8.iut.yponnou.zelda.modele.PersoPrincipale;

import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Monde monde;
    @FXML
    private Pane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monde =new Monde(30,30,pane);
        monde.creationMap();
        monde.afficheMonde();
    }

    public void interactionDeplacement(KeyEvent event){
        KeyCode key = event.getCode();
        Acteur p = monde.persoP();
        switch (key) {
            case Z :
                p.deplacement(50, 0);
                break;
            case S :
                p.deplacement(-50, 0);
                break;
            case D :
                p.deplacement(0,50);
                break;
            case Q :
                p.deplacement(0,-50);
                break;
        }
    }

}
