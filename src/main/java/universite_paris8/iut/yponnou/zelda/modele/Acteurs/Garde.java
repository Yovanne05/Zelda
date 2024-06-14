
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Garde extends Ennemi{

    public Garde(double x, double y,Environnement environnement, int dx, int dy, Arme arme) {
        super("Garde", x, y, 120, 0.03, environnement, dx, dy, arme);
    }

    public void attaquer() {
        long tempsActuel = System.currentTimeMillis();
        if (tempsActuel - this.getDerniereAttaque() >= 250) {
            Hero hero = verifHeroProx(60);
            if (hero != null) {
                hero.seFaitAttaquer(((ArmeMelee) this.getArme()).getPtsDegats());
                this.setDerniereAttaque(tempsActuel);
            }
        }
    }

    @Override
    public void deplacementEnnemi() {
        attaquer();
    }


}
