package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement.ComportementEnnemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class Ennemi extends Guerrier {
    /**
     * Classe abstraite représentant un Ennemi, héritant de la classe Guerrier.
     * Elle gère les comportements d'attaque, de déplacement et d'interaction avec le héros
     */

    private long derniereAttaque;
    private ComportementEnnemi comportementEnnemi;

    public Ennemi(double x, double y, Environnement environnement, double vitesse, Direction direction, Arme arme, int pv, ComportementEnnemi comportementEnnemi) {
        super(x, y, environnement, vitesse, direction, arme, pv);
        this.derniereAttaque = 0;
        this.comportementEnnemi = comportementEnnemi;
    }

    public void attaquerHero() {
        long tempsActuel = System.currentTimeMillis();
        if (tempsActuel - this.getDerniereAttaque() >= 250) {
            getArme().utiliserArme();
            this.setDerniereAttaque(tempsActuel);
        }
    }

    public boolean verifHeroProx(double distanceSeuil) {
        Hero h = getEnvironnement().getHero();
        if (estProcheDeActeur(h, distanceSeuil)) {
            return true;
        }
        return false;
    }

    public long getDerniereAttaque() {
        return derniereAttaque;
    }

    public void setDerniereAttaque(long derniereAttaque) {
        this.derniereAttaque = derniereAttaque;
    }

    public void deplacement(){
        comportementEnnemi.deplacer(this);
        comportementEnnemi.attaquer(this);
    }

    public void deplacementNormal(){
        super.deplacement();
    }

}