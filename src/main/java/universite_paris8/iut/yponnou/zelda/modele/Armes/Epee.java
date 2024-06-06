package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Epee extends ArmeMelee{


    public Epee(Environnement environnement) {
        super("Epee", 1,environnement);
    }

    @Override
    public double utiliser() {

        return this.getPtsDegats();
    }

}
