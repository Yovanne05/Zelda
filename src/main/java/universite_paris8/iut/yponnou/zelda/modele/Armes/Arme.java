
package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Arme extends Objet {

    public Arme(double x, double y, Environnement environnement) {
        super(x, y, environnement);
    }

    public String nom() {
        return "arme";
    }

}
