
package universite_paris8.iut.yponnou.zelda.vue.acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Boss;


public class BossVue extends ActeurVue{

    private final Image bossImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/boss.png");
    public BossVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getBossImage(String direction) {
        return switch (direction) {
            case "right" -> bossImage;
            case "left" -> bossImage;
            case "down" -> bossImage;
            case "up" -> bossImage;
            default -> bossImage; // Default image if direction is not set
        };
    }
    @Override
    public void creerSprite() {
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Boss)
            imageView = new ImageView(bossImage);
        /*else if (acteur instanceof Npc) {
            imageView = new ImageView(NPC);
            System.out.println("efzf");
        }*/
        else
            throw new IllegalArgumentException("Acteur non supporté");

        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite() {
        ImageView imageView;

        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));

        if (getActeur() instanceof Boss)
            imageView = new ImageView(getBossImage(getActeur().getDirection().directionString()));
        else
            throw new IllegalArgumentException("Acteur non supporté");
//        return imageView;
        imageView.setFitWidth(Constante.TAILLE70);
        imageView.setFitHeight(Constante.TAILLE70);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }
}
