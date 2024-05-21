package universite_paris8.iut.yponnou.zelda.vue;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;

public class ActeurVue extends Affichable implements ListChangeListener<Acteur> {


    public ActeurVue(int[][] tab, Pane pane) {
        super(tab,pane);
    }

    public void creerSprite(Acteur a) {
        Rectangle r = new Rectangle(getTailleCaseX(),getTailleCaseY());
        if(a instanceof Hero){
            r.setFill(Color.YELLOW);
        }else if(a instanceof Ennemi){
            r.setFill(Color.RED);
        }
        r.setId(a.getId());
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
