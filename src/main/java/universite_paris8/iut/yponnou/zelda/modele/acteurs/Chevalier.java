
package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement.ComportementChevalier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Chevalier extends Ennemi{

    /**
     * La classe Chevalier représente un ennemi avancé avec un comportement spécifique de patrouille
     * et d'attaque. Il possède un compteur de pas permettant de changer de direction après avoir
     * parcouru une distance définie, et il attaque le héros lorsqu'il est proche (dans un rayon de 100 unités).
     */

    private int cptPas;
    private int maxPas; // Nombre de pas avant de changer de direction

    public Chevalier(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 1, direction, arme, 240, new ComportementChevalier());
        this.cptPas = 0;
        this.maxPas = 300;
    }

    public void changementDirectionSiPossible() {
        cptPas++;
        if (cptPas >= maxPas) {
            this.getDirection().changementDirection(-this.getDirection().getDx(), -this.getDirection().getDy());
            cptPas = 0;
        }
    }


}
