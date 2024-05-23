package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;

public class ObservateurActeurs extends Constante implements ListChangeListener<Acteur> {

    private Pane pane;

    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
    }

    public void creerSprite(Acteur a) {
        Rectangle r = new Rectangle(TAILLECASEX,TAILLECASEY);
        if(a instanceof Hero){
            r.setFill(Color.YELLOW);
        }else if(a instanceof Ennemi){
            r.setFill(Color.RED);
        }
        r.setId(a.getId());
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
                    System.out.println(this.pane.lookup("#"+a.getId()));
                        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));

                }
            }
        }
    }
}