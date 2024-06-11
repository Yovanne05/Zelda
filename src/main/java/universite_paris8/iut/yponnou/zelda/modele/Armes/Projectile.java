
package universite_paris8.iut.yponnou.zelda.modele.Armes;


import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

import static universite_paris8.iut.yponnou.zelda.Constante.TAILLE50;

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
        double prochainX = getPosition().getX() + (this.getDx() * this.getVitesse()) * TAILLE50;
        double prochainY = getPosition().getY() + (this.getDy() * this.getVitesse()) * TAILLE50;
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, TAILLE50, TAILLE50);

        if (!collisionAvecObstacle(futureHitbox)) {
            setX(prochainX);
            setY(prochainY);
        }
    }

}
