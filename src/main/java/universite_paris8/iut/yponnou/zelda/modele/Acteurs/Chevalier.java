
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.PositionEnv;

public class Chevalier extends Ennemi{

    private int cptPas = 0;
    private int maxPas = 300; // Nombre de pas avant de changer de direction

    public Chevalier(double x, double y, Environnement environnement, PositionEnv position, Direction direction, Arme arme) {
        super(x, y, environnement, "Chevalier", position, 0.04, direction, arme, 240, 0);
    }

    public void deplacementEnnemi() {
        verifierEtAttaquer(80);
        changementDirectionSiPossible();
        this.deplacement();
    }

    public void changementDirectionSiPossible() {
        cptPas++;
        if (cptPas >= maxPas) {
            getDirection().setDx(-getDirection().getDx());
            getDirection().setDy(-getDirection().getDy());
            cptPas = 0;
        }
    }

}
