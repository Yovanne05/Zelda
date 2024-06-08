
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Garde extends Ennemi{


    public Garde(double x, double y, double vitesse, Environnement environnement, int dx, int dy, Arme arme) {
        super("Garde", x, y, 120, vitesse, environnement, dx, dy, arme);
    }

    public void attaquer() {
    }
}
