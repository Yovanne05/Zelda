package universite_paris8.iut.yponnou.zelda.modele.Acteurs;



import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.PositionEnv;

public abstract class Ennemi extends Guerrier {

    private long derniereAttaque;

    public Ennemi(double x, double y, Environnement environnement, double vitesse, Direction direction, Arme arme, int pv) {
        super(x, y, environnement, vitesse, direction, arme, pv);
        this.derniereAttaque = 0;
    }

    public void attaquerHero() {
        long tempsActuel = System.currentTimeMillis();
        Hero hero = verifHeroProx(100);
        if (hero != null) {
            double distance = distance(hero.getPosition());
            if (distance >= 30 && getArme() instanceof ArmeDistance) {
                attaquerAvecArmeDistance(tempsActuel);
            } else {
                attaquerAvecArmeMelee(tempsActuel, hero);
            }
        }
    }

    private void attaquerAvecArmeDistance(long tempsActuel) {
        if (tempsActuel - this.getDerniereAttaque() >= 250) {
            Fleche f = new Fleche(getPosition().getX(), getPosition().getY(), getEnvironnement(), getDirection());
            ((ArmeDistance) this.getArme()).setProjectile(f);
            ((ArmeDistance) this.getArme()).utiliser();
        }
    }

    private void attaquerAvecArmeMelee(long tempsActuel, Hero hero) {
        if (tempsActuel - this.getDerniereAttaque() >= 250) {
            hero.seFaitAttaquer(((ArmeMelee) this.getArme()).getPtsDegats());
            this.setDerniereAttaque(tempsActuel);
        }
    }

    public void verifierEtAttaquer(double distanceSeuil) {
        Hero hero = verifHeroProx(distanceSeuil);
        if (hero != null) {
            attaquerHero();
        }
    }

    public Hero verifHeroProx(double distanceSeuil) {
        for (Acteur acteur : this.getEnvironnement().acteursProperty()) {
            if (acteur instanceof Hero hero) {
                if (estProcheDeActeur(hero, distanceSeuil)) {
                    return hero;
                }
            }
        }
        return null;
    }

    public long getDerniereAttaque() {
        return derniereAttaque;
    }

    public void setDerniereAttaque(long derniereAttaque) {
        this.derniereAttaque = derniereAttaque;
    }

    public abstract void deplacementEnnemi();
}