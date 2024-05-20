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
    public Acteur verifEnnemiAcoter() {
        for (Acteur a : getEnvironnement().getActeurs()) {
            if (((getX() + 1) == a.getX()) || (getX() - 1 == a.getX()) || getY() + 1 == a.getY() || getY() - 1 == a.getY()) {
                return a;
            }
        }
        return null;
    }


}
