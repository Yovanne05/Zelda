package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;

public class ActeurVue extends Pixable{
    private Acteur a;
    private Pane pane;

    public ActeurVue(Acteur a, Pane pane) {
        this.a = a;
        this.pane=pane;
        setTailleCaseX((int) pane.getPrefWidth()/a.getMap().getLargeur());
        setTailleCaseY((int) pane.getPrefHeight()/a.getMap().getHauteur());
    }

    @Override
    public void afficher() {
        Rectangle rectangle = new Rectangle(getTailleCaseX(),getTailleCaseY());
        rectangle.setFill(Color.YELLOW);
        pane.getChildren().add(rectangle);
        rectangle.translateXProperty().bind(a.xProperty());
        rectangle.translateYProperty().bind(a.yProperty());
    }
}
