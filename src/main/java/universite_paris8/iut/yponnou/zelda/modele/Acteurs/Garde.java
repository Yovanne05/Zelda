
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Garde extends Ennemi{

    public Garde(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super("Garde", x, y, 120, 0.03, environnement, direction, arme);
    }

    @Override
    public void deplacementEnnemi() {
        verifierEtAttaquer(60);
    }

}
