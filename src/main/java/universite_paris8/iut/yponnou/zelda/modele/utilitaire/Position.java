package universite_paris8.iut.yponnou.zelda.modele.utilitaire;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;


public class Position {

    /**
     * La classe Position représente une position 2D avec des coordonnées x et y.
     * Elle permet de récupérer et modifier ces coordonnées, de calculer la distance entre deux positions
     * et de déterminer si une position donnée est occupée.
     */

    private DoubleProperty x;
    private DoubleProperty y;

    public Position(double x, double y) {
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

    public Position calculerPositionDevantActeur() {
        double posX = getX();
        double posY = getY() + 5;

        return new Position(posX, posY);
    }

    public boolean estPositionOccupee(Position autrePosition) {
        return getX() == autrePosition.getX() && getY() == autrePosition.getY();
    }

}
