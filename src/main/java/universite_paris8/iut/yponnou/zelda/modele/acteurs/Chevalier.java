
package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement.ComportementChevalier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Chevalier extends Ennemi{
    /**
     *  Représente un Chevalier, un type spécifique d'ennemi, héritant de la classe Ennemi.
     *  Il a un comportement unique de déplacement, où il change de direction après un certain nombre de pas.
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
