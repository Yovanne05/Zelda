
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
public class Epee extends ArmeMelee{

    public Epee(double x, double y,Environnement environnement) {
        super(x,y,5,environnement);
    }

    public String nom(){
        return "Epee";
    }

}
