package universite_paris8.iut.yponnou.zelda.modele.Armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEX;
import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEY;

public class Projectile extends Acteur {
    private int ptsDegats;
    private double portee;

    public Projectile(String nom, double x, double y, int pv, double vitesse, Environnement environnement, int dx, int dy, double portee, int ptsDegats) {
        super(nom, x, y, pv, vitesse, environnement, dx, dy);
        this.portee=portee;
        this.ptsDegats=ptsDegats;
    }


    public double getPortee() {
        return portee;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }

    public void deplacement(){
        double prochainX = getPosition().getX() + (this.getDx() * this.getVitesse()) * TAILLECASEX;
        double prochainY = getPosition().getY() + (this.getDy() * this.getVitesse()) * TAILLECASEY;
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, TAILLECASEX, TAILLECASEY);

        if (!collisionAvecObstacle(futureHitbox)) {
            setX(prochainX);
            setY(prochainY);
        }
    }

}
