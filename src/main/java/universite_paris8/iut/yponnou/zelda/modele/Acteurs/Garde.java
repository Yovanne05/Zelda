package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Garde extends Ennemi{
    public Garde(String nom, double x, double y, int pv, double vitesse, Environnement environnement, Arme arme) {
        super(nom, x, y, pv,vitesse, environnement, arme);
    }

    @Override
    public void attaquer() {
    }

    @Override
    void parler() {
    }
}
//test