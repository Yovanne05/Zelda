package universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;

public class ComportementGarde implements ComportementEnnemi {
    @Override
    public void deplacer(Ennemi ennemi) {
        ennemi.deplacementNormal();
    }

    @Override
    public void attaquer(Ennemi ennemi) {
        if(ennemi.verifHeroProx(60)){
            ennemi.attaquerHero();
        }
    }
}