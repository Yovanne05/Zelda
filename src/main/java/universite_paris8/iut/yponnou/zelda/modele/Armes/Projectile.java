
package universite_paris8.iut.yponnou.zelda.modele.Armes;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Son;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Projectile extends Acteur {
    private int ptsDegats;
    private double portee;


    private final Son sonFleche = new Son("/universite_paris8/iut/yponnou/zelda/Sons/bruits/sonFleche.wav");

    public Projectile(double x, double y, Environnement environnement, double vitesse, Direction direction, int ptsDegats, double portee) {
        super(x, y, environnement, vitesse, direction);
        this.portee=portee;
        this.ptsDegats=ptsDegats;
        try {
            sonFleche.jouer(1,0);
        }catch (Exception e){
            System.out.println("Son incompatible");
        }
    }

    public double getPortee() {
        return portee;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }


}
