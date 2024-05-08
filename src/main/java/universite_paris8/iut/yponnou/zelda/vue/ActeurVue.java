package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;

public class ActeurVue {
    private Acteur a;
    private Pane pane;
    public static int tailleCaseX;
    public static int tailleCaseY;

    public ActeurVue(Acteur a, Pane pane) {
        this.a = a;
        this.pane=pane;
        tailleCaseX = (int) pane.getPrefWidth()/a.getMap().getLargeur();
        tailleCaseY = (int) pane.getPrefHeight()/a.getMap().getHauteur();
        placementActeur();
    }

    public void placementActeur() {
        Rectangle rectangle = new Rectangle(tailleCaseX,tailleCaseY);
        rectangle.setFill(Color.YELLOW);
        pane.getChildren().add(rectangle);
        rectangle.translateXProperty().bind(a.xProperty());
        rectangle.translateYProperty().bind(a.yProperty());
    }
}
