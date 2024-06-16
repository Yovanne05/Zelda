
package universite_paris8.iut.yponnou.zelda.vue.Acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Vendeur;

import static universite_paris8.iut.yponnou.zelda.utilitaire.Constante.TAILLE50;

public class VendeurVue extends ActeurVue {

    private final Image vendeurVue = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/vendeur.png");

    public VendeurVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getVendeurVue(String direction) {
        return switch (direction) {
            case "right" -> vendeurVue;
            case "left" -> vendeurVue;
            case "down" -> vendeurVue;
            case "up" -> vendeurVue;
            default -> vendeurVue; // Default image if direction is not set
        };
    }

    @Override
    public void creerSprite() {
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Vendeur)
            imageView = new ImageView(vendeurVue);
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

        if (getActeur() instanceof Vendeur)
            imageView = new ImageView(getVendeurVue(getActeur().getDirection()));
        else
            throw new IllegalArgumentException("Acteur non supporté");
//        return imageView;
        imageView.setFitWidth(TAILLE50);
        imageView.setFitHeight(TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }
}
