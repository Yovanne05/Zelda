package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Position;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

import static universite_paris8.iut.yponnou.zelda.Constante.*;

public class Acteur {

    private final String id;
    private static int incremente = 0;
    private final String nom;
    private final Position position;
    private String direction;
    private final double vitesse;
    private final IntegerProperty pv;
    private final Rectangle hitbox;
    private int dx;
    private int dy;

    public Acteur(String nom, double x, double y, int pv, double vitesse, Environnement environnement, int dx, int dy) {
        this.nom = nom;
        position = new Position(x,y,environnement);
        this.pv = new SimpleIntegerProperty(pv);
        this.vitesse = vitesse;
        id = "A"+incremente++;
        hitbox = new Rectangle(x, y, TAILLE50, TAILLE50);
        direction = "down";
        this.dx=dx;
        this.dy=dy;
        hitbox.xProperty().bind(this.getPosition().xProperty());
        hitbox.yProperty().bind(this.getPosition().yProperty());
    }

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public Position getPosition() {
        return position;
    }

    public void setX(double x) {
        position.setX(x);
    }
    public void setY(double y) {
        position.setY(y);
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

    public void subitDegats(int degats){
        setPv(getPv()-degats);
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

    public void deplacement() {
        //System.out.println("deplace");
        double prochainX = getPosition().getX() + (this.dx * this.vitesse) * TAILLE50;
        double prochainY = getPosition().getY() + (this.dy * this.vitesse) * TAILLE50;

        // Création de la nouvelle hitbox après déplacement
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, TAILLE50, TAILLE50);
        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox) && getPosition().getEnv().dansMap(prochainX,prochainY)) {
            setX(prochainX);
            setY(prochainY);
        }
    }


    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean collisionAvecObstacle(Rectangle futurHitbox) {
        // Calcul des positions des quatre coins de la hitbox
        double x = futurHitbox.getX();
        double y = futurHitbox.getY();
        double width = futurHitbox.getWidth();
        double height = futurHitbox.getHeight();

        // Coordonnées des coins de la hitbox en termes de cases
        int tableauXHG = (int) (x / TAILLE50);
        int tableauYHG = (int) (y / TAILLE50);
        int tableauXHD = (int) ((x + width - 1) / TAILLE50);
        int tableauYBG = (int) ((y + height - 1) / TAILLE50);

        // Vérification des bordures de la carte
        if (tableauXHG < 0 || tableauYHG < 0 || tableauXHD >= position.getEnv().getMap().getLargeur() || tableauYBG >= position.getEnv().getMap().getHauteur())
            return true; // Collision avec la bordure de la carte
        // Vérification des collisions avec les obstacles
        int[][] map = position.getEnv().getMap().getTabNum();

        return map[tableauYHG][tableauXHG] > 20 || map[tableauYHG][tableauXHD] > 20 || map[tableauYBG][tableauXHG] > 20 || map[tableauYBG][tableauXHD] > 20;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }


    private boolean collisionAvecActeur(Rectangle futureHitbox) {
        for (Acteur acteur : getPosition().getEnv().acteursProperty()) {
            Rectangle ennemiHitbox = acteur.getHitbox();
            //getBoundsInParent  retourne un objet de type Bounds représentant les coordonnées du rectangle
            //intersects elle vérifie si les deux ensembles de limites (bounds) se chevauchent
            if (futureHitbox.getBoundsInParent().intersects(ennemiHitbox.getBoundsInParent()) && !this.getId().equals(acteur.getId())) {
                return true;
            }
        }
        return false;
    }

    public void seFaitAttaquer(int pts){
        int nvPv =getPv()-pts;
        if(nvPv>0){
            setPv(nvPv);
        }else {
            setPv(0);
            getPosition().getEnv().enleverActeur(this);
        }
    }
    @Override
    public String toString() {
        return "Acteur{" +
                "idActeur='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", coeurs=" + pv +
                ", v=" + vitesse +
                ", env=" + position.getEnv() +
                ", x=" + position.getX() +
                ", y=" + position.getY() +
                ", hitbox=" + hitbox +
                '}';
    }


}