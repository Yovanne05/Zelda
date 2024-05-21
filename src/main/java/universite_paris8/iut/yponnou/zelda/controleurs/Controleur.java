package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objet;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Hero perso;

    private Timeline gameLoop;
    private int temps;

    @FXML
    private Pane paneMap;
    @FXML
    private TilePane tilePaneDecors;
    @FXML
    private HBox hboxInventaire;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();

        Map map = new Map(30, 30);
        map.initialisationMap();
        Environnement environnement = new Environnement(map);
        MapVue tileMap = new MapVue(map.getTabNum(), tilePaneDecors);
        perso = new Hero("Joseph", 40, 0, 0, map, environnement);
        Objet objet1 = new Objet(80, 650, map, environnement);
        Objet objet2 = new Objet(65, 500, map, environnement);
        Objet objet3 = new Objet(165, 800, map, environnement);
        Objet objet4 = new Objet(65, 400, map, environnement);
        Objet objet5 = new Objet(250, 500, map, environnement);

        environnement.getObjets().addListener(new ObservateurObjets(paneMap));
        environnement.getActeurs().addListener(new ObservateurActeurs(paneMap));
        perso.getInventaire().getObjets().addListener(new ObservateurInventaire(hboxInventaire));

        environnement.ajouterObjet(objet1);
        environnement.ajouterObjet(objet2);
        environnement.ajouterObjet(objet3);
        environnement.ajouterObjet(objet4);
        environnement.ajouterObjet(objet5);
        environnement.ajouterActeur(perso);
        tileMap.affichageMap();
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Hero p = perso;
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
                 Objet ob = p.objetsProches();
                if (ob != null && p.getInventaire().getObjets().size() != p.getInventaire().getTaille()) {
                    p.recuperer(ob);
                    System.out.println("Objet récupéré !");
                } else if (ob != null && p.getInventaire().getObjets().size() == p.getInventaire().getTaille()) {
                    System.out.println("Inventaire complet !");
                } else {
                    System.out.println("Aucun objets trouvés !");
                }
                break;
            case K:
                Objet ob2;
                if (!p.getInventaire().getObjets().isEmpty()) {
                    ob2 = p.getInventaire().getObjets().get(0);
                    p.deposer(ob2);
                    System.out.println("Objet déposé !");
                }
                else {
                    System.out.println("Inventaire vide");
                }
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
