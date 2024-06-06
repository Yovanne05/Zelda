package universite_paris8.iut.yponnou.zelda.modele.Armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Projectile extends Acteur {
    private double ptsDegats;
    private double portee;

    public Projectile(String nom, double coeurs, double x, double y, double vitesse,double portee, Environnement environnement, int dx, int dy,double ptsDegats) {
        super(nom, coeurs, x, y, vitesse, environnement, dx, dy);
        this.portee=portee;
        this.ptsDegats=ptsDegats;
    }



    public double getPortee() {
        return portee;
    }

    public double getPtsDegats() {
        return ptsDegats;
    }

    public void deplacement(){
        double prochainX = getX() + (this.getDx() * this.getVitesse()) * TAILLECASEX;
        double prochainY = getY() + (this.getDy() * this.getVitesse()) * TAILLECASEY;
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, TAILLECASEX, TAILLECASEY);

        if (!collisionAvecObstacle(futureHitbox)) {
            setX(prochainX);
            setY(prochainY);
        }
    }

}
