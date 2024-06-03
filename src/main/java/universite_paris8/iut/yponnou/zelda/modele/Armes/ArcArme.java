package universite_paris8.iut.yponnou.zelda.modele.Armes;

import javafx.scene.shape.Rectangle;

public class ArcArme extends ArmeDistance {

    public ArcArme(double posx, double posy) {
        super("ArcArme", 2, 300, posx, posy, 0.2);
    }

    @Override
    public void utiliser(int dx, int dy) {
        int tailleX=12;
        int tailleY=3;
        double prochainX = this.getPosx() + (dx * this.getV()) * tailleX;
        double prochainY = this.getPosy() + (dy * this.getV()) * tailleY;

        // Création de la nouvelle hitbox après déplacement
        Rectangle flecheHitbox = new Rectangle(prochainX, prochainY, tailleX, tailleY);
        this.setPosx(prochainX);
        this.setPosy(prochainY);
    }
}
