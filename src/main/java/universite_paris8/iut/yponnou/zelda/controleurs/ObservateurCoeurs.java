package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.vue.Pv.CoeursVue;

public class ObservateurCoeurs extends ObservateurPv{

    public ObservateurCoeurs(Pane pane) {
        super(pane,20);
    }

    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldInt, Number newInt) {
        int nbCoeursPleins = newInt.intValue()/getPortionPv();
        int pvCoeurEndommage = newInt.intValue()%getPortionPv();
        CoeursVue pvVue = new CoeursVue(nbCoeursPleins,pvCoeurEndommage,getPane());
        pvVue.spritePv();
    }
}
