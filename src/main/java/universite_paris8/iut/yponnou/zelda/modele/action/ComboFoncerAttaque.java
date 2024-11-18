package universite_paris8.iut.yponnou.zelda.modele.action;

public class ComboFoncerAttaque extends ActionComposite{

    /**
     * La classe ComboFoncerAttaque regroupe une séquence d'actions composée de l'action de foncer suivie de l'attaque normale.
     * Cette classe hérite de `ActionComposite` et ajoute les actions correspondantes au combo.
     */

    public ComboFoncerAttaque() {
        ajouterAction(new FoncerAction());
        ajouterAction(new AttaqueNormal());
    }
}
