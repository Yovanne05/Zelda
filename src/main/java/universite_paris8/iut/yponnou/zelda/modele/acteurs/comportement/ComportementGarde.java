package universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;

public class ComportementGarde implements ComportementEnnemi {

    /**
     * Implémente le comportement spécifique d'un Garde.
     * Le Garde se déplace normalement et attaque le héros s'il est très proche.
     */


    @Override
    public void deplacer(Ennemi ennemi) {
        ennemi.deplacementNormal();
    }

    @Override
    public void attaquer(Ennemi ennemi) {
        if(ennemi.verifHeroProx(70)){
            ennemi.attaquerHero();
        }
    }
}