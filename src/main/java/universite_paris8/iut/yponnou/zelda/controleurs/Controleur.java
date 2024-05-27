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
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
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
    private Pane paneObjets;
    @FXML
    private TilePane tilePaneDecors;
    @FXML
    private HBox hboxInventaire;

    private Garde g;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();

        Map map = new Map(30, 30);
        map.initialisationMap();
        Environnement environnement = new Environnement(map);
        MapVue tileMap = new MapVue(map.getTabNum(), tilePaneDecors);
        ArmeMelee a1=new ArmeMelee("Fourche",1);
        perso = new Hero("Joseph", 40, 400, 400,0.2, environnement,a1);
        Objet objet1 = new Objet(800, 650, environnement);
        Objet objet2 = new Objet(765, 500, environnement);

        environnement.getObjets().addListener(new ObservateurObjets(paneObjets));
        environnement.getActeurs().addListener(new ObservateurActeurs(paneMap));
        perso.getInventaire().getObjets().addListener(new ObservateurInventaire(hboxInventaire));

        environnement.ajouterObjet(objet1);
        environnement.ajouterObjet(objet2);
        environnement.ajouterActeur(perso);

        Epee e= new Epee("E",1);
        g=new Garde("G", 5,400,500,0.03,environnement,e);

        environnement.ajouterActeur(g);

        map.initialisationMap();
        tileMap.creerSprite();
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Hero p = perso;
        Objet ob;
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
            case E:
                ob = p.objetsProches();
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
                if (!p.getInventaire().getObjets().isEmpty()) {
                    ob = p.getInventaire().getObjets().get(0);
                    p.deposer(ob);
                    System.out.println("Objet déposé !");
                }
                else {
                    System.out.println("Inventaire vide");
                }
            case J:
                perso.attaquer();

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
}