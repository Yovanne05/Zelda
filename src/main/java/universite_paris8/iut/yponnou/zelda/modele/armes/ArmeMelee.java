
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.armes.strategy.ComportementArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.strategy.ComportementMelee;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
public abstract class ArmeMelee extends Arme{
    private ComportementArme comportementAttaque;

    public ArmeMelee(double x, double y, int ptsDegats, Environnement environnement) {
        super(x, y, environnement, ptsDegats);
        this.comportementAttaque = new ComportementMelee(this);
    }

    public void setComportementAttaque(ComportementArme comportementAttaque) {
        this.comportementAttaque = comportementAttaque;
    }

    public ComportementArme getComportementAttaque() {
        return comportementAttaque;
    }
}
