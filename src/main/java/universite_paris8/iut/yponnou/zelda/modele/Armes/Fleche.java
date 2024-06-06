package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Fleche extends Projectile{

    private static double x;
    private static double y;
    public Fleche(double x, double y, Environnement environnement, int dx, int dy) {
        super("Fleche", 0, x, y, 0.2, 100, environnement, dx, dy);
        x = this.getX();
        y = this.getY();
    }

    public void utiliserFleche() {
        System.out.println(this.getX() + "X");
        System.out.println(this.getPortee() + "Portee");
        if (x < this.getPortee() + this.getX() || y < this.getPortee() + this.getY()){
            this.deplacement();
        }else{
            this.getEnvironnement().enleverProjectiles(this);
        }
    }
}
