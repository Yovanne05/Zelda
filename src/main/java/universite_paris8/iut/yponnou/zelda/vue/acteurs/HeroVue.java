

package universite_paris8.iut.yponnou.zelda.vue.acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;


public class HeroVue extends ActeurVue{

    //image du hero tous les angles
    private final Image playerUp = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_up.gif");
    private final Image playerRight = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_right.gif");
    private final Image playerLeft = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_left.gif");
    private final Image playerDown = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_down.gif");

    private final Image playerUpS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_upS.gif");
    private final Image playerRightS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_rightS.gif");
    private final Image playerLeftS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_leftS.gif");
    private final Image playerDownS = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/player/player_downS.gif");



    public HeroVue(Acteur acteur, Pane pane) {
        super(acteur, pane);
    }

    private Image getHeroImage(String direction) {
        return switch (direction) {
            case "right" -> playerRight;
            case "left" -> playerLeft;
            case "up" -> playerUp;
            default -> playerDown;// Default image if direction is not set
        };
    }
    private Image getHeroImageStatic(String direction) {
        return switch (direction) {
            case "right" -> playerRightS;
            case "left" -> playerLeftS;
            case "up" -> playerUpS;
            default -> playerDownS;// Default image if direction is not set
        };
    }

    @Override
    public void creerSprite(){
        ImageView imageView /* = upgradeSprite(acteur)*/;

        imageView = new ImageView(playerDownS);

        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite() {
        ImageView imageView;

        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));

        imageView = new ImageView(getHeroImage(getActeur().getDirection().directionString()));

//        return imageView;
        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    public void upgradeSpriteStatic() {
        ImageView imageView ;
        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));
        switch (getActeur().getDirection().directionString()) {
            case "up" -> imageView = new ImageView(getHeroImageStatic(getActeur().getDirection().directionString()));
            case "left" -> imageView = new ImageView(getHeroImageStatic(getActeur().getDirection().directionString()));
            case "right" -> imageView = new ImageView(getHeroImageStatic(getActeur().getDirection().directionString()));
            default-> imageView = new ImageView(getHeroImageStatic(getActeur().getDirection().directionString()));
        }

        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);

    }
}
