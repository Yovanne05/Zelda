package universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion;

import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public class Hitbox {

    /**
     * La classe Hitbox est définie par un rectangle avec des coordonnées et une taille, et permet de calculer les coins de cette zone
     * ainsi que de manipuler sa position dans l'espace.
     *
     * La taille de la hitbox est mesurée en pixels et les coins sont retournés dans une échelle normalisée
     * par rapport à une constante (TAILLE50) utilisée dans le jeu.
     */

    private Rectangle hitbox;
    private int tailleX;
    private int tailleY;

    public Hitbox(double x, double y, int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.hitbox = new Rectangle(x, y, tailleX, tailleY);
    }

    public double[] calculerCoinsHitbox() {
        double x = hitboxX();
        double y = hitboxY();
        double width = width();
        double height = height();

        double coinHautGaucheX =  (x / TAILLE50);
        double coinHautGaucheY = (y / TAILLE50);
        double coinHautDroitX = ((x + width - 1) / TAILLE50);
        double coinBasGaucheY = ((y + height - 1) / TAILLE50);

        return new double[] { coinHautGaucheX, coinHautGaucheY, coinHautDroitX, coinBasGaucheY };
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
