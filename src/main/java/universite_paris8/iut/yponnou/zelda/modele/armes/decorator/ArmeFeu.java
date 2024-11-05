package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;

public class ArmeFeu extends ArmePouvoir {
    public ArmeFeu(Arme arme) {
        super(arme);
    }

    @Override
    public void utiliserArme() {
        appliquerFeu();
        getArme().utiliserArme();
    }

    public void appliquerFeu(){
        setPtsDegats(getPtsDegats() +3);
    }
}
