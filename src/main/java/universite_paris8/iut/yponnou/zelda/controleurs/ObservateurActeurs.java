package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteur;

public class ObservateurActeurs extends Affichable implements ListChangeListener<Acteur> {


    public ObservateurActeurs(Pane pane) {
        super(pane);
    }

    public void creerSprite(Acteur a) {
        Rectangle r = new Rectangle(getTailleCaseX(),getTailleCaseY());
        r.setFill(Color.YELLOW);
        r.setId(a.getId());
        r.setX(getTailleCaseX()*a.getX());
        r.setY(getTailleCaseY()*a.getY());
        r.translateXProperty().bind(a.xProperty());
        r.translateYProperty().bind(a.yProperty());
        getPane().getChildren().add(r);
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                creerSprite(a);
            }
            for (Acteur a : change.getRemoved()) {
                for (int i = 0; i < getPane().getChildren().size(); i++) {
                    if (getPane().getChildren().get(i).getId().equals(a.getId())){
                        Node node = getPane().getChildren().get(i);
                        getPane().getChildren().remove(node);
                    }
                }
            }
        }
    }
}
