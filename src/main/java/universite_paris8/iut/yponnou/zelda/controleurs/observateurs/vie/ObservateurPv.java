package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;

public abstract class ObservateurPv implements ChangeListener<Number>{

    private final Pane pane;
    private final int portionPv;

    // cette classe prend pour attribut un pane et un int qui représente la portion de pv choisie.
    public ObservateurPv(Pane pane, int portionPv) {
        this.pane = pane;
        this.portionPv = portionPv;
    }

    public Pane getPane() {
        return pane;
    }
    public int getPortionPv() {
        return portionPv;
    }

    @Override
    public abstract void changed(ObservableValue<? extends Number> observableValue, Number oldInt, Number newInt);
}
