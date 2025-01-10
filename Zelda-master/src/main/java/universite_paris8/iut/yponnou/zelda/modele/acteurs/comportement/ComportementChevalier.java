package universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Chevalier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;

public class ComportementChevalier implements ComportementEnnemi {

    /**
     * Implémente le comportement spécifique d'un Chevalier.
     * Le Chevalier change de direction après un certain nombre de pas et attaque si le héros est proche.
     */

    @Override
    public void deplacer(Ennemi ennemi) {
        Chevalier chevalier = (Chevalier) ennemi;
        chevalier.changementDirectionSiPossible();
        ennemi.deplacementNormal();
    }

    @Override
    public void attaquer(Ennemi ennemi) {
        if(ennemi.verifHeroProx(100)){
            ennemi.attaquerHero();
        }
    }
}
