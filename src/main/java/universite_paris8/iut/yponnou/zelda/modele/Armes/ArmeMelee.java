package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class ArmeMelee extends Arme{
    private int ptsDegats;
    public ArmeMelee(String nom,double x, double y, int ptsDegats, Environnement environnement) {
        super(nom,x, y,environnement);
        this.ptsDegats=ptsDegats;
    }
    public abstract int utiliser();

    public int getPtsDegats() {
        return ptsDegats;
    }
}

