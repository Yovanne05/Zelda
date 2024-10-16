package universite_paris8.iut.yponnou.zelda.modele.armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class ArmeDistance extends Arme{
    private DoubleProperty posx;
    private DoubleProperty posy;
    private Projectile projectile;

    public ArmeDistance(double posxi, double posyi, Projectile projectile, Environnement environnement) {
        super(posxi,posyi,environnement);
        this.projectile=projectile;
        posx=new SimpleDoubleProperty(posxi);
        posy=new SimpleDoubleProperty(posyi);
    }


    public Projectile getProjectile() {
        return projectile;
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


    public void setPosx(double posx) {
        this.posx.setValue(posx);
    }

    public void setPosy(double posy) {
        this.posy.setValue(posy);
    }

    public abstract int utiliser();

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    public String nom(){
        return "ArmeDistance";
    }


}