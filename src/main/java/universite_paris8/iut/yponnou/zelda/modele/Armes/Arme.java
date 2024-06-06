package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Arme{
    private String nom;
    private double ptsDegats;
    private Environnement environnement;

    public Arme(String nom, double ptsDegats, Environnement environnement) {
        this.nom = nom;
        this.ptsDegats = ptsDegats;
        this.environnement=environnement;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public String getNom() {
        return nom;
    }
    public double getPtsDegats() {
        return ptsDegats;
    }
    public abstract double utiliser(int dx, int dy);
}