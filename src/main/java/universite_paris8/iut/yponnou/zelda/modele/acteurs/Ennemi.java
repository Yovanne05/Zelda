package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class Ennemi extends Guerrier {

    private long derniereAttaque;

    public Ennemi(double x, double y, Environnement environnement, double vitesse, Direction direction, Arme arme, int pv) {
        super(x, y, environnement, vitesse, direction, arme, pv);
        this.derniereAttaque = 0;
    }

    public void attaquerHero() {
        long tempsActuel = System.currentTimeMillis();
        if (tempsActuel - this.getDerniereAttaque() >= 250) {
            getArme().utiliserArme();
            this.setDerniereAttaque(tempsActuel);
        }
    }

    public Hero verifHeroProx(double distanceSeuil) {
        Hero h = getEnvironnement().getHero();
        if (estProcheDeActeur(h, distanceSeuil)) {
            return h;
        }
        return null;
    }

    public long getDerniereAttaque() {
        return derniereAttaque;
    }

    public void setDerniereAttaque(long derniereAttaque) {
        this.derniereAttaque = derniereAttaque;
    }

    public final void deplacement() {
        Hero hero = verifHeroProx(getDistanceSeuil());
        if (hero != null) {
            comportementProcheHero(hero);
        } else {
            comportementHorsProximite();
        }
        effectuerDeplacement();
    }

    public void deplacementNormal(){
        super.deplacement();
    }

    protected abstract double getDistanceSeuil();
    protected abstract void comportementProcheHero(Hero hero);
    protected abstract void comportementHorsProximite();
    protected abstract void effectuerDeplacement();
}