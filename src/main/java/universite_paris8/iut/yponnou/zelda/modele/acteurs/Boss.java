package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Boss extends Ennemi {

    public Boss(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 0.04, direction, arme, 360);
    }

    @Override
    public void deplacementEnnemi() {
        Hero hero = verifHeroProx(350);
        if (hero != null) {
            foncerSurHero(hero);
            verifierEtAttaquer(150);
        }
    }

    public String nom() {
        return "Boss";
    }

    private void foncerSurHero(Hero hero) {
        this.deplacerVers(hero.getPosition());
    }
}