package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement.ComportementEnnemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class Ennemi extends Guerrier {

    /**
     * La classe Ennemi est une sous-classe de Guerrier représentant des entités adverses dans le jeu.
     * Elle gère le comportement des ennemis, notamment leur attaque envers le héros, leur déplacement
     * en fonction de leur proximité avec le héros, et leur logique d'attaque basée sur un délai.
     * Les comportements spécifiques doivent être définis dans les sous-classes via des méthodes abstraites.
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