package universite_paris8.iut.yponnou.zelda.vue;

import javafx.animation.Timeline;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Projectile;

public class FelcheVue {
    private Rectangle fleche;
    private Fleche f;
    private Pane pane;
    public FelcheVue(Pane pane, Fleche f) {
        this.pane=pane;
        fleche = new Rectangle(10, 2, Color.WHITE);
        this.f=f;
        creerSprite();
    }
    public void creerSprite(){
        fleche.setId(f.getId());
        fleche.translateXProperty().bind(f.getPosition().xProperty());
        fleche.translateYProperty().bind(f.getPosition().yProperty());
        pane.getChildren().add(fleche);
    }
}
