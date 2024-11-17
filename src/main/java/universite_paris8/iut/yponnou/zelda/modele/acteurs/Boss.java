package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Boss extends Ennemi {

    public Boss(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 2, direction, arme, 360);
    }

    @Override
    protected double getDistanceSeuil() {
        return 350;
    }

    @Override
    protected void comportementProcheHero(Hero hero) {
        foncerSurHero(hero);
        Hero h = verifHeroProx(200);
        if(h!=null){
            attaquerHero();
        }

    }

    @Override
    protected void comportementHorsProximite() {
    }

    @Override
    protected void effectuerDeplacement() {
    }

    private void foncerSurHero(Hero hero) {
        this.deplacerVers(hero.getPosition());
    }
}