package universite_paris8.iut.yponnou.zelda.modele.Aliments;


import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Pomme extends Nourriture {

    public Pomme(double x, double y, Environnement environnement) {
        super(x, y, environnement, 5);
    }
    public String nom(){
        return "Ponmme";
    }
}
