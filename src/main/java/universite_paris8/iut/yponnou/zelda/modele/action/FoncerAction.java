package universite_paris8.iut.yponnou.zelda.modele.action;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public class FoncerAction implements Action {

    /**
     * La classe FoncerAction représente l'action de foncer dans une direction donnée avec un certain facteur de vitesse.
     * Elle implémente l'interface `Action` et modifie la position du héros en fonction de sa direction.
     */

    private final double facteurVitesse;

    public FoncerAction() {
        this.facteurVitesse = 80;
    }

    @Override
    public void executer(Hero hero) {
        double nouvelleX = hero.getPosition().getX() + hero.getDirection().getDx() * facteurVitesse;
        double nouvelleY = hero.getPosition().getY() + hero.getDirection().getDy() * facteurVitesse;

        Hitbox futureHitbox = new Hitbox(nouvelleX, nouvelleY, TAILLE50, TAILLE50);

        if (!hero.collisionAvecObstacle(futureHitbox) && !hero.collisionAvecActeur(futureHitbox)) {
            hero.getPosition().setX(nouvelleX);
            hero.getPosition().setY(nouvelleY);
        }
    }
}

