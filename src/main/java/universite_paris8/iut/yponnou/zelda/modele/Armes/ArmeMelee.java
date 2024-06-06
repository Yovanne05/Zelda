package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class ArmeMelee extends Arme{
    private double ptsDegats;
    public ArmeMelee(String nom, double ptsDegats, Environnement environnement) {
        super(nom,environnement);
        this.ptsDegats=ptsDegats;
    }
    public abstract double utiliser();

    public double getPtsDegats() {
        return ptsDegats;
    }
}

