package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Vendeur extends Acteur{
    public Vendeur(double x, double y, Environnement environnement, int dx, int dy) {
        super("Vendeur", x, y, 20, 0.03, environnement, dx, dy);
    }
}
