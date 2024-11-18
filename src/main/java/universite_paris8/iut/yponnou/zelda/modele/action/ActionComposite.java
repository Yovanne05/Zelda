package universite_paris8.iut.yponnou.zelda.modele.action;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

import java.util.ArrayList;
import java.util.List;

public class ActionComposite implements Action {

    /**
     * La classe ActionComposite permet de regrouper plusieurs actions et de les exécuter de manière séquentielle.
     * Elle implémente l'interface `Action` et permet d'ajouter ou de supprimer des actions dans la liste.
     */

    private List<Action> actions = new ArrayList<>();

    public void ajouterAction(Action action) {
        actions.add(action);
    }

    public void supprimerAction(Action action) {
        actions.remove(action);
    }

    @Override
    public void executer(Hero hero) {
        for (Action action : actions) {
            action.executer(hero);
        }
    }
}