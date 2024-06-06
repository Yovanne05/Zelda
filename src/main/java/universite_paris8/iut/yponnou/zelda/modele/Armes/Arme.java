package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Arme{
    private String nom;
    private Environnement environnement;

    public Arme(String nom, Environnement environnement) {
        this.nom = nom;
        this.environnement=environnement;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public String getNom() {
        return nom;
    }
    public abstract double utiliser();
}