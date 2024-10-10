
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Paysan extends Acteur {
    public Paysan(double x, double y, Environnement environnement, Direction direction) {
        super(x, y, environnement, 0.03, direction);
    }
}
