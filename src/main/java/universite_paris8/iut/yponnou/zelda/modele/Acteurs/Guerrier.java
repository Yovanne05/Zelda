package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Guerrier extends Acteur {
    private Arme arme;

    public Guerrier(String nom, double x, double y, int pv, double vitesse, Environnement environnement, Arme arme) {
        super(nom, x, y, pv, vitesse, environnement);
        this.arme=arme;
    }

    public Arme getArme() {
        return arme;
    }
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public abstract void attaquer();

    public Ennemi verifEnnemiAcoter(){
        double dist = 100;
        for (Acteur a : getPosition().getEnv().acteursProperty()) {
            // Vérifie que l'acteur n'est pas lui-même
            if (!a.getId().equals(this.getId())) {
                if (a instanceof Ennemi) {
                    // Vérifie la distance en utilisant la distance de Manhattan
                    if (Math.abs(getPosition().getX() - a.getPosition().getX()) <= dist && Math.abs(getPosition().getY() - a.getPosition().getY()) <= dist) {
                        return (Ennemi)a;
                    }
                }
            }
        }
        return null;
    }

    public boolean estMort(){
        return getPv() == 0;
    }
}
