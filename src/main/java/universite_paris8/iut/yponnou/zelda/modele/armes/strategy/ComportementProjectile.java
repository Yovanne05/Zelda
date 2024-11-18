package universite_paris8.iut.yponnou.zelda.modele.armes.strategy;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.armes.Projectile;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;

import java.util.ArrayList;
import java.util.List;

public class ComportementProjectile implements ComportementArme{

    /**
     * Implémentation du comportement d'un projectile.
     * Cette classe gère le mouvement d'un projectile et sa collision avec les ennemis, infligeant des dégâts si nécessaire.
     */

    private Projectile projectile;

    public ComportementProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    @Override
    public void infligeDegat() {
        Environnement environnement = projectile.getEnvironnement();
        double distanceParcourue = Math.sqrt(Math.pow(projectile.getPosition().getX() - projectile.getPosition().getX(), 2)
                + Math.pow(projectile.getPosition().getY() - projectile.getPosition().getY(), 2));

        if (distanceParcourue < projectile.getPortee() && !projectile.collisionAvecObstacle(projectile.getHitbox())) {
            double[] prochainePosition = projectile.calculerProchainePosition();
            double prochainX = prochainePosition[0];
            double prochainY = prochainePosition[1];
            projectile.getPosition().setX(prochainX);
            projectile.getPosition().setY(prochainY);
            collisionAvecEnnemi();
        } else {
            environnement.enleverActeur(projectile);
        }
    }

    private void collisionAvecEnnemi() {
        boolean projectileDoitEtreSupprime = false;
        List<Acteur> acteurs = projectile.getEnvironnement().acteursProperty();
        for (int i = acteurs.size() - 1; i >= 0; i--) {
            Acteur acteur = acteurs.get(i);
            if (acteur instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) acteur;
                if (projectile.touche(ennemi)) {
                    ennemi.seFaitAttaquer(projectile.getPtsDegats());
                    projectileDoitEtreSupprime = true;
                }
            }
        }
        if (projectileDoitEtreSupprime) {
            projectile.getEnvironnement().enleverActeur(projectile);
        }
    }

}