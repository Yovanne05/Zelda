package universite_paris8.iut.yponnou.zelda.vue;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Objet;

public class ObjetVue extends Affichable implements ListChangeListener<Objet> {


    public ObjetVue(int[][] tab, Pane pane) {
        super(tab,pane);
    }

    public void creerSprite(Objet objet) {
        Rectangle r;
        r = new Rectangle(getTailleCaseX(),getTailleCaseY());
        r.setFill(Color.GREEN);
        r.setId(objet.getId());

        r.setX(getTailleCaseX()*objet.getX());
        r.setY(getTailleCaseY()*objet.getY());
        objet.setX((int)r.getX());
        objet.setY((int)r.getY());

        r.translateXProperty().bind(objet.xProperty());
        r.translateYProperty().bind(objet.yProperty());
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
