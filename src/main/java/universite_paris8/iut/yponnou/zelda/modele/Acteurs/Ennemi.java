package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

import java.util.LinkedList;
import java.util.Queue;

import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEX;
import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEY;


public abstract class Ennemi extends Guerrier {

    private long derniereAttaque;

    public Ennemi(String nom, double x, double y, int pv, double vitesse, Environnement environnement, int dx, int dy, Arme arme) {
        super(nom, x, y, pv, vitesse, environnement, dx, dy, arme);
        this.derniereAttaque = 0;
    }

    public Hero verifHeroProx(double dist) {
        for (Acteur a : this.getPosition().getEnv().getLstActeurs()) {
            if ((Math.abs(getPosition().getX() - a.getPosition().getX()) <= dist && Math.abs(getPosition().getY() - a.getPosition().getY()) <= dist)) {
                if (a instanceof Hero) {
                    return (Hero) a;
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