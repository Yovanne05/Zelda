package universite_paris8.iut.yponnou.zelda.modele.Armes;

import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class ArcArme extends ArmeDistance {


    public ArcArme(double posxi, double posyi, Projectile projectile, Environnement environnement) {
        super("Arc", posxi, posyi, projectile, environnement);
    }

    @Override
    public double utiliser() {
        Fleche f = (Fleche) this.getProjectile();
        this.getEnvironnement().ajouterProjectiles(f);
        f.utiliserFleche();
        return this.getProjectile().getPtsDegats();
    }


//    @Override
//    public double utiliser(int dx, int dy) {
//        int tailleX = 12;
//        int tailleY = 3;
//        double prochainX = 0;
//        double prochainY = 0;
//
//        while (prochainX < this.getPortee() + this.getProjectile().getX() || prochainY < this.getPortee() + this.getProjectile().getY()){
//            prochainX = this.getProjectile().getX() + (dx * this.getProjectile().getX()  * this.getProjectile().getVitesse());
//            prochainY = this.getProjectile().getY() + (dy * this.getProjectile().getY()  * this.getProjectile().getVitesse());
//
//            this.getProjectile().getEnvironnement().ajouterProjectiles(this.getProjectile());
//
//            this.getProjectile().setX(prochainX);
//            this.getProjectile().setY(prochainY);
//
//
//            System.out.println(this.getProjectile().getX() + " " + this.getProjectile().getY());
//
////            Rectangle flecheHitbox = new Rectangle(prochainX, prochainY, tailleX, tailleY);
////            getProjectile().collisionAvecObstacle(flecheHitbox);
//        }
//        return this.getProjectile().getPtsDegats();
//    }

}
