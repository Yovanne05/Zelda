
package universite_paris8.iut.yponnou.zelda.vue.acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Frere;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;

public class FrereVue extends ActeurVue{

    private final Image frereImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/frere.png");

    public FrereVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getEnemyImage(String direction) {
        return switch (direction) {
            case "right" -> frereImage;
            case "left" -> frereImage;
            case "down" -> frereImage;
            case "up" -> frereImage;
            default -> frereImage; // Default image if direction is not set
        };
    }

    @Override
    public void creerSprite(){
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Frere)
            imageView = new ImageView(frereImage);
        /*else if (acteur instanceof Npc) {
            imageView = new ImageView(NPC);
            System.out.println("efzf");
        }*/
        else
            throw new IllegalArgumentException("Acteur non supporté");

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

        if (getActeur() instanceof Frere)
            imageView = new ImageView(getEnemyImage(getActeur().getDirection().directionString()));
        else
            throw new IllegalArgumentException("Acteur non supporté");
//        return imageView;
        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }
}
