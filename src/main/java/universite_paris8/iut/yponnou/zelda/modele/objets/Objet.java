package universite_paris8.iut.yponnou.zelda.modele.objets;

import javafx.scene.Node;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public abstract class Objet{

    private String id;
    protected static int incremente = 0;
    private Position position;
    private Environnement environnement;

    public Objet(double x, double y, Environnement environnement) {
        position = new Position(x,y);
        this.environnement=environnement;
        id = "Ob"+incremente++;
    }

    public static int getIncremente() {
        return incremente;
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

    public boolean touche(Ennemi ennemi) {
        double ennemiX = ennemi.getPosition().getX();
        double ennemiY = ennemi.getPosition().getY();

        return (getPosition().getX() >= ennemiX && getPosition().getX() <= ennemiX + TAILLE50) && (getPosition().getY() >= ennemiY && getPosition().getY() <= ennemiY + TAILLE50);
    }
    
}
