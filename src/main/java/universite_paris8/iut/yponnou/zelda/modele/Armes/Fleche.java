package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Fleche extends Projectile {

    private double x;
    private double y;
    private final double initialX;
    private final double initialY;

    public Fleche(double x, double y, Environnement environnement, int dx, int dy) {
        super("Fleche", 0, x, y, 5, 300, environnement, dx, dy,5);
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
    }

    public void utiliserFleche() {
        double distanceParcourue = Math.sqrt(Math.pow(this.getX() - initialX, 2) + Math.pow(this.getY() - initialY, 2));
        if (distanceParcourue < this.getPortee()) {
            this.deplacement();
        } else {
            this.getEnvironnement().enleverProjectiles(this);
        }
    }

    @Override
    public void deplacement() {
        // Mettez à jour les coordonnées en fonction de la vitesse et de la direction
        this.x += this.getDx() * this.getVitesse();
        this.y += this.getDy() * this.getVitesse();
        // Mettez à jour les coordonnées de l'objet parent
        this.setX(this.x);
        this.setY(this.y);
    }
}
