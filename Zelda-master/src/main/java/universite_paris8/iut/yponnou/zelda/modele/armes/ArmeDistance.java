package universite_paris8.iut.yponnou.zelda.modele.armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class ArmeDistance extends Arme{

    /**
     * Classe abstraite représentant une arme à distance dans le jeu.
     * Une arme à distance possède des propriétés comme sa position et un projectile qu'elle peut tirer.
     * Elle hérite de la classe Arme et est utilisée pour attaquer à distance.
     */

    private DoubleProperty posx;
    private DoubleProperty posy;
    private Projectile projectile;

    public ArmeDistance(double posxi, double posyi, Projectile projectile, Environnement environnement, Guerrier proprietaire, double portee) {
        super(posxi,posyi,environnement, projectile.getPtsDegats(), proprietaire,portee);
        this.projectile=projectile;
        posx=new SimpleDoubleProperty(posxi);
        posy=new SimpleDoubleProperty(posyi);
    }


    public Projectile getProjectile() {
        return projectile;
    }

    public double getPosx() {
        return posx.getValue();
    }

    public DoubleProperty posxProperty() {
        return posx;
    }

    public double getPosy() {
        return posy.getValue();
    }

    public DoubleProperty posyProperty() {
        return posy;
    }


    public void setPosx(double posx) {
        this.posx.setValue(posx);
    }

    public void setPosy(double posy) {
        this.posy.setValue(posy);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    public String nom(){
        return "ArmeDistance";
    }


}