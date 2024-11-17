package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeDistance;

public class ArmeDistanceFeu extends ArmePouvoir {
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