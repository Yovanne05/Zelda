package universite_paris8.iut.yponnou.zelda.modele.environnements;

public interface CreationEnv {

    /**
     * Interface qui définit la méthode de création d'un environnement.
     * Chaque type d'environnement (par exemple, un donjon, un village) doit implémenter cette interface
     * pour fournir sa propre logique d'initialisation.
     */

    void creationEnvironnement(Environnement environnement);

}
