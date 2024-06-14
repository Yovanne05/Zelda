package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.ObservateurInventaire;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.ObservateurObjets;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs.ObservateurActeurs;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie.ObservateurCoeurs;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.*;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;
import universite_paris8.iut.yponnou.zelda.vue.Pv.CoeursVue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    private Timeline gameLoop;
    private int temps;

    private boolean touche;

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
    @FXML
    private HBox hboxVueInventaire;

    private Environnement environnement;
    private Hero hero;
    private HeroVue heroVue;
    private Map mapActuelle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        mapActuelle = new Map(30, 30);

        hero = new Hero(0, 0, null, 0, 0, new Epee(0, 0, null));
        hero.pvProperty().addListener(new ObservateurCoeurs(paneCoeurs, new CoeursVue(paneCoeurs)));
        hero.inventaireProperty().addListener(new ObservateurInventaire(hboxInventaire));
        heroVue = new HeroVue(hero, paneMap);

        switchToEnvironment(new Village(hero));
    }

    private void switchToEnvironment(Environnement newEnvironnement) {
        this.environnement = newEnvironnement;
        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
        environnement.creationEnvironnement();
        MapVue mapVue = new MapVue(environnement.getMap().getTabNum(), tilePaneDecors);
        mapVue.creerSprite();
    }

    @FXML
    public void interaction(KeyEvent event) throws IOException {
        KeyCode key = event.getCode();
        Hero p = environnement.heroEnv();
        Objet ob;
        if (p != null) {
            switch (key) {
                case Z:
                case UP:
                    p.setDirection("up");
                    p.setDx(0);
                    p.setDy(-1);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case S:
                case DOWN:
                    p.setDirection("down");
                    p.setDx(0);
                    p.setDy(1);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case D:
                case RIGHT:
                    p.setDirection("right");
                    p.setDx(1);
                    p.setDy(0);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case Q:
                case LEFT:
                    p.setDirection("left");
                    p.setDx(-1);
                    p.setDy(0);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case E:
                    p.recuperer();
                    break;
                case K:
                    if (!p.inventaireProperty().isEmpty()) {
                        ob = p.inventaireProperty().get(0);
                        p.deposer(ob);
                    } else {
                        System.out.println("Inventaire vide");
                    }
                    break;
                case M:
                    p.guerison();
                    break;
                case J:
                    p.attaquer();
                    break;
                case AMPERSAND:
                    p.selectionObjet(0);
                    break;
                case UNDEFINED:
                    p.selectionObjet(1);
                    break;
                case QUOTEDBL:
                    p.selectionObjet(2);
                    break;
                case QUOTE:
                    p.selectionObjet(3);
                    break;
                case LEFT_PARENTHESIS:
                    p.selectionObjet(4);
                    break;
                case A:
                    if (p.estProcheDePaysan(environnement.paysansQuiParle(), 80)) {
                        environnement.paysansQuiParle().parler();
                    }
                    if (p.estProcheDeVendeur(environnement.obtenirVendeur(), 80)) {
                        environnement.obtenirVendeur().proposerObjet(p);
                    }
                    break;
                case I:
                    if (hboxInventaire.isVisible() && hboxVueInventaire.isVisible()) {
                        hboxInventaire.setVisible(false);
                        hboxVueInventaire.setVisible(false);
                    } else {
                        hboxInventaire.setVisible(true);
                        hboxVueInventaire.setVisible(true);
                    }
                    break;
                case T:
                    changeMap();
                    break;
            }
            System.out.println(p.getPosition().getX() + " " + p.getPosition().getY());
        }
    }

    private void changeMap() {
        tilePaneDecors.getChildren().clear();
        Environnement newEnvironnement;
        for(Acteur a : environnement.acteursProperty()){
            paneMap.getChildren().remove(paneMap.lookup("#"+a.getId()));
        }
        for(Objet o : environnement.objetsProperty()){
            paneObjets.getChildren().remove(paneObjets.lookup("#"+o.getId()));
        }

        if (environnement instanceof Village) {
            newEnvironnement = new Labyrinthe(hero);
        } else if (environnement instanceof Labyrinthe) {
            newEnvironnement = new EntreeDonjon(hero);
        } else if(environnement instanceof EntreeDonjon){
            newEnvironnement = new Donjon(hero);
        }else {
            newEnvironnement = new Village(hero);
        }
        switchToEnvironment(newEnvironnement);
    }

    @FXML
    private void toucheLacher() {
        boolean touche = false;
        heroVue.upgradeSprite();
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ev -> {
                    environnement.toutLeMondeBouge();
                    temps++;
                }
        );
        gameLoop.getKeyFrames().add(kf);
    }

    private void adjustCamera() {
        double targetScale = 1.0;
        double mapWidth = mapActuelle.getLargeur() * tilePaneDecors.getTileWidth();
        double mapHeight = mapActuelle.getHauteur() * tilePaneDecors.getTileHeight();
        double paneWidth = paneMap.getWidth();
        double paneHeight = paneMap.getHeight();

        paneMap.translateXProperty().bind(
                Bindings.createDoubleBinding(() -> {
                    double playerX = environnement.heroEnv().getPosition().getX();
                    return Math.max(Math.min(-playerX + paneWidth / 2, 0), -mapWidth + paneWidth);
                }, environnement.heroEnv().getPosition().xProperty(), paneMap.widthProperty())
        );

        paneMap.translateYProperty().bind(
                Bindings.createDoubleBinding(() -> {
                    double playerY = environnement.heroEnv().getPosition().getY();
                    return Math.max(Math.min(-playerY + paneHeight / 2, 0), -mapHeight + paneHeight);
                }, environnement.heroEnv().getPosition().yProperty(), paneMap.heightProperty())
        );

        paneMap.setScaleX(targetScale);
        paneMap.setScaleY(targetScale);

        hboxVueInventaire.translateXProperty().bind(
                paneMap.translateXProperty().multiply(-1)
        );
        hboxVueInventaire.translateYProperty().bind(
                paneMap.translateYProperty().multiply(-1)
        );
        hboxInventaire.translateXProperty().bind(
                paneMap.translateXProperty().multiply(-1)
        );
        hboxInventaire.translateYProperty().bind(
                paneMap.translateYProperty().multiply(-1)
        );
        paneCoeurs.translateXProperty().bind(
                paneMap.translateXProperty().multiply(-1)
        );
        paneCoeurs.translateYProperty().bind(
                paneMap.translateYProperty().multiply(-1)
        );
    }
}
