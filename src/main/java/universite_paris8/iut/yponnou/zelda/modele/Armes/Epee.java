package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Epee extends ArmeMelee{

    public Epee(double x, double y,Environnement environnement) {
        super("Epee",x,y,1,environnement);
    }

    @Override
    public String toString() {
        return null;
    }

}
