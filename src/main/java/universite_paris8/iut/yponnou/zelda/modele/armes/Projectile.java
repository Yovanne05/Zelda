
package universite_paris8.iut.yponnou.zelda.modele.armes;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;

import universite_paris8.iut.yponnou.zelda.modele.armes.strategy.ComportementArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.strategy.ComportementProjectile;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public abstract class Projectile extends Acteur{

    /**
     * Classe abstraite représentant un projectile dans le jeu.
     * Les projectiles possèdent des dégâts, une portée et un comportement d'attaque spécifique.
     * Cette classe est utilisée comme base pour des projectiles comme les flèches.
     */

    private int ptsDegats;
    private double portee;
    private ComportementArme comportementAttaque;
    private final double initialX;
    private final double initialY;

    public Projectile(double x, double y, Environnement environnement, double vitesse, Direction direction, int ptsDegats, double portee) {
        super(x, y, environnement, vitesse, direction);
        this.ptsDegats = ptsDegats;
        this.portee = portee;
        this.initialX = x;
        this.initialY = y;
        this.comportementAttaque = new ComportementProjectile(this);
    }

    public double getInitialX() {
        return initialX;
    }

    public double getInitialY() {
        return initialY;
    }

    public int getPtsDegats() {
        return ptsDegats;
    }

    public void setPtsDegats(int ptsDegats) {
        this.ptsDegats = ptsDegats;
    }

    public double getPortee() {
        return portee;
    }

    public void setComportementAttaque(ComportementArme comportementAttaque) {
        this.comportementAttaque = comportementAttaque;
    }

    public ComportementArme getComportementAttaque() {
        return comportementAttaque;
    }

    public void utiliserProjectile() {
        comportementAttaque.infligeDegat();
    }
}
