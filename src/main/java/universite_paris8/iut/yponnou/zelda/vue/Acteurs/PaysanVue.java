
package universite_paris8.iut.yponnou.zelda.vue.Acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Paysan;

public class PaysanVue extends ActeurVue{

    private final Image paysansImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/paysans.gif");
    public PaysanVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getPaysansImage(String direction) {
        return switch (direction) {
            case "right" -> paysansImage;
            case "left" -> paysansImage;
            case "up" -> paysansImage;
            default -> paysansImage;// Default image if direction is not set
        };
    }

    @Override
    public void creerSprite() {
        ImageView imageView;
        if (getActeur() instanceof Paysan)
            imageView = new ImageView(paysansImage);
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
    public void upgradeSprite(Acteur a , boolean touche) {
        ImageView imageView;

        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));

        if (getActeur() instanceof Hero)
            imageView = new ImageView(getPaysansImage(getActeur().getDirection()));
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
