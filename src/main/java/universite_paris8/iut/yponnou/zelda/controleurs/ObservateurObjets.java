package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Objet;

public class ObservateurObjets extends Constante implements ListChangeListener<Objet> {

    private Pane pane;

    public ObservateurObjets(Pane pane) {
        this.pane=pane;
    }

    public void creerSprite(Objet ob) {
        Rectangle r = new Rectangle(TAILLECASEX,TAILLECASEY);
        r.setFill(Color.GREEN);
        r.setId(ob.getId());
        r.setX(ob.getX());
        r.setY(ob.getY());
//        r.translateXProperty().bind(ob.xProperty());
//        r.translateYProperty().bind(ob.yProperty());
        pane.getChildren().add(r);
    }

    public Pane getPane() {
        return pane;
    }

    @Override
    public void onChanged(Change<?extends Objet> change) {
        Node node;
        while (change.next()) {
            for (Objet ob : change.getAddedSubList()) {
                creerSprite(ob);
            }
            for (Objet ob : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    if (pane.getChildren().get(i).getId().equals(ob.getId())) {
                        node = pane.getChildren().get(i);
                        pane.getChildren().remove(node);
                    }
                }
            }
        }
    }
}