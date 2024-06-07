package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Arme extends Objet {
    private String nom;
    private int ptsDegats;
    private int portee;

    public Arme(String nom, double x, double y, Environnement env, int ptsDegats, int portee) {
        super(x,y,env);
        this.nom = nom;
        this.ptsDegats = ptsDegats;
        this.portee = portee;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "";
    }

    public int getPtsDegats() {
        return ptsDegats;
    }
    public int getPortee() {
        return portee;
    }
}