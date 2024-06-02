package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;

public class ActeurVue {

    private Pane pane;
    private Acteur acteur;

    public ActeurVue(Acteur actVue, Pane pane) {
        this.pane = pane;
        this.acteur = actVue;
    }

    public Pane getPane() {
        return pane;
    }
    public Acteur getActeurVue() {
        return acteur;
    }

    public void creerSprite(){
        Rectangle r = new Rectangle(Constante.TAILLECASEX,Constante.TAILLECASEY);
        r.setFill(Color.YELLOW);
        r.setId(acteur.getId());
        r.setX(acteur.getPosition().getX());
        r.setY(acteur.getPosition().getY());
        r.translateXProperty().bind(acteur.getPosition().xProperty());
        r.translateYProperty().bind(acteur .getPosition().yProperty());
        pane.getChildren().add(r);
    }
}
