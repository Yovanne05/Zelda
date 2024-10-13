package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.EnnemiVue;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.PaysanVue;

public class ObservateurActeurs implements ListChangeListener<Acteur> {

    private final Pane pane;

    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                ActeurVue actVue;
                if (a instanceof Hero)
                    actVue = new HeroVue(a,pane);
                else if (a instanceof Paysan) {
                    actVue = new PaysanVue(a,pane);
                }
                else
                    actVue = new EnnemiVue(a,pane);
                actVue.creerSprite();
            }
            for (Acteur a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    System.out.println(this.pane.lookup("#"+a.getId()));
                    this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));
                    if (a instanceof Ennemi)
                        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()+"BarreVie"));
                }
            }
        }
    }
}