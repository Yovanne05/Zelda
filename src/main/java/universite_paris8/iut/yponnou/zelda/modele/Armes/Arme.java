package universite_paris8.iut.yponnou.zelda.modele.Armes;

public class Arme{
    private String nom;
    private int ptsDegats;
    private int portee;

    public Arme(String nom, int ptsDegats, int portee) {
        this.nom = nom;
        this.ptsDegats = ptsDegats;
        this.portee = portee;
    }

    public String getNom() {
        return nom;
    }
    public int getPtsDegats() {
        return ptsDegats;
    }
    public int getPortee() {
        return portee;
    }
}