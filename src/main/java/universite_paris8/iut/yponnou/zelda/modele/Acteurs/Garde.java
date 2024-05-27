package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Garde extends Ennemi{
    public Garde(String nom, double coeurs, int x, int y, double vitesse, Environnement environnement, Epee epee) {
        super(nom, coeurs, x, y, vitesse, environnement, epee);
    }

    @Override
    public void attaquer() {

    }


}