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
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import javafx.beans.binding.Bindings;


public class Controleur implements Initializable {

    private Hero perso;
    private Garde g;

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

    private ObservateurActeurs obsActeurs;
    private HeroVue vueHero;
    private ScaleTransition cameraTransition;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();

        Map map = new Map(30, 30);
        map.initialisationMap();
        Environnement environnement = new Environnement(map);
        MapVue tileMap = new MapVue(map.getTabNum(), tilePaneDecors);
        Epee e = new Epee("Excalibur",15,5);
        perso = new Hero("Joseph", 400, 400, environnement,e);
        g = new Garde("G", 400,500,100,0.03,environnement,e);
        Pomme objet1 = new Pomme(605, 500, environnement);
        Pomme objet2 = new Pomme(700, 500, environnement);
//        Pomme objet3 = new Pomme(100, 100, environnement);
//        Pomme objet4 = new Pomme(60, 140, environnement);
//        Pomme objet5 = new Pomme(165, 90, environnement);

        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
        perso.initialisationHero(paneCoeurs,hboxInventaire);
        g.initialisationEnnemi(paneMap);
        this.vueHero = new HeroVue(perso,paneMap);

        environnement.ajouterActeur(g);
        environnement.ajouterObjet(objet1);
        environnement.ajouterObjet(objet2);
//        environnement.ajouterObjet(objet3);
//        environnement.ajouterObjet(objet4);
//        environnement.ajouterObjet(objet5);
        environnement.ajouterActeur(perso);
        tileMap.creerSprite();

        cameraTransition = new ScaleTransition(Duration.millis(500), paneMap);
        cameraTransition.setToX(1); // Set X scale to 1
        cameraTransition.setToY(1); // Set Y scale to 1
        cameraTransition.setCycleCount(1); // Run once
        cameraTransition.setAutoReverse(false); // Do not reverse

        // Start camera transition
        cameraTransition.play();
    }

    @FXML
    public void interaction(KeyEvent event) {
        this.touche = true;
        KeyCode key = event.getCode();
        Hero p = perso;
        Objet ob;
        Nourriture aliment;
        switch (key) {
            case Z:
            case UP:
                p.setDirection("up");
                p.deplacement(0, -1);
                System.out.println("HAUT - x:" + p.getPosition().getX() + " y:" + p.getPosition().getY());
                vueHero.upgradeSprite(perso, touche);
                adjustCamera();
                break;
            case S:
            case DOWN:
                p.setDirection("down");
                p.deplacement(0, 1);
                System.out.println("BAS - x:" + p.getPosition().getX() + " y:" + p.getPosition().getY());
                vueHero.upgradeSprite(perso, touche);
                adjustCamera();
                break;
            case D:
            case RIGHT:
                p.setDirection("right");
                p.deplacement(1, 0);
                System.out.println("DROITE - x:" + p.getPosition().getX() + " y:" + p.getPosition().getY());
                vueHero.upgradeSprite(perso, touche);
                adjustCamera();
                break;
            case Q:
            case LEFT:
                p.setDirection("left");
                p.deplacement(-1, 0);
                System.out.println("GAUCHE - x:" + p.getPosition().getX() + " y:" + p.getPosition().getY());
                vueHero.upgradeSprite(perso, touche);
                adjustCamera();
                break;
            case E:
                ob = p.objetsProches();
                if (ob != null && p.getInventaire().size() != p.getCapaciteMax()) {
                    p.recuperer(ob);
                    System.out.println("Objet récupéré !");
                } else if (ob != null && p.getInventaire().size() == p.getCapaciteMax()) {
                    System.out.println("Inventaire complet !");
                } else {
                    System.out.println("Aucun objets trouvés !");
                }
                break;
            case K:
                if (!p.getInventaire().isEmpty()) {
                    ob = p.getInventaire().get(0);
                    p.deposer(ob);
                    System.out.println("Objet déposé !");
                } else {
                    System.out.println("Inventaire vide");
                }
                break;
            case M:
                aliment = perso.possedeNourritures();
                if (aliment != null) {
                    if (!perso.pleineSante()) {
                        perso.guerison(aliment.getPv());
                        System.out.println(perso.getNom() + " a mangé " + aliment.getNom());
                        perso.getInventaire().remove(aliment);
                    } else
                        System.out.println("Votre santé est déjà complète !");
                } else
                    System.out.println("Aucun aliment trouvé");
                break;
            case J:
                perso.attaquer();
                break;
        }
    }

    @FXML
    private void toucheLacher(){
        System.out.println("La touche est lachée");
        this.touche=false;
        vueHero.upgradeSprite(perso,touche);
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
                    g.deplacementEnRonde();
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



    private void adjustCamera() {
        double targetScale = 2.0; // Adjust as needed

        // Calculate target position based on player's position and scale
        double targetX = (paneMap.getWidth() / 2) - (perso.getPosition().getX() * targetScale);
        double targetY = (paneMap.getHeight() / 2) - (perso.getPosition().getY() * targetScale);

        // Bind translation of the map pane to the target position
        paneMap.translateXProperty().bind(Bindings.subtract(paneMap.getWidth() / 2, perso.getPosition().xProperty()).multiply(targetScale));
        paneMap.translateYProperty().bind(Bindings.subtract(paneMap.getHeight() / 2, perso.getPosition().yProperty()).multiply(targetScale));

        // Set scale of the map pane
        paneMap.setScaleX(targetScale);
        paneMap.setScaleY(targetScale);
    }



}
