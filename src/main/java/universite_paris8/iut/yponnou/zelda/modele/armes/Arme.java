
package universite_paris8.iut.yponnou.zelda.modele.armes;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public abstract class Arme extends Objet implements UtilisationArme {

    private int ptsDegats;
    private Guerrier proprietaire;
    private double portee;

    public Arme(double x, double y, Environnement environnement, int ptsDegats, Guerrier proprietaire, double portee) {
        super(x, y, environnement);
        this.ptsDegats = ptsDegats;
        this.proprietaire = proprietaire;
        this.portee = portee;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }

    public void setPtsDegats(int ptsDegat) {
        this.ptsDegats = ptsDegat;
    }

    public Guerrier getProprietaire() {
        return proprietaire;
    }

    public double getPortee() {
        return portee;
    }

    public void setPortee(double portee) {
        this.portee = portee;
    }

    public void setProprietaire(Guerrier proprietaire) {
        this.proprietaire = proprietaire;
    }
}
