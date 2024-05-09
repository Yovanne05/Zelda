package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Objet;

public class ObjetVue extends Pixable {

    private Objet objet;
    private TilePane tilePane;

    public ObjetVue(Objet objet, TilePane tilePane) {
        this.objet = objet;
        this.tilePane = tilePane;
        setTailleCaseX((int)(this.tilePane.getPrefWidth() / objet.getMap().getLargeur()));
        setTailleCaseY((int)(this.tilePane.getPrefHeight() / objet.getMap().getHauteur()));
    }

    @Override
    public void afficher() {
        Rectangle rectangle = new Rectangle(getTailleCaseX(),getTailleCaseY());
        rectangle.setX(getTailleCaseX()*objet.getX());
        rectangle.setY(getTailleCaseY()*objet.getY());

        objet.setX((int)rectangle.getX());
        objet.setY((int)rectangle.getY());

        rectangle.setFill(Color.WHITE);
        tilePane.getChildren().add(rectangle);
        rectangle.translateXProperty().bind(objet.xProperty());
        rectangle.translateYProperty().bind(objet.yProperty());
    }
}
