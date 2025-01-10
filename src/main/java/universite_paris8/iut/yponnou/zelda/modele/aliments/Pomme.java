package universite_paris8.iut.yponnou.zelda.modele.aliments;


import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Pomme extends Nourriture {

    /**
     * La classe Pomme représente un objet de nourriture spécifique dans le jeu.
     * Lorsqu'un héros ramasse cette pomme, il reçoit un gain de points de vie de 5 PV lorsqu'il la mange.
     */

    public Pomme(double x, double y, Environnement environnement) {
        super(x, y, environnement, 5);
    }
    public String nom(){
        return "Ponmme";
    }
}
