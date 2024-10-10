
package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
public class Epee extends ArmeMelee{

    public Epee(double x, double y,Environnement environnement) {
        super(x,y,5,environnement);
    }

    public String nom(){
        return "Epee";
    }

}
