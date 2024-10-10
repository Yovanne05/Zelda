package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.vue.pv.BarreDeVieVue;

public class ObservateurBarreDeVie extends ObservateurPv {

    private final Ennemi e;
    private BarreDeVieVue brVie;

    // portion de 15 pour des pv max de 120 (apres 240 pour les plus forts puis 360 pour les boss)
    public ObservateurBarreDeVie(Ennemi ennemi, Pane pane, BarreDeVieVue brVieVue) {
        super(pane,15);
        e = ennemi;
        brVie = brVieVue;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
        int etatBarreDeVie = newValue.intValue()/getPortionPv();
        brVie.spritePv(etatBarreDeVie);
    }
}
