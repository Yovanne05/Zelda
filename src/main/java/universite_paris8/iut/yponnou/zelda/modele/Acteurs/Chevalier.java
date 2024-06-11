package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Chevalier extends Ennemi{

    private int stepCounter = 0;
    private int maxSteps = 300; // Nombre de pas avant de changer de direction
    public Chevalier(double x, double y, Environnement environnement, int dx, int dy, ArmeMelee arme) {
        super("Chevalier", x, y, 250, 0.03, environnement, dx, dy, arme);
    }
    @Override
    public void attaquer() {
        Hero hero = verifHeroProx();
        hero.seFaitAttquer(((ArmeMelee)this.getArme()).getPtsDegats());
    }
    @Override
    public void deplacementEnnemi() {
        Hero hero = verifHeroProx();
        if (hero != null) {
            attaquer();
            return;
        }

        // Déplacement en allers-retours
        stepCounter++;
        if (stepCounter >= maxSteps) {
            // Change direction
            setDx(-getDx());
            setDy(-getDy());
            stepCounter = 0;
        }

        // Effectuer le déplacement
        this.deplacement();
    }
}
