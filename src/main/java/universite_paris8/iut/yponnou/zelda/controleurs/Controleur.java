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
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Objet;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Hero perso;

    private static int dx;
    private static int dy;

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
    private Map map;
    private Environnement environnement;
    private Fleche f;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        map = new Map(30, 30);
        map.initialisationMap();
        environnement = new Environnement(map);
        MapVue tileMap = new MapVue(map.getTabNum(), tilePaneDecors);


        perso = new Hero("Joseph", 10, 400, 400,0.2, environnement,0,0,null);
        f= new Fleche(perso.getX(),perso.getY(),environnement, 1,0);
        ArcArme a =new ArcArme(perso.getX(), perso.getY(),f, environnement);
        perso.setArme(a);

        environnement.getObjets().addListener(new ObservateurObjets(paneObjets));
        environnement.getActeurs().addListener(new ObservateurActeurs(paneMap));
        environnement.getProjectiles().addListener(new ObservateurProjectiles(paneMap));
        perso.getInventaire().getObjets().addListener(new ObservateurInventaire(hboxInventaire));

        environnement.ajouterActeur(perso);

        Epee e= new Epee(environnement);
        g=new Garde("G", 5,400,500,0.03,environnement,0,1,e);

        environnement.ajouterActeur(g);

        map.initialisationMap();
        tileMap.creerSprite();
        initAnimation();
        gameLoop.play();
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Hero p = perso;
        Objet ob;
        switch (key) {
            case Z:
            case UP:
                p.setDx(0);
                p.setDy(-1);
                p.deplacement();
                System.out.println("HAUT - x:"+p.getX()+" y:"+p.getY());
                dx=0;
                dy=-1;
                break;
            case S:
            case DOWN:
                p.setDx(0);
                p.setDy(1);
                p.deplacement();
                System.out.println("BAS - x:"+p.getX()+" y:"+p.getY());
                dx=0;
                dy=1;
                break;
            case D:
            case RIGHT:
                p.setDx(1);
                p.setDy(0);
                p.deplacement();
                System.out.println("DROITE - x:"+p.getX()+" y:"+p.getY());
                dx=1;
                dy=0;
                break;
            case Q:
            case LEFT:
                p.setDx(-1);
                p.setDy(0);
                p.deplacement();
                System.out.println("GAUGHE - x:"+p.getX()+" y:"+p.getY());
                dx=-1;
                dy=0;
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
                perso.attaquer(dx,dy);
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
                    environnement.toutLeMondeBouge();
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