package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Projectile;
import universite_paris8.iut.yponnou.zelda.vue.FelcheVue;

public class ObservateurProjectiles extends Constante implements ListChangeListener<Projectile> {

    private Pane pane;

    public ObservateurProjectiles(Pane pane) {
        this.pane=pane;
    }
    @Override
    public void onChanged(Change<? extends Projectile> change) {
        while (change.next()) {
            for (Projectile a : change.getAddedSubList()) {
                FelcheVue f=new FelcheVue(pane, (Fleche) a);
            }
            for (Projectile a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));

                }
            }
        }
    }
}
