package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObservateurActeurs extends Constante implements ListChangeListener<Acteur> {

    private Pane pane;
    private Image heroImage;
    private Image enemyImage;

    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
        heroImage = new Image("file:C:\\Users\\Mazur\\IdeaProjects\\Zelda\\src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\Images\\LD75.jpg");
        //  heroImage = new Image("file:C:\\Users\\Mazur\\IdeaProjects\\Zelda\\src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\Images\\player.png");
        enemyImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/zombie.png");
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

        imageView.setFitWidth(TAILLECASEX);
        imageView.setFitHeight(TAILLECASEY);
        imageView.setId(a.getId());

        imageView.setX(TAILLECASEX * a.getX());
        imageView.setY(TAILLECASEY * a.getY());
        a.setX((int) imageView.getX());
        a.setY((int) imageView.getY());
        imageView.translateXProperty().bind(a.xProperty());
        imageView.translateYProperty().bind(a.yProperty());

        pane.getChildren().add(imageView);
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                creerSprite(a);
            }
            for (Acteur a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    System.out.println(this.pane.lookup("#"+a.getId()));
                        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));

                }
            }
        }
    }
}