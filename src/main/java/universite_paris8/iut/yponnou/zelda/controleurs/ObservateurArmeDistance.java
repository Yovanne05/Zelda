package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.vue.FelcheVue;

public class ObservateurArmeDistance extends Constante implements ListChangeListener<ArmeDistance> {

    private Pane pane;

    public ObservateurArmeDistance(Pane pane) {
        this.pane=pane;
    }
    @Override
    public void onChanged(Change<? extends ArmeDistance> change) {
        while (change.next()) {
            for (ArmeDistance a : change.getAddedSubList()) {
                FelcheVue f=new FelcheVue(pane);
                f.creerSprite((ArcArme) a);
            }
            for (ArmeDistance a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));

                }
            }
        }
    }
}
