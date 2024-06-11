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
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Village;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.HeroVue;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    private Timeline gameLoop;
    private int temps;

    @FXML
    private Pane paneMap;
    @FXML
    private Pane paneObjets;
    @FXML
    private TilePane tilePaneDecors;
    @FXML
    private HBox paneCoeurs;
    @FXML
    private HBox hboxInventaire;

    private Village v;

    private HeroVue heroVue;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        Map map = new Map(30, 30);
        v = new Village(map,tilePaneDecors, paneObjets, paneMap, paneCoeurs, hboxInventaire,heroVue);
//        map.initialisationMap();
//        Environnement environnement = new Environnement(map);
//        MapVue tileMap = new MapVue(map.getTabNum(), tilePaneDecors);
//        perso = new Hero("Joseph", 400, 400, environnement,new Epee(400,400,environnement));
//        g = new Garde("G", 400,500,120,0.03,environnement,new Epee(400,500,environnement));
//        Pomme objet1 = new Pomme(605, 500, environnement);
//        Pomme objet2 = new Pomme(700, 500, environnement);
//        Pomme objet3 = new Pomme(700, 400, environnement);
//        Pomme objet4 = new Pomme(750, 400, environnement);
//        Pomme objet5 = new Pomme(820, 400, environnement);
//        Pomme objet6 = new Pomme(820, 400, environnement);
//
//        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
//        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
//
//        perso.pvProperty().addListener(new ObservateurCoeurs(paneCoeurs,new CoeursVue(paneCoeurs)));
//        perso.getInventaire().addListener(new ObservateurObjets(hboxInventaire));
//
//        heroVue = new HeroVue(perso,paneMap);
//
//        g.pvProperty().addListener(new ObservateurBarreDeVie(g,paneMap, new BarreDeVieVue(g,paneMap)));
//
//        environnement.ajouterActeur(g);
//        environnement.ajouterObjet(objet1);
//        environnement.ajouterObjet(objet2);
//        environnement.ajouterObjet(objet3);
//        environnement.ajouterObjet(objet4);
//        environnement.ajouterObjet(objet5);
//        environnement.ajouterObjet(objet6);
//        environnement.ajouterActeur(perso);
////        perso.subitDegats(40);
//        tileMap.creerSprite();
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Hero p = v.heroEnv();
        Objet ob;
        switch (key) {
            case Z:
            case UP:
                p.setDirection("up");
                p.setDx(0);
                p.setDy(-1);
                p.deplacement();
                System.out.println("HAUT - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                v.getHeroVue().upgradeSprite();
                break;
            case S:
            case DOWN:
                p.setDirection("down");
                p.setDx(0);
                p.setDy(1);
                p.deplacement();
                System.out.println("BAS - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                v.getHeroVue().upgradeSprite();
                break;
            case D:
            case RIGHT:
                p.setDirection("right");
                p.setDx(1);
                p.setDy(0);
                p.deplacement();
                System.out.println("DROITE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                v.getHeroVue().upgradeSprite();
                break;
            case Q:
            case LEFT:
                p.setDirection("left");
                p.setDx(-1);
                p.setDy(0);
                p.deplacement();
                System.out.println("GAUGHE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                v.getHeroVue().upgradeSprite();
                break;
            case E:
                p.recuperer();
                break;
            case K:
                if (!p.getInventaire().isEmpty()) {
                    ob = p.getInventaire().get(0);
                    p.deposer(ob);
                    System.out.println("Objet déposé !");
                }
                else
                    System.out.println("Inventaire vide");
                break;
            case M:
                p.guerison();
                break;
            case J:
                p.attaquer();
                break;
            case DIGIT1:
                p.selectionObjet(0);
                break;
            case DIGIT2:
                p.selectionObjet(1);
                break;
            case DIGIT3:
                p.selectionObjet(2);
                break;
            case DIGIT4:
                p.selectionObjet(3);
                break;
            case DIGIT5:
                p.selectionObjet(4);
                break;
            case A:
                v.paysansQuiParle().parler();
                break;
        }
    }
    @FXML
    private void toucheLacher(){
        System.out.println("La touche est lachée");
        boolean touche = false;
        v.getHeroVue().upgradeSprite();
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
                    v.toutLeMondeBouge();
//                    g.deplacementEnRonde();
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
