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
import universite_paris8.iut.yponnou.zelda.modele.*;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Armes.*;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;
import universite_paris8.iut.yponnou.zelda.vue.TileMap;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Environnement environnement;
    private Map map;
    private Hero perso;
    private Objet objet1;
    private Objet objet2;
    private Arme arme;

    private Timeline gameLoop;
    private int temps;
    @FXML
    private Pane paneMap;
    @FXML
    private TilePane tilePaneDecors;
    @FXML
    private TilePane tilePaneObjets;
    private Garde garde;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        map = new Map(30, 30);
        environnement = new Environnement((int)paneMap.getPrefWidth(),(int)paneMap.getPrefHeight(),map);
        arme = new ArmeMelee("Fourche",2);
        perso = new Hero("Joseph", 40, 0, 0,0.2,environnement,arme);
        Epee e= new Epee("Epee",2);
        garde=new Garde("Garde",2,800,800,0.03,environnement,e);
        objet1 = new Objet(environnement,2,0);
//        objet2 = new Objet(0,2,map,environnement);
//        ActeurVue aV = new ActeurVue(perso.getMap().getTabNum(), paneMap);
//        ObjetVue oV = new ObjetVue(map.getTabNum(), tilePaneObjets);
//        ObjetVue oV2 = new ObjetVue(map.getTabNum(), tilePaneObjets);
        environnement.getActeurs().addListener(new ActeurVue(environnement.getMap().getTabNum(), paneMap));
        environnement.getObjets().addListener(new ObjetVue(environnement.getMap().getTabNum(), paneMap));
        environnement.ajouterActeur(perso);
//        environnement.ajouterObjet(objet1);
//        environnement.ajouterObjet(objet2);
        environnement.ajouterActeur(garde);
        map.initialisationMap();
        TileMap tileMap = new TileMap(map.getTabNum(), tilePaneDecors);
        tileMap.creerSprite();
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
                if (ob != null && p.getInventaire().size() != 5) {
                    p.recuperer(ob);
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
                    garde.deplacementEnRonde();
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
