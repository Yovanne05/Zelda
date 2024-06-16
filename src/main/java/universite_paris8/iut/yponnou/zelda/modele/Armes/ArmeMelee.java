
package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class ArmeMelee extends Arme{
    private int ptsDegats;
    public ArmeMelee(String nom,double x, double y, int ptsDegats, Environnement environnement) {
        super(nom,x, y,environnement);
        this.ptsDegats=ptsDegats;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }
    public void setPtsDegats(int ptsDegats) {
        this.ptsDegats = ptsDegats;
    }
}
