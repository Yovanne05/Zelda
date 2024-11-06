package universite_paris8.iut.yponnou.zelda.modele.action;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

import java.util.ArrayList;
import java.util.List;

public class ActionComposite implements Action {
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