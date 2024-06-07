package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Paysans;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.EnnemiVue;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.PaysansVue;

public class ObservateurActeurs implements ListChangeListener<Acteur> {

    private final Pane pane;

    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                ActeurVue actVue=null;
                if (a instanceof Hero){
                    actVue = new HeroVue(a,pane);
                }
                else if(a instanceof Ennemi){
                    actVue = new EnnemiVue(a,pane);
                } else if (a instanceof Paysans) {
                    actVue = new PaysansVue(a,pane);
                }
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
