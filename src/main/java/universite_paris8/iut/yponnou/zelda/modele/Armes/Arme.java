package universite_paris8.iut.yponnou.zelda.modele.Armes;

public class Arme{
    private String nom;
    private double ptsDegats;
    private int portee;

    public Arme(String nom, double ptsDegats, int portee) {
        this.nom = nom;
        this.ptsDegats = ptsDegats;
        this.portee = portee;
    }

    public String getNom() {
        return nom;
    }
    public double getPtsDegats() {
        return ptsDegats;
    }
    public int getPortee() {
        return portee;
    }
}