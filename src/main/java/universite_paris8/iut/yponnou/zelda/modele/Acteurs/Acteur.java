package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
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

    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
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

    public Position getPosition() {
        return position;
    }

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

    public final double getVitesse(){
        return vitesse;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }


    public void deplacement() {
        //System.out.println("deplace");
        double prochainX = getPosition().getX() + (this.dx * this.vitesse) * TAILLE50;
        double prochainY = getPosition().getY() + (this.dy * this.vitesse) * TAILLE50;

        // Création de la nouvelle hitbox après déplacement
        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, TAILLE50, TAILLE50);
        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            position.setX(prochainX);
            position.setY(prochainY);
        }
    }

    public void deplacerVers(double cibleX, double cibleY) {
        // diff X et Y entre pos actuelle acteur et pos cible
        double diffX = cibleX - this.getPosition().getX();
        double diffY = cibleY - this.getPosition().getY();

        //Pythagore pour la distance : entre la position actuelle de l'acteur et la position cible
        double distance = Math.sqrt(diffX * diffX + diffY * diffY);

        if (distance > 0) {
            double directionX = diffX / distance;
            double directionY = diffY / distance;

            // Nouvelle pos
            double prochainX = this.getPosition().getX() + directionX * this.getVitesse() * TAILLE50;
            double prochainY = this.getPosition().getY() + directionY * this.getVitesse() * TAILLE50;

            Rectangle futureHitbox = new Rectangle(prochainX, prochainY, TAILLE50, TAILLE50);

            if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
                position.setX(prochainX);
                position.setY(prochainY);
            }
        }
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

    public boolean collisionAvecActeur(Rectangle futureHitbox) {
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

    public void subitDegats(int degats){
        setPv(getPv()-degats);
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