package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie.ObservateurBarreDeVie;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.armes.Fleche;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.*;
import universite_paris8.iut.yponnou.zelda.vue.armes.FlecheVue;
import universite_paris8.iut.yponnou.zelda.vue.pv.BarreDeVieVue;

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
                else if (a instanceof Ennemi){
                    if(a instanceof Garde){
                        actVue = new GardeVue(a,pane);
                    } else if (a instanceof Chevalier) {
                        actVue = new ChevalierVue(a,pane);
                    }else if(a instanceof Boss){
                        actVue = new BossVue(a,pane);
                    }
                    ((Ennemi) a).pvProperty().addListener(new ObservateurBarreDeVie((Ennemi)a,pane,new BarreDeVieVue((Ennemi)a,pane)));
                }
                else if (a instanceof Paysan) {
                    actVue = new PaysanVue(a,pane);
                }
                else if (a instanceof Vendeur){
                    actVue = new VendeurVue(a,pane);
                }
                else if (a instanceof Fleche){
                    actVue = new FlecheVue((Fleche)a,pane);
                }else if(a instanceof Frere){
                    actVue= new FrereVue(a,pane);
                }
                assert actVue != null;
                actVue.creerSprite();

                }
            for (Acteur a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));
                    if (a instanceof Ennemi)
                        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()+"BarreVie"));
                }
            }
        }
    }
}
