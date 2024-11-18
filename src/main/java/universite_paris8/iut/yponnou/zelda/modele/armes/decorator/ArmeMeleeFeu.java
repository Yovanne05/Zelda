package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;

public class ArmeMeleeFeu extends ArmePouvoir{

    /**
     * Décorateur pour une arme de mêlée ajoutant un bonus de dégâts de type feu.
     * Ce décorateur applique un bonus aux dégâts de l'arme lorsqu'elle est utilisée.
     */

    private static final int BONUS_DEGATS = 4;

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
