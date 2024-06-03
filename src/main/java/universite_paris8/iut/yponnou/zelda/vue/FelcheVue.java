package universite_paris8.iut.yponnou.zelda.vue;

import javafx.animation.Timeline;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.controleurs.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;

public class FelcheVue extends Constante {
    private Rectangle fleche;
    private Pane pane;
    public FelcheVue(Pane pane) {
        this.pane=pane;
    }
    public void creerSprite(ArcArme a){
        fleche = new Rectangle(10, 2, Color.WHITE);
        fleche.setId(a.getId());
        fleche.translateXProperty().bind(a.posyProperty());
        fleche.translateYProperty().bind(a.posxProperty());
        pane.getChildren().add(fleche);
    }
}
