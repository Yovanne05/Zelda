
package universite_paris8.iut.yponnou.zelda.modele.Armes;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;


import static universite_paris8.iut.yponnou.zelda.Constante.TAILLE50;

public class Fleche extends Projectile {

    private double x;
    private double y;
    private final double initialX;
    private final double initialY;

    public Fleche(double x, double y, Environnement environnement, int dx, int dy) {
        super("Fleche", x, y, 0, 5, environnement, dx, dy, 300, 10);
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
    }


    public void utiliserFleche() {
        double distanceParcourue = Math.sqrt(Math.pow(getPosition().getX() - initialX, 2) + Math.pow(getPosition().getY() - initialY, 2));
        //Math.pow(a, 2) calcule le carré du nombre a. Ici, on calcule les carrés des distances parcourues en x et y.
        //Cela est fait pour appliquer le théorème de Pythagore.
        //Math.sqrt(b) calcule la racine carrée du nombre b. Ici, on prend la racine carrée de la somme des carrés des distances
        //parcourues en x et y, ce qui nous donne la distance euclidienne totale parcourue par la flèche depuis sa position initiale.
        if (distanceParcourue < this.getPortee()) {
            this.deplacement();
            this.collisionAvecEnnemi();
        } else {
            this.getPosition().getEnv().enleverProjectile(this);
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

    public void collisionAvecEnnemi() {

        for (Acteur a : getPosition().getEnv().acteursProperty()) {
            if (a instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) a;
                if (this.touche(ennemi)) {
                    ennemi.seFaitAttaquer(this.getPtsDegats());
                    getPosition().getEnv().enleverProjectile(this);
                }
            }
        }
    }

    private boolean touche(Ennemi ennemi) {
        // Supposons que chaque acteur a des coordonnées (x, y) et une largeur/hauteur (w, h)
        double ennemiX = ennemi.getPosition().getX();
        double ennemiY = ennemi.getPosition().getY();

        // Vérifiez si la flèche est à l'intérieur des limites de l'ennemi
        return (this.x >= ennemiX && this.x <= ennemiX + TAILLE50) && (this.y >= ennemiY && this.y <= ennemiY + TAILLE50);
    }
}
