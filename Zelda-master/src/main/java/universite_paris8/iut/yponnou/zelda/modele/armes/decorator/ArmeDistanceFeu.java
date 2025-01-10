package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeDistance;

public class ArmeDistanceFeu extends ArmePouvoir {

    /**
     * Décorateur pour une arme à distance ajoutant un bonus de dégâts de type feu.
     * Ce décorateur applique un bonus aux dégâts de l'arme à distance lorsqu'elle est utilisée.
     */

    private static final int BONUS_DEGATS = 7;

    public ArmeDistanceFeu(ArmeDistance arme) {
        super(arme);
    }

    @Override
    public void utiliserArme() {
        appliquerBonus(BONUS_DEGATS);
        getArme().utiliserArme();
        reinitialiserDegats();
    }
}