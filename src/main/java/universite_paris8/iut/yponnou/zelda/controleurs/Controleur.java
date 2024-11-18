
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
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.environnements.*;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Map;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.information.StaminaBar;
import universite_paris8.iut.yponnou.zelda.vue.son.Son;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.PaysanVue;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.VendeurVue;
import universite_paris8.iut.yponnou.zelda.vue.maps.MapVue;
import universite_paris8.iut.yponnou.zelda.vue.pv.CoeursVue;
import universite_paris8.iut.yponnou.zelda.vue.environnement.EntreeDonjonVue;

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
    // Déclaration de containerStaminaBar
    private StackPane BarStamina;


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

        hero = new Hero(650, 360, null, new Direction(0, 0), null);
        hero.pvProperty().addListener(new ObservateurCoeurs(paneCoeurs, new CoeursVue(paneCoeurs)));
        hero.getInventaire().inventaireProperty().addListener(new ObservateurInventaire(hboxInventaire));
        heroVue = new HeroVue(hero, paneMap);

        BarStamina = new StackPane();
        StaminaBar staminaBar = new StaminaBar(hero);
        BarStamina.getChildren().add(staminaBar.getContainer());
        paneMap.getChildren().add(BarStamina);

        environnement = Environnement.getInstance();
        environnement.miseEnPlaceEnv(mapActuelle,hero);
        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
        hero.changeEnvObjets(environnement);
        hero.setEnvironnement(environnement);


        switchToEnvironment(new CreationVillage());
        try {
            musiqueJeu.jouer(1, -1);
            bruitPas.jouer(0.05f, 0);
            sonEpee.jouer(0.1f, 0);
        } catch (Exception e) {
            System.out.println("Son incompatible");
        }
    }

    private void switchToEnvironment(CreationEnv creationEnv) {
        environnement.getActeurs().clear();
        environnement.getObjets().clear();
        tilePaneDecors.getChildren().clear();

        for (Acteur a : environnement.getActeurs()) {
            paneMap.getChildren().remove(paneMap.lookup("#" + a.getId()));
            paneMap.getChildren().remove(paneMap.lookup("#" + a.getId() + "BarreVie"));
        }
        for (Objet o : environnement.getObjets()) {
            paneObjets.getChildren().remove(paneObjets.lookup("#" + o.getId()));
        }

        environnement.setCreationEnv(creationEnv);
        environnement.creationMap();
        MapVue mapVue = new MapVue(environnement.getMap().getTabNum(), tilePaneDecors);
        mapVue.creerSprite();
    }

    @FXML
    public void interaction(KeyEvent event) throws InterruptedException {
        KeyCode key = event.getCode();
        Hero h = environnement.heroEnv();
        Objet ob;
        if (h != null) {
            switch (key) {
                case Z:
                case UP:
                    h.getDirection().changementDirection(0, -1);
                    h.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int) (hero.getPosition().getY() / 50)][(int) hero.getPosition().getX() / 50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case S:
                case DOWN:
                    h.getDirection().changementDirection(0, 1);
                    h.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int) (hero.getPosition().getY() / 50)][(int) hero.getPosition().getX() / 50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case D:
                case RIGHT:
                    h.getDirection().changementDirection(1, 0);
                    h.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int) (hero.getPosition().getY() / 50)][(int) hero.getPosition().getX() / 50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case Q:
                case LEFT:
                    h.getDirection().changementDirection(-1, 0);
                    h.deplacement();
                    heroVue.upgradeSprite();
                    changementMapPossible(environnement.getMap().getTabNum()[(int) (hero.getPosition().getY() / 50)][(int) hero.getPosition().getX() / 50]);
                    adjustCamera();
                    bruitPas.run();
                    break;
                case E:
                    h.recuperer();
                    break;
                case K:
                    if (!h.getInventaire().inventaireProperty().isEmpty()) {
                        ob = h.getInventaire().inventaireProperty().get(0);
                        h.deposer(ob);
                    }
                    break;
                case M:
                    h.guerison();
                    break;
                case B:
                    h.realiserFoncerEtAttaque();
                    break;
                case J:
                    h.attaquer();
                    if (h.getArme() instanceof Epee)
                        sonEpee.run();
                    break;
                case AMPERSAND:
                case DIGIT1:
                    h.selectionObjet(0);
                    break;
                case UNDEFINED:
                case DIGIT2:
                    h.selectionObjet(1);
                    break;
                case QUOTEDBL:
                case DIGIT3:
                    h.selectionObjet(2);
                    break;
                case QUOTE:
                case DIGIT4:
                    h.selectionObjet(3);
                    break;
                case LEFT_PARENTHESIS:
                case DIGIT5:
                    h.selectionObjet(4);
                    break;
                case A:
                    if (environnement.paysansQuiParle() != null) {
                        if (h.estProcheDeActeur(environnement.paysansQuiParle(), 80)) {
                            PaysanVue paysanVue = new PaysanVue(h, paneMap);
                            paysanVue.parler();
                        }
                        if (h.estProcheDeActeur(environnement.obtenirVendeur(), 80)) {
                            VendeurVue vendeurVue = new VendeurVue(h, paneMap);
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
                    changeMap(environnement.getMap().getTabNum()[(int) (hero.getPosition().getY() / 50)][(int) hero.getPosition().getX() / 50]);
                    break;
            }
        }
    }

    public boolean changementPossible(int caseHero) {
        return caseHero < 0;
    }

    public void changementMapPossible(int caseHero) {
        if (changementPossible(caseHero)) {
            changeMap(caseHero);
        }
    }

    private void changeMap(int mapID) {
        switch (mapID) {
            case -1:
                switchToEnvironment(new CreationLabyrinthe());
                hero.getPosition().setX(50);
                hero.getPosition().setY(800);
                break;
            case -2:
                switchToEnvironment(new CreationVillage());
                hero.getPosition().setX(1400);
                hero.getPosition().setY(500);
                break;
            case -3:
                switchToEnvironment(new CreationEntreeDonjon());
                hero.getPosition().setX(50);
                hero.getPosition().setY(1225);
                break;
            case -4:
                switchToEnvironment(new CreationLabyrinthe());
                hero.getPosition().setX(1400);
                hero.getPosition().setY(850);
                break;
            case -5:
                if (hero.possedeClef()) {
                    switchToEnvironment(new CreationDonjon());
                    hero.getPosition().setX(725);
                    hero.getPosition().setY(550);
                } else {
                    EntreeDonjonVue entreeDonjonVue = new EntreeDonjonVue();
                    entreeDonjonVue.entree();
                }
                break;
            case -6:
                switchToEnvironment(new CreationEntreeDonjon());
                hero.getPosition().setX(725);
                hero.getPosition().setY(700);
                break;
        }
    }

    @FXML
    private void toucheLacher() {
        heroVue.upgradeSpriteStatic();
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
                    return (Double) Math.max(Math.min(-playerX + paneWidth / 2, 0), -mapWidth + paneWidth);
                }, environnement.heroEnv().getPosition().xProperty(), paneMap.widthProperty())
        );

        paneMap.translateYProperty().bind(
                Bindings.createDoubleBinding(() -> {
                    double playerY = environnement.heroEnv().getPosition().getY();
                    return (Double) Math.max(Math.min(-playerY + paneHeight / 2, 0), -mapHeight + paneHeight);
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
        BarStamina.translateXProperty().bind(paneMap.translateXProperty().multiply(-1));
        BarStamina.translateYProperty().bind(paneMap.translateYProperty().multiply(-1));

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
                    if (environnement.verifEnnemiMort()) {
                        try {
                            this.victoire();
                            gameLoop.stop();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    temps++;
                    hero.augmenterStamina();
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