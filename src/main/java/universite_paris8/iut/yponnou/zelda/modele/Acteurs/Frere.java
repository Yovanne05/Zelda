package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Frere extends Acteur{
    public Frere(double x, double y, Environnement environnement, int dx, int dy) {
        super("Frere", x, y, 20, 0.03, environnement, dx, dy);
    }
}
