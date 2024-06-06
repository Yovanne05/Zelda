package universite_paris8.iut.yponnou.zelda.vue.Acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;

public class EnnemiVue extends ActeurVue{

    private final Image enemyImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/zombie.png");

    public EnnemiVue(Acteur acteur, Pane pane) {
        super(acteur, pane);
    }

    private Image getEnemyImage(String direction) {
        return switch (direction) {
            case "right" -> enemyImage;
            case "left" -> enemyImage;
            case "down" -> enemyImage;
            case "up" -> enemyImage;
            default -> enemyImage; // Default image if direction is not set
        };
    }

    public void creerSprite(){
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Ennemi)
            imageView = new ImageView(enemyImage);
        /*else if (acteur instanceof Npc) {
            imageView = new ImageView(NPC);
            System.out.println("efzf");
        }*/
        else
            throw new IllegalArgumentException("Acteur non supporté");

        imageView.setFitWidth(Constante.TAILLECASEX);
        imageView.setFitHeight(Constante.TAILLECASEY);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite(Acteur a ,boolean touche) {
        ImageView imageView;

        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));

        if (getActeur() instanceof Hero)
            imageView = new ImageView(getEnemyImage(getActeur().getDirection()));
        else
            throw new IllegalArgumentException("Acteur non supporté");
//        return imageView;
        imageView.setFitWidth(Constante.TAILLECASEX);
        imageView.setFitHeight(Constante.TAILLECASEY);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }
}
