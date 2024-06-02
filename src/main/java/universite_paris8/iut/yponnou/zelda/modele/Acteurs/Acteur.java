package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.Position;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Acteur {

    private final String idActeur;
    private static int incremente = 0;
    private final String nom;
    private Position position;
    private IntegerProperty pv;
    private final double vitesse;
    private final Rectangle hitbox;

    public Acteur(String nom, double x, double y, int pv, double vitesse, Environnement environnement) {
        this.nom = nom;
        position = new Position(x,y,environnement);
        this.pv = new SimpleIntegerProperty(pv);
        this.vitesse = vitesse;
        idActeur = "A"+incremente++;
        hitbox = new Rectangle(x, y, Constante.TAILLECASEX, Constante.TAILLECASEY);
    }

    public String getId() {
        return idActeur;
    }
    public String getNom() {
        return nom;
    }

    public Position getPosition() {
        return position;
    }

    public void setX(double x) {
        position.setX(x);
        hitbox.setX(x);
    }
    public void setY(double y) {
        position.setY(y);
        hitbox.setY(y);
    }

    public int getPv() {
        return pv.getValue();
    }
    public void setPv(int pv) {
        this.pv.setValue(pv);
    }
    public IntegerProperty pvProperty() {
        return pv;
    }

    public final double getVitesse(){
        return vitesse;
    }

    public void deplacement(int dx, int dy){
        double prochainX = position.getX()+dx*vitesse;
        double prochainY = position.getY()+dy*vitesse;

        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, Constante.TAILLECASEX, Constante.TAILLECASEY);

        if (position.getEnv().dansMap(prochainX, prochainY) && !collisionAvecObstacle(futureHitbox)) {
            setX(prochainX);
            setY(prochainY);
        }
    }

    public boolean collisionAvecObstacle(Rectangle futurHitbox) {
        // Calcul des positions des quatre coins de la hitbox
        double x = futurHitbox.getX();
        double y = futurHitbox.getY();
        double width = futurHitbox.getWidth();
        double height = futurHitbox.getHeight();

        // Coordonnées des coins de la hitbox en terme de cases
        int tableauXHG = (int) (x / Constante.TAILLECASEX);
        int tableauYHG = (int) (y / Constante.TAILLECASEY);
        int tableauXHD = (int) ((x + width-1) / Constante.TAILLECASEX);
        int tableauYBG = (int) ((y + height-1) / Constante.TAILLECASEY);

        // Vérification des collisions avec les obstacles
        int[][] map = position.getEnv().getMap().getTabNum();
        return map[tableauYHG][tableauXHG] == 1 || map[tableauYHG][tableauXHD] == 1 || map[tableauYBG][tableauXHG] == 1 || map[tableauYBG][tableauXHD] == 1; // Collision avec un obstacle
    }

    abstract void parler();
}
