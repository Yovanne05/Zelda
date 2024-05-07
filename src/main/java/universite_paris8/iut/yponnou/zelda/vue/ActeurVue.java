package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;

public class ActeurVue {
    private Acteur a;
    private Pane pane;

    public ActeurVue(Acteur a, Pane pane) {
        this.a = a;
        this.pane=pane;
        placementActeur();
    }

    public void placementActeur() {
        Rectangle rectangle = new Rectangle(50,50);
        rectangle.setFill(Color.YELLOW);
        pane.getChildren().add(rectangle);
        rectangle.translateXProperty().bind(a.xProperty());
        rectangle.translateYProperty().bind(a.yProperty());
    }
}
