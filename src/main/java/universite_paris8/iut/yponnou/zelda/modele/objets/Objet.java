package universite_paris8.iut.yponnou.zelda.modele.objets;

import javafx.scene.Node;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public abstract class Objet{

    /**
     * La classe Objet représente un objet dans le jeu. Chaque objet a une position dans l'environnement et un identifiant unique.
     * Les objets peuvent être associés à un environnement spécifique.
     *
     * Cette classe fournit des méthodes pour obtenir et modifier la position de l'objet, ainsi que son environnement.
     * Les objets sont identifiés par un ID unique, qui est automatiquement incrémenté à chaque création d'un objet.
     */


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
