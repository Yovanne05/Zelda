
package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement.ComportementGarde;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Garde extends Ennemi{


    /**
     * La classe Garde représente un type spécifique d'ennemi dans le jeu.
     * Ce personnage possède une logique de comportement pour attaquer le héros lorsqu'il est proche
     * et une logique spécifique de déplacement à implémenter. La distance seuil de proximité
     * pour interagir avec le héros est fixée à 60 unités.
     */

    public Garde(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 1, direction, arme, 120, new ComportementGarde());
    }

}