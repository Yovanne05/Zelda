package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;

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
        hitbox = new Rectangle(x, y, ActeurVue.getTailleCaseX(), ActeurVue.getTailleCaseY());
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
        double prochainX = getX() + dx * ActeurVue.getTailleCaseX();
        double prochainY = getY() + dy * ActeurVue.getTailleCaseY();

        // Création de la nouvelle hitbox après déplacement
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, ActeurVue.getTailleCaseX(), ActeurVue.getTailleCaseY());

        if (!collisionAvecObstacle(futureHitbox)) {
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
        int tableauXHG = (int) (x / ActeurVue.getTailleCaseX());
        int tableauYHG = (int) (y / ActeurVue.getTailleCaseY());
        int tableauXHD = (int) ((x + width-1) / ActeurVue.getTailleCaseX());
        int tableauYHD = tableauYHG;
        int tableauXBG = tableauXHG;
        int tableauYBG = (int) ((y + height-1) / ActeurVue.getTailleCaseY());
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


  /*  private boolean collisionAvecObstacle(Rectangle futureHitbox) {

        int tableauXHG, tableauYHG;
        tableauXHG = (int) (futureHitbox.getX() / ActeurVue.getTailleCaseX());
        tableauYHG = (int) (futureHitbox.getY() / ActeurVue.getTailleCaseY());
        if (tableauXHG < 0 || tableauYHG < 0 || tableauXHG >= env.getMap().getLargeur() || tableauYHG >= env.getMap().getHauteur()) {
            return true; // Collides with border
        }

        int tableauXHD, tableauYHD;
        tableauXHD = (int) (futureHitbox.getX() / ActeurVue.getTailleCaseX());
        tableauYHD = (int) (futureHitbox.getY() / ActeurVue.getTailleCaseY());

        if (tableauXHD < 0 || tableauYHD < 0 || tableauXHD >= env.getMap().getLargeur() || tableauYHD >= env.getMap().getHauteur()) {
            return true; // Collides with border
        }

        int tableauXBG, tableauYBG;
        tableauXBG = (int) (futureHitbox.getX() / ActeurVue.getTailleCaseX());
        tableauYBG = (int) (futureHitbox.getY() / ActeurVue.getTailleCaseY());

        if (tableauXBG < 0 || tableauYBG < 0 || tableauXBG >= env.getMap().getLargeur() || tableauYBG >= env.getMap().getHauteur()) {
            return true; // Collides with border
        }

        int tableauXBD, tableauYBD;
        tableauXBD = (int) (futureHitbox.getX() / ActeurVue.getTailleCaseX());
        tableauYBD = (int) (futureHitbox.getY() / ActeurVue.getTailleCaseY());

        if (tableauXBD < 0 || tableauYBD < 0 || tableauXBD >= env.getMap().getLargeur() || tableauYBD >= env.getMap().getHauteur()) {
            return true; // Collides with border
        }

        return false;
    }
    */


}
