package universite_paris8.iut.yponnou.zelda.modele.Armes;

public class Arme{
    private String nom;
    private double ptsDegats;

    public Arme(String nom, double ptsDegats) {
        this.nom = nom;
        this.ptsDegats = ptsDegats;
    }

    public String getNom() {
        return nom;
    }
    public double getPtsDegats() {
        return ptsDegats;
    }
}