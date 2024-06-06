package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Guerrier extends Acteur {
    private Arme arme;

    public Guerrier(String nom, double coeurs, double x, double y, double vitesse, Environnement environnement, int dx, int dy, Arme arme) {
        super(nom, coeurs, x, y, vitesse, environnement, dx, dy);
        this.arme=arme;
    }


    public abstract void attaquer(int dx, int dy);
    public Acteur verifEnnemiAcoter(){
        double dist = 80;
        for (Acteur a : getEnvironnement().getActeurs()) {
            // Vérifie que l'acteur n'est pas lui-même
            if (!a.getId().equals(this.getId())) {
                // Vérifie la distance en utilisant la distance de Manhattan
                if (Math.abs(getX() - a.getX()) <= dist && Math.abs(getY() - a.getY()) <= dist) {
                    return a;
                }
            }
        }
        return null;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public Arme getArme() {
        return arme;
    }
}
