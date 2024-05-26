package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Guerrier extends Acteur {
    private Arme arme;

    public Guerrier(String nom, double coeurs, int x, int y, double vitesse, Environnement environnement, Arme arme) {
        super(nom, coeurs, x, y, vitesse, environnement);
        this.arme=arme;
    }
    public abstract void attaquer();
    public Acteur verifEnnemiAcoter(){
        double dist = 100;
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


    public Arme getArme() {
        return arme;
    }
}
