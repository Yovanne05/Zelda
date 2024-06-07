package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public abstract class Arme extends Objet {
    private String nom;
    private Environnement environnement;

    public Arme(String nom, double x, double y, Environnement environnement) {
        super(x, y, environnement);
        this.nom=nom;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public String getNom() {
        return nom;
    }
    public abstract int utiliser();
}