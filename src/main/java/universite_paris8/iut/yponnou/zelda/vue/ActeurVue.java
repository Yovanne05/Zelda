package universite_paris8.iut.yponnou.zelda.vue;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;

public class ActeurVue extends Affichable implements ListChangeListener<Acteur> {

    private Image heroImage;
    private Image enemyImage;

    public ActeurVue(int[][] tab, Pane pane) {
        super(tab, pane);
        heroImage = new Image("file:C:\\\\Users\\\\Mazur\\\\IdeaProjects\\\\Zelda\\\\src\\\\main\\\\resources\\\\universite_paris8\\\\iut\\\\yponnou\\\\zelda\\\\Images\\\\carrerouge.png");

        //  heroImage = new Image("file:C:\\Users\\Mazur\\IdeaProjects\\Zelda\\src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\Images\\player.png");
        enemyImage = new Image("file:src/main/resources/enemy.png");
    }

    public void creerSprite(Acteur a) {
        ImageView imageView;
        if (a instanceof Hero) {
            imageView = new ImageView(heroImage);
        } else if (a instanceof Ennemi) {
            imageView = new ImageView(enemyImage);
        } else {
            throw new IllegalArgumentException("Acteur non supporté");
        }

        imageView.setFitWidth(getTailleCaseX());
        imageView.setFitHeight(getTailleCaseY());
        imageView.setId(a.getId());

        imageView.setX(getTailleCaseX() * a.getX());
        imageView.setY(getTailleCaseY() * a.getY());
        a.setX((int) imageView.getX());
        a.setY((int) imageView.getY());
        imageView.translateXProperty().bind(a.xProperty());
        imageView.translateYProperty().bind(a.yProperty());

        getPane().getChildren().add(imageView);
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                creerSprite(a);
            }
            for (Acteur a : change.getRemoved()) {
                getPane().getChildren().removeIf(node -> node.getId().equals(a.getId()));
            }
        }
    }

    public boolean checkCollision(Acteur a, double dx, double dy) {
        for (Node node : getPane().getChildren()) {
            if (node instanceof ImageView && !node.getId().equals(a.getId())) {
                ImageView other = (ImageView) node;
                if (other.getBoundsInParent().intersects(a.getX() + dx, a.getY() + dy, getTailleCaseX(), getTailleCaseY())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moveHero(Hero hero, double dx, double dy) {
        if (!checkCollision(hero, dx, dy)) {
            hero.setX( (hero.getX() + dx));
            hero.setY((hero.getY() + dy));
        }
    }
}
