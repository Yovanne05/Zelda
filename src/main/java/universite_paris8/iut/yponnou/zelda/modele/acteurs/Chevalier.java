
package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Chevalier extends Ennemi{

    private int cptPas;
    private int maxPas; // Nombre de pas avant de changer de direction

    public Chevalier(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 0.03, direction, arme, 240);
        this.cptPas = 0;
        this.maxPas = 300;
    }

    @Override
    public void deplacementEnnemi() {
        verifierEtAttaquer(80);
        changementDirectionSiPossible();
        this.deplacement();
    }

    public void changementDirectionSiPossible() {
        cptPas++;
        if (cptPas >= maxPas) {
            this.getDirection().changementDirection(-this.getDirection().getDx(), -this.getDirection().getDy());
            cptPas = 0;
        }
    }

}
