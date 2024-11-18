
package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;


public class Vendeur extends Acteur {

    /**
     * La classe Vendeur représente un personnage non-joueur (PNJ) dans le jeu,
     * spécialisé dans l'échange ou la vente d'objets avec le joueur.
     * Ce personnage joue un rôle principalement interactif
     * pour enrichir l'expérience du joueur.
     */


    public Vendeur(double x, double y, Environnement environnement, Direction direction) {
        super(x, y, environnement, 0.03, direction);
    }
}
