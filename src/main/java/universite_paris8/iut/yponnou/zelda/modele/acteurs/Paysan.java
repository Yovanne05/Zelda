
package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Paysan extends Acteur {

    /**
     * La classe Paysan représente un personnage non-joueur (PNJ) dans le jeu
     * Ce personnage est principalement utilisé pour des interactions environnementales ou narratives.
     */

    public Paysan(double x, double y, Environnement environnement, Direction direction) {
        super(x, y, environnement, 0.03, direction);
    }
}
