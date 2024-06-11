package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Garde extends Ennemi{

    public Garde(double x, double y,Environnement environnement, int dx, int dy, Arme arme) {
        super("Garde", x, y, 120, 0.03, environnement, dx, dy, arme);
    }

    public void attaquer() {
    }

    @Override
    public void deplacementEnnemi() {

    }

}
