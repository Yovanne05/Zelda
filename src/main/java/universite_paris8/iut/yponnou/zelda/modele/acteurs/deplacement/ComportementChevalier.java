package universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;

public class ComportementChevalier implements ComportementEnnemi {
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
