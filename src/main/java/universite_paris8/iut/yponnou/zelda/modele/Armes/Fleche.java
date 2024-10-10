

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
        super(x, y, environnement, 5, direction, 5, 300);
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
    }

    public void utiliserFleche() {
        double distanceParcourue = Math.sqrt(Math.pow(getPosition().getX() - initialX, 2) + Math.pow(getPosition().getY() - initialY, 2)); //pyhagore
        if (distanceParcourue < this.getPortee() && !collisionAvecObstacle(this.getHitbox())) {
            this.deplacement();
            this.collisionAvecEnnemi();
        } else {
            this.getEnvironnement().enleverActeur(this);
        }
    }

    @Override
    public void deplacement() {
        double prochainX = this.getPosition().getX() + (this.getDirection().getDx() * this.getVitesse());
        double prochainY = this.getPosition().getY() + (this.getDirection().getDy() * this.getVitesse());

        this.getPosition().setX(prochainX);
        this.getPosition().setY(prochainY);
    }

    public void collisionAvecEnnemi() {
        ObservableList<Acteur> lstA = getEnvironnement().acteursProperty();
        for (int i=0;i<lstA.size();i++) {
            if (lstA.get(i) instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) lstA.get(i);
                if (this.touche(ennemi)) {
                    ennemi.seFaitAttaquer(this.getPtsDegats());
                    getEnvironnement().enleverActeur(this);
                }
            }
        }
    }

    private boolean touche(Ennemi ennemi) {
        double ennemiX = ennemi.getPosition().getX();
        double ennemiY = ennemi.getPosition().getY();

        return (this.x >= ennemiX && this.x <= ennemiX + TAILLE50) && (this.y >= ennemiY && this.y <= ennemiY + TAILLE50);
    }

    public String nom(){
        return "Fleche";
    }


}
