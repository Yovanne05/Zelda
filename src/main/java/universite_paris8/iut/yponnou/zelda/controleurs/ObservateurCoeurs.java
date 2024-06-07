package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.vue.Pv.CoeursVue;

public class ObservateurCoeurs extends ObservateurPv{

    private final CoeursVue cVue;

    public ObservateurCoeurs(Pane pane, CoeursVue coeurVue) {
        super(pane,20);
        this.cVue = coeurVue;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldInt, Number newInt) {
        int nbCoeursPleins = newInt.intValue()/getPortionPv();
        int pvCoeurEndommage = newInt.intValue()%getPortionPv();
        cVue.spritePv(nbCoeursPleins, pvCoeurEndommage);
    }
}
