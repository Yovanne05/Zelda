
package universite_paris8.iut.yponnou.zelda.vue.acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Chevalier;

public class ChevalierVue extends ActeurVue{

    private final Image chevalierImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/chevalier.png");
    public ChevalierVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getChevalierImage(String direction) {
        return switch (direction) {
            case "right" -> chevalierImage;
            case "left" -> chevalierImage;
            case "down" -> chevalierImage;
            case "up" -> chevalierImage;
            default -> chevalierImage; // Default image if direction is not set
        };
    }
    @Override
    public void creerSprite() {
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Chevalier)
            imageView = new ImageView(chevalierImage);
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

        if (getActeur() instanceof Chevalier)
            imageView = new ImageView(getChevalierImage(getActeur().getDirection().directionString()));
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
