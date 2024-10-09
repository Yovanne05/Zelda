

package universite_paris8.iut.yponnou.zelda.modele.Armes;

import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;


public class Fleche extends Projectile {

    private double x;
    private double y;
    private final double initialX;
    private final double initialY;

    public Fleche(double x, double y, Environnement environnement, Direction direction) {
        super("Fleche", x, y, 0, 5, environnement, direction, 300, 10);
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
    }


    public void utiliserFleche() {
        double distanceParcourue = Math.sqrt(Math.pow(getPosition().getX() - initialX, 2) + Math.pow(getPosition().getY() - initialY, 2));
        //Pythgaore pr la distance
        if (distanceParcourue < this.getPortee() && !collisionAvecObstacle(this.getHitbox())) {
            this.deplacement();
            this.collisionAvecEnnemi();
        } else {
            this.getPosition().getEnv().enleverActeur(this);
        }
    }

    @Override
    public void deplacement() {
        // Mettez à jour les coordonnées en fonction de la vitesse et de la direction
        this.x += this.getDirection().getDx() * this.getVitesse();
        this.y += this.getDirection().getDy() * this.getVitesse();
        // Mettez à jour les coordonnées de l'objet parent
        this.getPosition().setX(this.x);
        this.getPosition().setY(this.y);
    }

    public void collisionAvecEnnemi() {
        ObservableList<Acteur> lstA = getPosition().getEnv().acteursProperty();
        for (int i=0;i<lstA.size();i++) {
            if (lstA.get(i) instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) lstA.get(i);
                if (this.touche(ennemi)) {
                    ennemi.seFaitAttaquer(this.getPtsDegats());
                    getPosition().getEnv().enleverActeur(this);
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
