package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.scene.shape.Rectangle;

public class Hitbox {

    private Rectangle hitbox;
    private double x;
    private double y;
    private int tailleX;
    private int tailleY;

    public Hitbox(double x, double y, int tailleX, int tailleY) {
        this.x = x;
        this.y = y;
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.hitbox = new Rectangle(x, y, tailleX, tailleY);
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

    public double hitboxX() {
        return x;
    }

    public double hitboxY() {
        return y;
    }

    public int width(){
        return tailleX;
    }

    public int height(){
        return tailleY;
    }

}
