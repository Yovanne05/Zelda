package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;

public class ObservateurActeurs implements ListChangeListener<Acteur>, Dimension {

    private Pane pane;

    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
    }

    public void creerSprite(Acteur a) {
        Rectangle r = new Rectangle(getTailleCaseX(),getTailleCaseY());
        r.setFill(Color.YELLOW);
        r.setId(a.getId());
        r.setX(a.getX());
        r.setY(a.getY());
        r.translateXProperty().bind(a.xProperty());
        r.translateYProperty().bind(a.yProperty());
        pane.getChildren().add(r);
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                creerSprite(a);
            }
            for (Acteur a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    if (pane.getChildren().get(i).getId().equals(a.getId())){
                        Node node = pane.getChildren().get(i);
                        pane.getChildren().remove(node);
                    }
                }
            }
        }
    }
}
