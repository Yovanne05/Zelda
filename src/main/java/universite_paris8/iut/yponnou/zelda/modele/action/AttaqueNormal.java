package universite_paris8.iut.yponnou.zelda.modele.action;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

public class AttaqueNormal implements Action{

    /**
     * La classe AttaqueNormal représente l'action d'attaquer normalement pour le héros.
     * Elle implémente l'interface `Action` et exécute l'attaque du héros via la méthode `attaquer()`.
     */

    @Override
    public void executer(Hero hero) {
        hero.attaquer();
    }
}