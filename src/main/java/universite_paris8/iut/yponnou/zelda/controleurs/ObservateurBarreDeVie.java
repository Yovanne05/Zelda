package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.vue.Pv.BarreDeVieVue;

public class ObservateurBarreDeVie extends ObservateurPv {

    private final Ennemi e;

    // portion de 15 pour des pv max de 120 (apres 240 pour les plus forts puis 360 pour les boss)
    public ObservateurBarreDeVie(Ennemi ennemi, Pane pane) {
        super(pane,15);
        e = ennemi;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
        int etatBarreDeVie = newValue.intValue()/getPortionPv();
        BarreDeVieVue brVue = new BarreDeVieVue(e,etatBarreDeVie,getPane());
        brVue.spritePv();
    }
}
