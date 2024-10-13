
package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Garde extends Ennemi{

    public Garde(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 0.03, direction, arme, 120);
    }

    @Override
    public void deplacementEnnemi() {
        verifierEtAttaquer(60);
    }

}
