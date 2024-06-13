package universite_paris8.iut.yponnou.zelda.modele.Acteurs;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Boss extends Ennemi {

    public Boss(double x, double y, Environnement environnement, int dx, int dy, Arme arme) {
        super("Boss", x, y, 300, 0.04, environnement, dx, dy, arme);
    }

    @Override
    public void attaquer() {
        long tempsActuel = System.currentTimeMillis();
        if (this.getArme() instanceof ArmeDistance) {
            Fleche f = new Fleche(getPosition().getX(), getPosition().getY(), getPosition().getEnv(), getDx(), getDy());
            ((ArmeDistance) this.getArme()).setProjectile(f);
            System.out.println("j'attaque");
            ((ArmeDistance) this.getArme()).utiliser();

        }else{
            if (tempsActuel - this.getDerniereAttaque() >= 250) {
                Hero hero = verifHeroProx(100);
                if (hero != null) {
                    hero.seFaitAttquer(((ArmeMelee) this.getArme()).getPtsDegats());
                    this.setDerniereAttaque(tempsActuel);
                }
            }
        }

    }

    @Override
    public void deplacementEnnemi() {
        Hero hero = verifHeroProx(350);
        if (hero != null) {
            foncerSurHero(hero);
            attaquer();
        } else {

        }
    }

    private void foncerSurHero(Hero hero) {
        double heroX = hero.getPosition().getX();
        double heroY = hero.getPosition().getY();
        this.deplacerVers(heroX, heroY);
    }
}
