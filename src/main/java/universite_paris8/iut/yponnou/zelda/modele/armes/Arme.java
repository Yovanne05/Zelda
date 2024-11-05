
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public abstract class Arme extends Objet implements UtilisationArme {

    private int ptsDegats;

    public Arme(double x, double y, Environnement environnement, int ptsDegats) {
        super(x, y, environnement);
        this.ptsDegats = ptsDegats;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }

    public void setPtsDegats(int ptsDegat) {
        this.ptsDegats = ptsDegat;
    }
}
