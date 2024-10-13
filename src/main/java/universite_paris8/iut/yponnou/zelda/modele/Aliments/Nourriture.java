package universite_paris8.iut.yponnou.zelda.modele.aliments;


import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

public abstract class Nourriture extends Objet {

    private int pv;

    public Nourriture(double x, double y, Environnement environnement, int gainPv) {
        super(x, y, environnement);
        this.pv = gainPv;
    }

    public int getPv() {
        return pv;
    }

}
