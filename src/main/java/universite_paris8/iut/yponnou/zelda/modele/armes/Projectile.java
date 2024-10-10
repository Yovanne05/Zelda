
package universite_paris8.iut.yponnou.zelda.modele.armes;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;

import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Projectile extends Acteur {
    private int ptsDegats;
    private double portee;

    public Projectile(double x, double y, Environnement environnement, double vitesse, Direction direction, int ptsDegats, double portee) {
        super(x, y, environnement, vitesse, direction);
        this.portee=portee;
        this.ptsDegats=ptsDegats;
    }

    public double getPortee() {
        return portee;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }

    public String nom(){
        return "Projectile";
    }


}
