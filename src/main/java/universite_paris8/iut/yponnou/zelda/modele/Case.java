package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Case {

    private DoubleProperty x;
    private DoubleProperty y;
    private Map map;

    public Case(double x, double y, Map map) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.map = map;
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

    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
}
