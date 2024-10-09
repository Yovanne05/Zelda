
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Chevalier extends Ennemi{

    private int cptPas = 0;
    private int maxPas = 300; // Nombre de pas avant de changer de direction

    public Chevalier(double x, double y, Environnement environnement, Direction direction, ArmeMelee arme) {
        super("Chevalier", x, y, 240, 0.03, environnement, direction, arme);
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
