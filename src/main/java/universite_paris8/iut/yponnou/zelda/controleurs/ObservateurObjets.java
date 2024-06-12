package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.Armes.ArcVue;
import universite_paris8.iut.yponnou.zelda.vue.Armes.EpeeVue;
import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;
import universite_paris8.iut.yponnou.zelda.vue.Nourritures.PommeVue;

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
                else if (ob instanceof ArcArme){
                    ObjetVue objVue = new ArcVue(ob, pane);
                    objVue.creerSprite();
                } else if (ob instanceof Epee) {
                    EpeeVue epeeVue = new EpeeVue(ob, pane);
                    epeeVue.creerSprite();
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
