package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

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