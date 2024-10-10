package universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion;

import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public class Hitbox {

    private Rectangle hitbox;
    private int tailleX;
    private int tailleY;

    public Hitbox(double x, double y, int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.hitbox = new Rectangle(x, y, tailleX, tailleY);
    }

    public int[] calculerCoinsHitbox() {
        double x = hitboxX();
        double y = hitboxY();
        double width = width();
        double height = height();

        int coinHautGaucheX = (int) (x / TAILLE50);
        int coinHautGaucheY = (int) (y / TAILLE50);
        int coinHautDroitX = (int) ((x + width - 1) / TAILLE50);
        int coinBasGaucheY = (int) ((y + height - 1) / TAILLE50);

        return new int[] { coinHautGaucheX, coinHautGaucheY, coinHautDroitX, coinBasGaucheY };
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public DoubleProperty xProperty() {
        return hitbox.xProperty();
    }

    public DoubleProperty yProperty() {
        return hitbox.yProperty();
    }

    public double hitboxX(){
        return hitbox.getX();
    }

    public double hitboxY(){
        return hitbox.getY();
    }

    public int width(){
        return tailleX;
    }

    public int height(){
        return tailleY;
    }

}
