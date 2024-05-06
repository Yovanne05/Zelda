package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.PersoPrincipale;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;

import java.net.URL;
import java.util.EventListener;
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
        map=new Map(30,30);
        map.initialisationMap();
        MapVue mVue= new MapVue(map.getTab(),tilepane);
        perso= new PersoPrincipale("Joseph",40,50,50);
        ActeurVue av=new ActeurVue(perso, paneid);
        mVue.creationMap();
    }

    @FXML
    public void interactionDeplacement(KeyEvent event){
        KeyCode key = event.getCode();
        Acteur p = perso;
        System.out.println("zieofoizjefji");
        switch (key) {
            case Z -> p.deplacement(50, 0);
            case S -> p.deplacement(-50, 0);
            case D -> p.deplacement(0, 50);
            case Q -> p.deplacement(0, -50);
        }
    }
}
