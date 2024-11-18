
package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement.ComportementGarde;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Garde extends Ennemi{

    /**
     * Représente un Garde, un type spécifique d'ennemi, héritant de la classe Ennemi.
     * Il a un comportement spécifique.
     */

    public Garde(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 1, direction, arme, 120, new ComportementGarde());
    }

}