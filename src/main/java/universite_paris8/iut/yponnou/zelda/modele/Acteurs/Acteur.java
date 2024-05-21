package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;


import java.util.ArrayList;

public abstract class Acteur {

    private String idActeur;
    private static int incremente = 0;
    private String nom;
    private double coeurs;
    private double v;
    private Environnement env;
    private DoubleProperty x;
    private DoubleProperty y;
    private Rectangle hitbox;

    public Acteur(String nom, double coeurs, double x, double y, double vitesse, Environnement environnement) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.nom = nom;
        this.coeurs = coeurs;
        v = vitesse;
        this.env = environnement;
        idActeur = "Acteur-" + incremente++;
        hitbox = new Rectangle(x, y, Constante.getTailleCaseX(), Constante.getTailleCaseY());
    }

    public String getId() {
        return idActeur;
    }

    public String getNom() {
        return nom;
    }

    public double getCoeurs() {
        return coeurs;
    }

    public void setCoeurs(double coeurs) {
        this.coeurs = coeurs;
    }

    public double getX() {
        return x.getValue();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public double getY() {
        return y.getValue();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setX(double x) {
        this.x.setValue(x);
        hitbox.setX(x);
    }

    public void setY(double y) {
        this.y.setValue(y);
        hitbox.setY(y);
    }



    public final double getVitesse() {
        return v;
    }

    public Environnement getEnvironnement() {
        return env;
    }

    public void deplacement(double dx, double dy) {
        double prochainX = getX() + (dx*this.v) * Constante.getTailleCaseX();
        double prochainY = getY() + (dy*this.v)  * Constante.getTailleCaseY();

        // Création de la nouvelle hitbox après déplacement
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, Constante.getTailleCaseX(), Constante.getTailleCaseY());

        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecEnnemi(futureHitbox)) {
            setX(prochainX);
            setY(prochainY);
        }
    }

    private boolean collisionAvecObstacle(Rectangle futureHitbox) {
        // Calcul des positions des quatre coins de la hitbox
        double x = futureHitbox.getX();
        double y = futureHitbox.getY();
        double width = futureHitbox.getWidth();
        double height = futureHitbox.getHeight();

        // Coordonnées des coins de la hitbox en termes de cases
        int tableauXHG = (int) (x / Constante.getTailleCaseX());
        int tableauYHG = (int) (y / Constante.getTailleCaseY());
        int tableauXHD = (int) ((x + width-1) / Constante.getTailleCaseX());
        int tableauYHD = tableauYHG;
        int tableauXBG = tableauXHG;
        int tableauYBG = (int) ((y + height-1) / Constante.getTailleCaseY());
        int tableauXBD = tableauXHD;
        int tableauYBD = tableauYBG;

        // Vérification des bordures de la carte
        if (tableauXHG < 0 || tableauYHG < 0 || tableauXHD >= env.getMap().getLargeur() || tableauYBG >= env.getMap().getHauteur()) {
            return true; // Collision avec la bordure de la carte
        }

        // Vérification des collisions avec les obstacles
        int[][] map = env.getMap().getTabNum();
        if (map[tableauYHG][tableauXHG] == 1 || map[tableauYHD][tableauXHD] == 1 || map[tableauYBG][tableauXBG] == 1 || map[tableauYBD][tableauXBD] == 1) {
            return true; // Collision avec un obstacle
        }

        return false;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    private boolean collisionAvecEnnemi(Rectangle futureHitbox) {
        ArrayList<Acteur> lstActeurs = env.getLstActeurs();

        for (Acteur acteur : lstActeurs) {
            if (acteur != this && acteur instanceof Garde) {
                Rectangle ennemiHitbox = acteur.getHitbox();
                //getBoundsInParent  retourne un objet de type Bounds représentant les coordonnées du rectangle
                //intersects elle vérifie si les deux ensembles de limites (bounds) se chevauchent
                if (futureHitbox.getBoundsInParent().intersects(ennemiHitbox.getBoundsInParent())) {
                    return true;
                }
            }
        }
        return false;
    }



}