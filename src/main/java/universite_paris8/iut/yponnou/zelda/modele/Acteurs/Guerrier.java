
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public abstract class Guerrier extends Acteur {
    private Arme arme;

    public Guerrier(String nom, double x, double y, int pv, double vitesse, Environnement environnement, Direction direction, Arme arme) {
        super(nom, x, y, pv, vitesse, environnement, direction);
        this.arme=arme;
    }
    public Arme getArme() {
        return arme;
    }
    public void setArme(Arme arme) {
        this.arme = arme;
    }
}
