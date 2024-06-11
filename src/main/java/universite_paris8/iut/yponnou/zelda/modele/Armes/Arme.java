package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Arme extends Objet {
    private String nom;

    public Arme(String nom, double x, double y, Environnement environnement) {
        super(x, y, environnement);
        this.nom=nom;
    }


    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return null;
    }

}