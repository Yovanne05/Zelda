package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.NourritureVue;
import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;
import universite_paris8.iut.yponnou.zelda.vue.PommeVue;

public class ObservateurObjets implements ListChangeListener<Objet> {

    private Pane pane;

    public ObservateurObjets(Pane pane) {
        this.pane=pane;
    }

    public Pane getPane() {
        return pane;
    }

    @Override
    public void onChanged(Change<?extends Objet> change) {
        Node node;
        while (change.next()) {
            for (Objet ob : change.getAddedSubList()) {
                if (ob instanceof Pomme) {
                    PommeVue pommeVue = new PommeVue((Pomme) ob,pane);
                    pommeVue.creerSprite();
                }
                else {
                    ObjetVue objVue = new ObjetVue(ob, pane);
                    objVue.creerSprite();
                }
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
