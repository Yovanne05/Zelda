package universite_paris8.iut.yponnou.zelda.modele.armes.strategy;

public interface ComportementArme {

    /**
     * Interface représentant le comportement d'une arme.
     * Chaque type d'arme (mêlée ou projectile) doit implémenter cette interface
     * afin de définir comment elle inflige des dégâts lors de son utilisation.
     */

    void infligeDegat();

}
