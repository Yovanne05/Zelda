
package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Paysan extends Acteur {
    public Paysan(double x, double y, Environnement environnement, Direction direction) {
        super(x, y, environnement, 0.03, direction);
    }
}
