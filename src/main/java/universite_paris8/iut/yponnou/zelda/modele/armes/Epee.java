
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
public class Epee extends ArmeMelee {


    public Epee(double x, double y, Environnement environnement, Guerrier proprietaire, double portee) {
        super(x, y, 5, environnement, proprietaire, portee);
    }


    @Override
    public void utiliserArme() {
        getComportementAttaque().infligeDegat();
    }

}

