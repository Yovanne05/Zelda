
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
public class ArmeMelee extends Arme{
    private int ptsDegats;
    public ArmeMelee(double x, double y, int ptsDegats, Environnement environnement) {
        super(x, y,environnement);
        this.ptsDegats=ptsDegats;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }
    public void setPtsDegats(int ptsDegats) {
        this.ptsDegats = ptsDegats;
    }

    public String nom(){
        return "ArmeMelee";
    }
}
