package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class ArmeMelee extends Arme{

    public ArmeMelee(String nom, double x, double y, Environnement env, int ptsDegats, int portee) {
        super(nom, x, y, env, ptsDegats, portee);
    }
}
