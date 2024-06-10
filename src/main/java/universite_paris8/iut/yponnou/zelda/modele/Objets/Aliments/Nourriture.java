package universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public abstract class Nourriture extends Objet {

    private int pv;

    public Nourriture(int x, int y, Environnement environnement, int gainPv) {
        super(x, y, environnement);
        this.pv = gainPv;
    }

    public int getPv() {
        return pv;
    }

}
