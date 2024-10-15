
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

public class Arme extends Objet {

    public Arme(double x, double y, Environnement environnement) {
        super(x, y, environnement);
    }

    public String nom() {
        return "arme";
    }

}
