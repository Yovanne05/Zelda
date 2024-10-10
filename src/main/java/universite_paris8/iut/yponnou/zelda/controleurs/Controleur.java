
package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.Lanceur;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets.*;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs.ObservateurActeurs;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie.ObservateurCoeurs;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.*;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Son;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.PaysanVue;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.VendeurVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;
import universite_paris8.iut.yponnou.zelda.vue.Pv.CoeursVue;

import java.io.IOException;
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
    @FXML
    private HBox hboxVueInventaire;

    private Environnement environnement;
    private Hero hero;
    private HeroVue heroVue;
    private Map mapActuelle;

    private static final Son musiqueJeu = new Son("/universite_paris8/iut/yponnou/zelda/Sons/musique/Fishing_village.wav");
    private static final Son bruitPas = new Son("/universite_paris8/iut/yponnou/zelda/Sons/bruits/bruitsPas/stepdirt_1.wav");
    private final Son sonEpee = new Son("/universite_paris8/iut/yponnou/zelda/Sons/bruits/sword.wav");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        mapActuelle = new Map(30, 30);


        hero = new Hero(0, 0, null, new Direction(0,0), null);
        hero.pvProperty().addListener(new ObservateurCoeurs(paneCoeurs, new CoeursVue(paneCoeurs)));
        hero.inventaireProperty().addListener(new ObservateurInventaire(hboxInventaire));
        heroVue = new HeroVue(hero, paneMap);

        switchToEnvironment(new Village(hero));
        try {
            musiqueJeu.jouer(1,-1);
            bruitPas.jouer(0.05f,0);
            sonEpee.jouer(0.1f,0);
        }catch (Exception e){
            System.out.println("Son incompatible");
        }

    }

    private void switchToEnvironment(Environnement newEnvironnement) {
        this.environnement = newEnvironnement;
        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
        environnement.creationEnvironnement();
        hero.changeEnvObjets(environnement);
        hero.getPosition().setEnv(environnement);
        MapVue mapVue = new MapVue(environnement.getMap().getTabNum(), tilePaneDecors);
        mapVue.creerSprite();
        System.out.println(environnement);
    }
    //test
    @FXML
    public void interaction(KeyEvent event) throws InterruptedException {
        KeyCode key = event.getCode();
        Hero p = environnement.heroEnv();
        Objet ob;
        if (p != null) {
            switch (key) {
                case Z:
                case UP:
                    p.getDirection().setDx(0);
                    p.getDirection().setDy(-1);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int)(hero.getPosition().getY()/50)][(int)hero.getPosition().getX()/50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case S:
                case DOWN:
                    p.getDirection().setDx(0);
                    p.getDirection().setDy(1);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int)(hero.getPosition().getY()/50)][(int)hero.getPosition().getX()/50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case D:
                case RIGHT:
                    p.getDirection().setDx(1);
                    p.getDirection().setDy(0);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int)(hero.getPosition().getY()/50)][(int)hero.getPosition().getX()/50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case Q:
                case LEFT:
                    p.getDirection().setDx(-1);
                    p.getDirection().setDy(0);
                    p.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int)(hero.getPosition().getY()/50)][(int)hero.getPosition().getX()/50]);
                    adjustCamera();
                    bruitPas.run();
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
                    if (p.getArme() instanceof Epee)
                        sonEpee.run();
                    break;
                case AMPERSAND:
                case DIGIT1:
                    p.selectionObjet(0);
                    break;
                case UNDEFINED:
                case DIGIT2:
                    p.selectionObjet(1);
                    break;
                case QUOTEDBL:
                case DIGIT3:
                    p.selectionObjet(2);
                    break;
                case QUOTE:
                case DIGIT4:
                    p.selectionObjet(3);
                    break;
                case LEFT_PARENTHESIS:
                case DIGIT5:
                    p.selectionObjet(4);
                    break;
                case A:
                    if(environnement.paysansQuiParle()!=null){
                        if (p.estProcheDePaysan(environnement.paysansQuiParle(), 80)) {
                            PaysanVue paysanVue = new PaysanVue(p,paneMap);
                            paysanVue.parler();
                        }
                        if (p.estProcheDeVendeur(environnement.obtenirVendeur(), 80)) {
                            VendeurVue vendeurVue = new VendeurVue(p,paneMap);
                            vendeurVue.proposerObjet(hero);
                        }
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
                    System.out.println("888");
                    changeMap(environnement.getMap().getTabNum()[(int)(hero.getPosition().getY()/50)][(int)hero.getPosition().getX()/50]);
                    System.out.println("999");
                    break;
            }
            System.out.println(key);
        }
    }

    public boolean changementPossible(int caseHero){
        return caseHero<0;
    }

    public void changementMapPossible(int caseHero){
        if(changementPossible(caseHero)){
            changeMap(caseHero);
        }
    }

    private void changeMap(int mapID) {
        System.out.println("eeeee");
        Environnement newEnvironnement;
        switch (mapID){
            case -1:
                System.out.println("111");
                tilePaneDecors.getChildren().clear();
                for (Acteur a : environnement.acteursProperty()) {
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
                }
                for (Objet o : environnement.objetsProperty()) {
                    paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
                }
                newEnvironnement = new Labyrinthe(hero);
                switchToEnvironment(newEnvironnement);
                hero.getPosition().setX(50);
                hero.getPosition().setY(800);
                break;
            case -2:
                tilePaneDecors.getChildren().clear();
                for (Acteur a : environnement.acteursProperty()) {
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
                }
                for (Objet o : environnement.objetsProperty()) {
                    paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
                }

                newEnvironnement = new Village(hero);
                switchToEnvironment(newEnvironnement);
                hero.getPosition().setX(1400);
                hero.getPosition().setY(500);
                break;
            case -3:
                tilePaneDecors.getChildren().clear();
                for (Acteur a : environnement.acteursProperty()) {
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
                }
                for (Objet o : environnement.objetsProperty()) {
                    paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
                }

                newEnvironnement = new EntreeDonjon(hero);
                switchToEnvironment(newEnvironnement);
                hero.getPosition().setX(50);
                hero.getPosition().setY(1225);
                break;
            case -4:
                tilePaneDecors.getChildren().clear();
                for (Acteur a : environnement.acteursProperty()) {
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
                }
                for (Objet o : environnement.objetsProperty()) {
                    paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
                }

                newEnvironnement = new Labyrinthe(hero);
                switchToEnvironment(newEnvironnement);
                hero.getPosition().setX(1400);
                hero.getPosition().setY(850);
                break;
            case -5:
                if (hero.possedeClef()){
                    tilePaneDecors.getChildren().clear();
                    for (Acteur a : environnement.acteursProperty()) {
                        paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
                        paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
                    }
                    for (Objet o : environnement.objetsProperty()) {
                        paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
                    }

                    newEnvironnement = new Donjon(hero);
                    switchToEnvironment(newEnvironnement);
                    hero.getPosition().setX(725);
                    hero.getPosition().setY(550);}
                else{
                    ((EntreeDonjon)environnement).entree();
                }
                break;
            case -6:
                tilePaneDecors.getChildren().clear();
                for (Acteur a : environnement.acteursProperty()) {
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
                    paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
                }
                for (Objet o : environnement.objetsProperty()) {
                    paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
                }

                newEnvironnement = new EntreeDonjon(hero);
                switchToEnvironment(newEnvironnement);
                hero.getPosition().setX(725);
                hero.getPosition().setY(700);
                break;
        }
    }
    @FXML
    private void toucheLacher() {
        heroVue.upgradeSpriteStatic();
        System.out.println(environnement.getMap().getTabNum()[(int) (hero.getPosition().getY()/50)][(int) hero.getPosition().getX()/50]);
        System.out.println(hero.getPosition().getY());
        System.out.println(hero.getPosition().getX());
        bruitPas.stop();
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

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ev -> {
                    environnement.toutLeMondeBouge();
                    if (hero.estMort()) {
                        try {
                            this.gameOver();
                            gameLoop.stop();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if(environnement instanceof Donjon){
                        if (((Donjon)environnement).verifEnnemiMort()){
                            try {
                                this.victoire();
                                gameLoop.stop();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }
                    temps++;
                }
        );
        gameLoop.getKeyFrames().add(kf);
    }



    public void gameOver() throws IOException {
        Stage oldStage, newStage;

        oldStage = (Stage) paneMap.getScene().getWindow();
        oldStage.close();
        newStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("gameOver.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StackPane root = (StackPane) scene.getRoot();
        root.requestFocus();
        newStage.setScene(scene);
        newStage.show();
        musiqueJeu.stop();
    }

    public void victoire() throws IOException {
        Stage oldStage, newStage;

        oldStage = (Stage) paneMap.getScene().getWindow();
        oldStage.close();
        newStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("victoire.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StackPane root = (StackPane) scene.getRoot();
        root.requestFocus();
        newStage.setScene(scene);
        newStage.show();
        musiqueJeu.stop();
    }
}
