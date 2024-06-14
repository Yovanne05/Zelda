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
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Donjon;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Village;
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

//    private Village village;
//    private Labyrinthe labyrinthe;
//    private Donjon donjon;
    private Environnement environnement;

    private Hero hero;
    private HeroVue heroVue;
    private Map mapActuelle;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        mapActuelle = new Map(30, 30);

        hero = new Hero(0,0,null,0,0,new Epee(0,0,null));
        hero.inventaireProperty().addListener(new ObservateurInventaire(hboxInventaire));
        heroVue = new HeroVue(hero,paneMap);


        //Village

        environnement = new Donjon(hero);
        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
        environnement.creationEnvironnement();
        environnement.heroEnv().pvProperty().addListener(new ObservateurCoeurs(paneCoeurs,new CoeursVue(paneCoeurs)));
//        environnement.heroEnv().inventaireProperty().addListener(new ObservateurInventaire(hboxInventaire));
        MapVue villageVue = new MapVue(environnement.getMap().getTabNum(), tilePaneDecors);
        villageVue.creerSprite();

        // Labyrinthe :
//        environnement=new Labyrinthe(hero);
//        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
//        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
//        environnement.creationEnvironnement();
//        environnement.heroEnv().pvProperty().addListener(new ObservateurCoeurs(paneCoeurs,new CoeursVue(paneCoeurs)));
////        environnement.heroEnv().getInventaire().addListener(new ObservateurObjets(hboxInventaire));
//        MapVue labyrintheVue = new MapVue(environnement.getMap().getTabNum(), tilePaneDecors);
//        labyrintheVue.creerSprite();

//        environnement=new Donjon(hero);
//        environnement.objetsProperty().addListener(new ObservateurObjets(paneObjets));
//        environnement.acteursProperty().addListener(new ObservateurActeurs(paneMap));
//        environnement.creationEnvironnement();
//        environnement.heroEnv().pvProperty().addListener(new ObservateurCoeurs(paneCoeurs,new CoeursVue(paneCoeurs)));
////        environnement.heroEnv().getInventaire().addListener(new ObservateurObjets(hboxInventaire));
//        MapVue donjonVue = new MapVue(environnement.getMap().getTabNum(), tilePaneDecors);
//        donjonVue.creerSprite();
    }

    @FXML
    public void interaction(KeyEvent event) throws IOException {
        KeyCode key = event.getCode();
        Hero p = environnement.heroEnv();
        Objet ob;
        if (p!=null){
            switch (key) {
                case Z:
                case UP:
                    p.setDirection("up");
                    p.setDx(0);
                    p.setDy(-1);
                    p.deplacement();
                    System.out.println("HAUT - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case S:
                case DOWN:
                    p.setDirection("down");
                    p.setDx(0);
                    p.setDy(1);
                    p.deplacement();
                    System.out.println("BAS - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case D:
                case RIGHT:
                    p.setDirection("right");
                    p.setDx(1);
                    p.setDy(0);
                    p.deplacement();
                    System.out.println("DROITE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                    heroVue.upgradeSprite();
                    adjustCamera();
                    break;
                case Q:
                case LEFT:
                    p.setDirection("left");
                    p.setDx(-1);
                    p.setDy(0);
                    p.deplacement();
                    System.out.println("GAUGHE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
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
                    if(p.estProcheDePaysan(environnement.paysansQuiParle(),80)){
                        environnement.paysansQuiParle().parler();
                    }
                    if(p.estProcheDeVendeur(environnement.obtenirVendeur(),80)){
                        environnement.obtenirVendeur().proposerObjet(p);
                    }
                    break;
                case I:
                    if (hboxInventaire.isVisible() && hboxVueInventaire.isVisible()) {
                        hboxInventaire.setVisible(false);
                        hboxVueInventaire.setVisible(false);
                    }
                    else {
                        hboxInventaire.setVisible(true);
                        hboxVueInventaire.setVisible(true);
                    }
//                Stage newStage;
//                InventaireControleur inventaireControleur;
//                newStage = new Stage();
//
//                FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("inventaire.fxml"));
//                Scene scene = new Scene(fxmlLoader.load());
//                inventaireControleur = fxmlLoader.getController();
//                inventaireControleur.setInventaire(p.getInventaire());
//                AnchorPane root = (AnchorPane) scene.getRoot();
//                root.requestFocus();
//                newStage.setScene(scene);
//                newStage.show();
//                break;
            }
        }
    }

    @FXML
    private void toucheLacher(){
        System.out.println("La touche est lachée");
        boolean touche = false;
        heroVue.upgradeSprite();
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
                    environnement.toutLeMondeBouge();
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

    private void adjustCamera() {
        double targetScale = 1.0; // Ajustez selon vos besoins
        double mapWidth = mapActuelle.getLargeur() * tilePaneDecors.getTileWidth();
        double mapHeight = mapActuelle.getHauteur() * tilePaneDecors.getTileHeight();
        double paneWidth = paneMap.getWidth();
        double paneHeight = paneMap.getHeight();

        // Lie la translation de paneMap à la position cible
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

        // Définit l'échelle de paneMap
        paneMap.setScaleX(targetScale);
        paneMap.setScaleY(targetScale);

        // Translation de hboxInventaire et paneCoeurs pour qu'ils bougent avec le héros
        hboxVueInventaire.translateXProperty().bind(
                paneMap.translateXProperty().multiply(-1) // Inverse de la translation de paneMap pour les fixer
        );
        hboxVueInventaire.translateYProperty().bind(
                paneMap.translateYProperty().multiply(-1) // Inverse de la translation de paneMap pour les fixer
        ); hboxInventaire.translateXProperty().bind(
                paneMap.translateXProperty().multiply(-1) // Inverse de la translation de paneMap pour les fixer
        );
        hboxInventaire.translateYProperty().bind(
                paneMap.translateYProperty().multiply(-1) // Inverse de la translation de paneMap pour les fixer
        );
        paneCoeurs.translateXProperty().bind(
                paneMap.translateXProperty().multiply(-1) // Inverse de la translation de paneMap pour les fixer
        );
        paneCoeurs.translateYProperty().bind(
                paneMap.translateYProperty().multiply(-1) // Inverse de la translation de paneMap pour les fixer
        );
    }



}
