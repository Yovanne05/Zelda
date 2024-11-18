package universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Boss;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;

public class ComportementBoss implements ComportementEnnemi {
    @Override
    public void deplacer(Ennemi ennemi) {
        Boss boss= (Boss) ennemi;
        if (boss.verifHeroProx(350)) {
            boss.foncerSurHero();
        }
    }

    @Override
    public void attaquer(Ennemi ennemi) {
        if(ennemi.verifHeroProx(150)){
            ennemi.attaquerHero();
        }
    }

}