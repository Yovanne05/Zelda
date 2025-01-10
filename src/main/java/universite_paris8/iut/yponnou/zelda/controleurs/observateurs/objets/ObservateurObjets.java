package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.armes.ArcVue;
import universite_paris8.iut.yponnou.zelda.vue.armes.EpeeVue;
import universite_paris8.iut.yponnou.zelda.vue.objets.ClefVue;
import universite_paris8.iut.yponnou.zelda.vue.objets.ObjetVue;
import universite_paris8.iut.yponnou.zelda.vue.nourritures.PommeVue;

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
                } else if (ob instanceof Clef) {
                    ClefVue clefVue = new ClefVue(ob, pane);
                    clefVue.creerSprite();
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
