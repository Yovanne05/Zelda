package universite_paris8.iut.yponnou.zelda.vue.Armes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;

public class FlecheVue {
    private Rectangle fleche;
    private Fleche f;
    private Pane pane;

    public FlecheVue(Pane pane, Fleche f) {
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