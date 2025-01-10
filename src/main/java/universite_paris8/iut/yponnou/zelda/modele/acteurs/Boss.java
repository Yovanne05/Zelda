package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement.ComportementBoss;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Boss extends Ennemi {

    /**
     * Représente un Boss, un type spécifique d'ennemi, héritant de la classe Ennemi.
     * Il a un comportement unique de foncer directement sur le héros.
     */

    public Boss(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 2, direction, arme, 360, new ComportementBoss());
    }

    public void foncerSurHero() {
        this.deplacerVers(getEnvironnement().getHero().getPosition());
    }
}