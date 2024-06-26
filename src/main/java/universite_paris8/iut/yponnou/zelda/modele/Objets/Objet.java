package universite_paris8.iut.yponnou.zelda.modele.Objets;

import universite_paris8.iut.yponnou.zelda.utilitaire.Position;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public abstract class Objet {

    private String nom;
    private String id;
    private static int incremente = 0;
    private final Position position;

    public Objet(double x, double y, Environnement environnement) {
        position = new Position(x,y,environnement);
        id = "Ob"+incremente++;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Position getPosition() {
        return position;
    }

    public abstract String toString();
    
}
