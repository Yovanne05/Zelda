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
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
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
    private Pane paneObjets;
    @FXML
    private TilePane tilePaneDecors;
    @FXML
    private HBox paneCoeurs;
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
        perso = new Hero("Joseph", 0, 0, environnement);
        Pomme objet1 = new Pomme(80, 100, environnement);
        Pomme objet2 = new Pomme(60, 90, environnement);
        Pomme objet3 = new Pomme(100, 100, environnement);
        Pomme objet4 = new Pomme(60, 140, environnement);
        Pomme objet5 = new Pomme(165, 90, environnement);

        environnement.getObjets().addListener(new ObservateurObjets(paneObjets));
        environnement.getActeurs().addListener(new ObservateurActeurs(paneMap));
        perso.pvProperty().addListener(new ObservateurCoeurs(paneCoeurs));
        perso.getInventaire().addListener(new ObservateurObjets(hboxInventaire));


        environnement.ajouterObjet(objet1);
        environnement.ajouterObjet(objet2);
        environnement.ajouterObjet(objet3);
        environnement.ajouterObjet(objet4);
        environnement.ajouterObjet(objet5);
        environnement.ajouterActeur(perso);
        perso.subitDegats(100);
        tileMap.affichageMap();
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Hero p = perso;
        Objet ob;
        Nourriture aliment;
        switch (key) {
            case Z:
            case UP:
                p.deplacement(0, -1);
                System.out.println("HAUT - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                break;
            case S:
            case DOWN:
                p.deplacement(0, 1);
                System.out.println("BAS - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                break;
            case D:
            case RIGHT:
                p.deplacement(1, 0);
                System.out.println("DROITE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                break;
            case Q:
            case LEFT:
                p.deplacement(-1, 0);
                System.out.println("GAUGHE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
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
                }
                else {
                    System.out.println("Inventaire vide");
                }
            case M:
                aliment = perso.possedeNourritures();
                if (aliment != null) {
                    if (!perso.pleineSante()) {
                        perso.guerison(aliment.getPv());
                        System.out.println(perso.getNom() + " a mangé " + aliment.getNom());
                        perso.getInventaire().remove(aliment);
                    }
                    else
                        System.out.println("Votre santé déjà complète !");
                }
                else
                    System.out.println("Aucun aliments trouvés");
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
