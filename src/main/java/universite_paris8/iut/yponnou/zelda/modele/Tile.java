package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import universite_paris8.iut.yponnou.zelda.controleurs.Dimension;

public class Tile implements Dimension {

    private DoubleProperty x;
    private DoubleProperty y;

    public Tile(double x, double y) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
    }

    public double getX() {
        return x.getValue();
    }
    public void setX(double x) {
        this.x.setValue(x);
    }
    public double getY() {
        return y.getValue();
    }
    public void setY(double y) {
        this.y.setValue(y);
    }
    public DoubleProperty xProperty() {
        return x;
    }
    public DoubleProperty yProperty() {
        return y;
    }
}
