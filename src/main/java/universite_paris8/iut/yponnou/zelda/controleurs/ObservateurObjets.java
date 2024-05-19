package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Objet;

public class ObservateurObjets extends Affichable implements ListChangeListener<Objet> {


    public ObservateurObjets(Pane pane) {
        super(pane);
    }

    public void creerSprite(Objet ob) {
        Rectangle r = new Rectangle(getTailleCaseX(),getTailleCaseY());
        r.setFill(Color.GREEN);
        r.setId(ob.getId());
        r.setX(getTailleCaseX()*ob.getX());
        r.setY(getTailleCaseY()*ob.getY());
//        r.translateXProperty().bind(ob.xProperty());
//        r.translateYProperty().bind(ob.yProperty());
        getPane().getChildren().add(r);
    }

    @Override
    public void onChanged(Change<?extends Objet> change) {
        Node node;
        while (change.next()) {
            for (Objet ob : change.getAddedSubList()) {
                creerSprite(ob);
            }
            for (Objet ob : change.getRemoved()) {
                for (int i = 0; i < getPane().getChildren().size(); i++) {
                    if (getPane().getChildren().get(i).getId().equals(ob.getId())) {
                        node = getPane().getChildren().get(i);
                        getPane().getChildren().remove(node);
                    }
                }
            }
        }
    }
}
