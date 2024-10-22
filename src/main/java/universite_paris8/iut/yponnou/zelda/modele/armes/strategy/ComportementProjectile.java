package universite_paris8.iut.yponnou.zelda.modele.armes.strategy;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.armes.Projectile;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;

public class ComportementProjectile implements ComportementArme{
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
        for (Acteur acteur : projectile.getEnvironnement().acteursProperty()) {
            if (acteur instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) acteur;
                if (projectile.touche(ennemi)) {
                    ennemi.seFaitAttaquer(projectile.getPtsDegats());
                    projectile.getEnvironnement().enleverActeur(projectile);
                }
            }
        }
    }
}