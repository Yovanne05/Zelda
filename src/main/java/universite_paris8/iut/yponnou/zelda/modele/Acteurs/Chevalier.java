
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.PositionEnv;

public class Chevalier extends Ennemi{

    private int cptPas;
    private int maxPas; // Nombre de pas avant de changer de direction

    public Chevalier(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 0.03, direction, arme, 240);
        this.cptPas = 0;
        this.maxPas = 300;
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
