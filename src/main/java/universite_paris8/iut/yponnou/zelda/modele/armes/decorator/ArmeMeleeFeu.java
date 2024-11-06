package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;

public class ArmeMeleeFeu extends ArmePouvoir{
    private static final int BONUS_DEGATS = 3;

    public ArmeMeleeFeu(ArmeMelee arme) {
        super(arme);
    }

    @Override
    public void utiliserArme() {
        appliquerBonus(BONUS_DEGATS);
        getArme().utiliserArme();
        reinitialiserDegats();
    }
}
