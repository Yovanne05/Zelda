
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.armes.strategy.ComportementArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.strategy.ComportementMelee;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
public abstract class ArmeMelee extends Arme{

    /**
     * Classe abstraite représentant une arme de type mêlée.
     * Cette classe définit le comportement d'attaque d'une arme de mêlée, qui inflige des dégâts directement.
     */

    private ComportementArme comportementAttaque;

    public ArmeMelee(double x, double y, int ptsDegats, Environnement environnement, Guerrier proprietaire,double portee) {
        super(x, y, environnement, ptsDegats, proprietaire,portee);
        this.comportementAttaque = new ComportementMelee(this);
    }

    public void setComportementAttaque(ComportementArme comportementAttaque) {
        this.comportementAttaque = comportementAttaque;
    }

    public ComportementArme getComportementAttaque() {
        return comportementAttaque;
    }
}
