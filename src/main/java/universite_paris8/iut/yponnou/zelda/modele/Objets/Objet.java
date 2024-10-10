package universite_paris8.iut.yponnou.zelda.modele.Objets;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

public abstract class Objet {

    private String id;
    private static int incremente = 0;
    private Position position;
    private Environnement environnement;

    public Objet(double x, double y, Environnement environnement) {
        position = new Position(x,y);
        this.environnement=environnement;
        id = "Ob"+incremente++;
    }

    public Environnement getEnvironnement() {
        return environnement;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }
    
}
