package universite_paris8.iut.yponnou.zelda.modele.aliments;


import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

public abstract class Nourriture extends Objet {

    /**
     * Classe abstraite Nourriture représentant un type générique d'objet de nourriture.
     * Les objets dérivés de cette classe (comme des pommes, etc.) peuvent être collectés par le héros
     * et fournir des points de vie (PV) lorsqu'ils sont utilisés.
     */

    private int pv;

    public Nourriture(double x, double y, Environnement environnement, int gainPv) {
        super(x, y, environnement);
        this.pv = gainPv;
    }

    public int getPv() {
        return pv;
    }

}
