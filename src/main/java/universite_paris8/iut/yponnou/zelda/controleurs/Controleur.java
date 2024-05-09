package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Heros;
import universite_paris8.iut.yponnou.zelda.modele.Objet;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;
import universite_paris8.iut.yponnou.zelda.vue.TileMap;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Map map;
    private Heros perso;
    private Objet objet1;
    private Objet objet2;

    private Timeline gameLoop;
    private int temps;

    @FXML
    private Pane paneMap;
    @FXML
    private TilePane tilePaneDecors;
    @FXML
    private TilePane tilePaneObjets;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        map = new Map(30, 30);
        map.initialisationMap();
        TileMap tileMap = new TileMap(map.getTabNum(), tilePaneDecors);
        perso = new Heros("Joseph", 40, 0, 0, map);
        objet1 = new Objet(6,9,map);
        objet2 = new Objet(15,9,map);
        ActeurVue aV = new ActeurVue(perso, paneMap);
        ObjetVue oV = new ObjetVue(objet1, tilePaneObjets);
        ObjetVue oV2 = new ObjetVue(objet2, tilePaneObjets);

        tileMap.afficher();
        oV.afficher();
        oV2.afficher();
        aV.afficher();
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Heros p = perso;
        switch (key) {
            case Z:
            case UP:
                p.deplacement(0, -1);
                System.out.println("HAUT - x:"+p.getX()+" y:"+p.getY());
                break;
            case S:
            case DOWN:
                p.deplacement(0, 1);
                System.out.println("BAS - x:"+p.getX()+" y:"+p.getY());
                break;
            case D:
            case RIGHT:
                p.deplacement(1, 0);
                System.out.println("DROITE - x:"+p.getX()+" y:"+p.getY());
                break;
            case Q:
            case LEFT:
                p.deplacement(-1, 0);
                System.out.println("GAUGHE - x:"+p.getX()+" y:"+p.getY());
                break;
            case J:
                if (p.objetsProches() && p.getInventaire().size() != 5) {
                    p.recuperer(objet1);
                    tilePaneObjets.getChildren().clear();
                    System.out.println("Objets récupéré !");
                }
                else {
                    System.out.println("Aucun objets trouvés !");
                }
                break;
        }
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame (
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
//                    if(temps==100){
//                        System.out.println("fini");
//                        gameLoop.stop();
//                    }
//                    else if (temps%5==0){
//                        System.out.println("un tour");
//                        leCercle.setLayoutX(leCercle.getLayoutX()+5);
//                        leCercle.setLayoutY(leCercle.getLayoutY()+5);
//
//                    }
                    temps++;
                }
                )
        );
        gameLoop.getKeyFrames().add(kf);
    }
}
