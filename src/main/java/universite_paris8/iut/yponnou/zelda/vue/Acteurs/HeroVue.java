package universite_paris8.iut.yponnou.zelda.vue.Acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;

import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEX;
import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEY;

public class HeroVue extends ActeurVue {

    //////////////PLAYER MOVING
    private final Image playerUp = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_up.gif");
    private final Image playerRight = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_right.gif");
    private final Image playerLeft = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_left.gif");
    private final Image playerDown = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_down.gif");
    ////////////////////PLAYER STATIC
    private final Image playerUpS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_upS.gif");
    private final Image playerRightS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_rightS.gif");
    private final Image playerLeftS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_leftS.gif");
    private final Image playerDownS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_downS.gif");

    public HeroVue(Acteur acteurVue, Pane pane) {
        super(acteurVue, pane);
    }

    private Image getHeroImage(String direction,boolean touche) {
        if(touche){
            System.out.println("TOUCHE");
            switch (direction) {
                case "right":
                    return playerRight;
                case "left":
                    return playerLeft;
                case "up":
                    return playerUp;
                default:
                    return playerDown;// Default image if direction is not set
            }}
        else {
            switch (direction) {
                case "right":
                    return playerRightS;
                case "left":
                    return playerLeftS;
                case "up":
                    return playerUpS;
                default:
                    return playerDownS;// Default image if direction is not set
            }
        }
    }

    @Override
    public void creerSprite() {
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Hero)
            imageView = new ImageView(playerDownS);
        /*else if (acteur instanceof Npc) {
            imageView = new ImageView(NPC);
            System.out.println("efzf");
        }*/
        else
            throw new IllegalArgumentException("Acteur non supporté");

        imageView.setFitWidth(TAILLECASEX);
        imageView.setFitHeight(TAILLECASEY);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite(Acteur a, boolean touche) {
        ImageView imageView;
        getPane().getChildren().remove(getPane().lookup("#" + a.getId()));
        imageView = new ImageView(getHeroImage(a.getDirection(),touche));
        imageView.setFitWidth(TAILLECASEX);
        imageView.setFitHeight(TAILLECASEY);
        imageView.translateXProperty().bind(a.getPosition().xProperty());
        imageView.translateYProperty().bind(a.getPosition().yProperty());
        imageView.setId(a.getId());
        getPane().getChildren().add(imageView);
    }







}
