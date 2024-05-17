package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Case {

    private IntegerProperty x;
    private IntegerProperty y;
    private Map map;

    public Case(int x, int y, Map map) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.map = map;
    }

    public int getX() {
        return x.getValue();
    }
    public void setX(int x) {
        this.x.setValue(x);
    }
    public int getY() {
        return y.getValue();
    }
    public void setY(int y) {
        this.y.setValue(y);
    }
    public IntegerProperty xProperty() {
        return x;
    }
    public IntegerProperty yProperty() {
        return y;
    }

    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }

}
