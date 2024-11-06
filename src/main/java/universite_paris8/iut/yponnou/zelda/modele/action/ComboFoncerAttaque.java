package universite_paris8.iut.yponnou.zelda.modele.action;

public class ComboFoncerAttaque extends ActionComposite{
    public ComboFoncerAttaque() {
        ajouterAction(new FoncerAction());
        ajouterAction(new AttaqueNormal());
    }
}
