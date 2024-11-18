package universite_paris8.iut.yponnou.zelda.modele.acteurs;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement.ComportementBoss;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Boss extends Ennemi {

    /**
     * La classe Boss représente un ennemi puissant dans le jeu avec un comportement agressif.
     * Le Boss détecte le héros dans un rayon de 350 unités, fonce vers lui lorsqu'il est proche,
     * et attaque si le héros est encore plus près (dans un rayon de 200 unités).
     * Ce personnage combine vitesse et agressivité pour poser un défi au joueur.
     */


    public Boss(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 2, direction, arme, 360, new ComportementBoss());
    }

    public void foncerSurHero() {
        this.deplacerVers(getEnvironnement().getHero().getPosition());
    }
}