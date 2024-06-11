package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Boss extends Ennemi{
    public Boss(double x, double y,Environnement environnement, int dx, int dy, Arme arme) {
        super("Boss", x, y, 300, 0.03, environnement, dx, dy, arme);
    }

    @Override
    public void attaquer() {

    }
    @Override
    public void deplacementEnnemi() {

    }
}
