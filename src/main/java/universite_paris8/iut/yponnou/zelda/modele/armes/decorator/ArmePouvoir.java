package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class ArmePouvoir extends Arme {
    private Arme arme;


    public ArmePouvoir(Arme arme) {
        super(arme.getPosition().getX(), arme.getPosition().getY(), arme.getEnvironnement(), arme.getPtsDegats());
        this.arme = arme;
    }

    public Arme getArme() {
        return arme;
    }
}
