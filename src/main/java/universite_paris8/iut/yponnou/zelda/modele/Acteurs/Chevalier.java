
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Chevalier extends Ennemi{

    private int cptPas = 0;
    private int maxPas = 300; // Nombre de pas avant de changer de direction

    public Chevalier(double x, double y, Environnement environnement, int dx, int dy, ArmeMelee arme) {
        super("Chevalier", x, y, 240, 0.03, environnement, dx, dy, arme);
    }
    @Override
    public void attaquer() {
        long tempsActuel = System.currentTimeMillis();
        if (tempsActuel - this.getDerniereAttaque() >= 250) {
            Hero hero = verifHeroProx(80);
            if (hero != null) {
                hero.seFaitAttaquer(((ArmeMelee) this.getArme()).getPtsDegats());
                this.setDerniereAttaque(tempsActuel);
            }
        }
    }
    @Override
    public void deplacementEnnemi() {
        Hero hero = verifHeroProx(80);
        if (hero != null) {
            attaquer();
            return;
        }

        // Déplacement en allers-retours
        cptPas++;
        if (cptPas >= maxPas) {
            // Change direction
            setDx(-getDx());
            setDy(-getDy());
            cptPas = 0;
        }

        // Effectuer le déplacement
        this.deplacement();
    }
}
