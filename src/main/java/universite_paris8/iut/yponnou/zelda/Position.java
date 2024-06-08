package universite_paris8.iut.yponnou.zelda;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Position {

    private DoubleProperty x;
    private DoubleProperty y;
    private Environnement env;

    public Position(double x, double y, Environnement env) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.env = env;
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
    public Environnement getEnv() {
        return env;
    }
    public void setEnv(Environnement env) {
        this.env = env;
    }

    public double distance(Position other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getX();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
