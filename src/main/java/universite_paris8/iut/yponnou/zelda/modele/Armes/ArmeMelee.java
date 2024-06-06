package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class ArmeMelee extends Arme{

    public ArmeMelee(String nom, double ptsDegats, Environnement environnement) {
        super(nom, ptsDegats,environnement);
    }
    public abstract double utiliser(int dx, int dy);
}
