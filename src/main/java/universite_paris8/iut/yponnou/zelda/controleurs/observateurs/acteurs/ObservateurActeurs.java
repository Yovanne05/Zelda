package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.vue.Armes.FlecheVue;

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
                else if(a instanceof Garde){
                    actVue = new GardeVue(a,pane);
                } else if (a instanceof Paysan) {
                    actVue = new PaysanVue(a,pane);
                } else if (a instanceof Chevalier) {
                    actVue = new ChevalierVue(a,pane);
                }else if(a instanceof Boss){
                    actVue = new BossVue(a,pane);
                }else if (a instanceof Vendeur){
                    actVue = new VendeurVue(a,pane);
                }
                else if (a instanceof Fleche){
                    actVue = new FlecheVue((Fleche)a,pane);
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
