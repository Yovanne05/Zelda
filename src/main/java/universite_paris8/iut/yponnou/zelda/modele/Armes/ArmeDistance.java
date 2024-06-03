package universite_paris8.iut.yponnou.zelda.modele.Armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public abstract class ArmeDistance extends Arme{
    private double portee;
    private double v;
    private DoubleProperty posx;
    private DoubleProperty posy;
    private static int cpt = 0;
    private String id;
    public ArmeDistance(String nom, double ptsDegats, double portee, double posxi, double posyi, double v) {
        super(nom, ptsDegats);
        posx=new SimpleDoubleProperty(posxi);
        posy=new SimpleDoubleProperty(posyi);
        this.portee=portee;
        id=""+cpt++;
        this.v=v;
    }

    public String getId() {
        return id;
    }

    public double getPosx() {
        return posx.getValue();
    }

    public DoubleProperty posxProperty() {
        return posx;
    }

    public double getPosy() {
        return posy.getValue();
    }

    public DoubleProperty posyProperty() {
        return posy;
    }

    public double getPortee() {
        return portee;
    }

    public double getV() {
        return v;
    }

    public void setPosx(double posx) {
        this.posx.setValue(posx);
    }

    public void setPosy(double posy) {
        this.posy.setValue(posy);
    }

    public abstract void utiliser(int dx, int dy);
}
