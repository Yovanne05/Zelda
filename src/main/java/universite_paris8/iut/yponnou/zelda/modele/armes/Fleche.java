

package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;


public class Fleche extends Projectile {

    /**
     * Classe représentant une flèche, un projectile tiré par l'arc.
     * Une flèche inflige des dégâts et se déplace dans la direction définie lors de son lancement.
     */

    public Fleche(double x, double y, Environnement environnement, Direction direction) {
        super(x, y, environnement, 5, direction, 5, 300);
    }

    @Override
    public void deplacement() {
        getComportementAttaque().infligeDegat();
    }
}
