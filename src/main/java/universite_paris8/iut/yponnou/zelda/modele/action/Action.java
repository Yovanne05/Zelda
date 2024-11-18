package universite_paris8.iut.yponnou.zelda.modele.action;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

/**
 * Interface Action représentant une action qu'un héros peut exécuter.
 * Les classes implémentant cette interface définissent le comportement de l'action via la méthode `executer`.
 */


public interface Action {
    void executer(Hero hero);
}