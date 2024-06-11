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
import universite_paris8.iut.yponnou.zelda.modele.Village;

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

    private Village v;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAnimation();
        gameLoop.play();
        Map map = new Map(30, 30);
        v = new Village(map,tilePaneDecors, paneObjets, paneMap, paneCoeurs, hboxInventaire);
    }

    @FXML
    public void interaction(KeyEvent event) {
        KeyCode key = event.getCode();
        Hero p = v.heroEnv();
        System.out.println(p);
        Objet ob;
        switch (key) {
            case Z:
            case UP:
                p.setDirection("up");
                p.setDx(0);
                p.setDy(-1);
                p.deplacement();
                System.out.println("HAUT - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                break;
            case S:
            case DOWN:
                p.setDirection("down");
                p.setDx(0);
                p.setDy(1);
                p.deplacement();
                System.out.println("BAS - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                break;
            case D:
            case RIGHT:
                p.setDirection("right");
                p.setDx(1);
                p.setDy(0);
                p.deplacement();
                System.out.println("DROITE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
                break;
            case Q:
            case LEFT:
                p.setDirection("left");
                p.setDx(-1);
                p.setDy(0);
                p.deplacement();
                System.out.println("GAUGHE - x:"+p.getPosition().getX()+" y:"+p.getPosition().getY());
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
        this.touche=false;
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
