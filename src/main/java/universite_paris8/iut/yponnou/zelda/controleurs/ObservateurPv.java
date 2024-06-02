package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;

public abstract class ObservateurPv implements ChangeListener<Number>{

    private final Pane pane;
    private final int portionPv;

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
    public void changed(ObservableValue<? extends Number> observableValue, Number oldInt, Number newInt) {}
}
