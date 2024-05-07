package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.PersoPrincipale;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Map map;
    @FXML
    private Pane paneid;
    @FXML
    private TilePane tilepane;
    private PersoPrincipale perso;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        map = new Map(30, 30);
        map.initialisationMap();
        MapVue mVue = new MapVue(map.getTab(), tilepane);
        perso = new PersoPrincipale("Joseph", 40, 1, 1, map);
        ActeurVue av = new ActeurVue(perso, paneid);
        mVue.creationMap();
    }

    @FXML
    public void interactionDeplacement(KeyEvent event) {
        KeyCode key = event.getCode();
        Acteur p = perso;
        switch (key) {
            case Z:
                p.deplacement(0, -1);
                System.out.println("Z");
                break;
            case S:
                p.deplacement(0, 1);
                System.out.println("S");
                break;
            case D:
                p.deplacement(1, 0);
                System.out.println("D");
                break;
            case Q:
                p.deplacement(-1, 0);
                System.out.println("Q");
                break;
        }
    }
}
