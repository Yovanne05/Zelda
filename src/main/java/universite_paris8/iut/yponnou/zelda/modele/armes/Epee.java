
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
public class Epee extends ArmeMelee {

    /**
     * Classe représentant une épée, une arme de mêlée dans le jeu.
     * L'épée inflige des dégâts de 5 lors d'une attaque.
     */

    public Epee(double x, double y, Environnement environnement, Guerrier proprietaire, double portee) {
        super(x, y, 5, environnement, proprietaire, portee);
    }


    @Override
    public void utiliserArme() {
        getComportementAttaque().infligeDegat();
    }

}

