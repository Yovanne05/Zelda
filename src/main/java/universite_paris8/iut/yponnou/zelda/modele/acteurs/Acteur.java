
package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;


public abstract class Acteur extends Objet {

    /**
     * La classe Acteur représente un personnage ou une entité mobile dans le jeu.
     * Elle gère les propriétés de déplacement, de collision, et d'interaction avec l'environnement
     * et les autres acteurs du jeu.
     */

    private final double vitesse;
    private Direction direction;
    private final Hitbox hitbox;

    public Acteur(double x, double y, Environnement environnement, double vitesse, Direction direction) {
        super(x, y, environnement);
        this.vitesse = vitesse;
        hitbox = new Hitbox(x,y,TAILLE50,TAILLE50);
        this.direction=direction;
        hitbox.xProperty().bind(this.getPosition().xProperty());
        hitbox.yProperty().bind(this.getPosition().yProperty());
    }

    public boolean estProcheDeActeur(Acteur acteur, double distanceSeuil) {
        double distance = distance(acteur.getPosition());
        return distance <= distanceSeuil;
    }

    public String nom() {
        return "Acteur";
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final double getVitesse(){
        return vitesse;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public double[] calculerProchainePosition() {
        double prochainX = getPosition().getX() + getDirection().getDx() * vitesse;
        double prochainY = getPosition().getY() + getDirection().getDy() * vitesse;
        return new double[] { prochainX, prochainY };
    }

    public double[] calculerDiffEntreMoiEtCible(Position cible) {
        double diffX =(cible.getX() - getPosition().getX());
        double diffY =(cible.getY() - getPosition().getY());
        return new double[] { diffX, diffY };
    }

    public double distance(Position cible) {
        double[] diff = calculerDiffEntreMoiEtCible(cible);
        double diffX = diff[0];
        double diffY = diff[1];
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public void deplacement() {
        Hitbox futureHitbox = futureHitbox();
        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            getPosition().setX(futureHitbox.hitboxX());
            getPosition().setY(futureHitbox.hitboxY());
        }
    }

    public Hitbox futureHitbox(){
        double[] prochainePosition = calculerProchainePosition();
        double prochainX = prochainePosition[0];
        double prochainY = prochainePosition[1];

        // Création de la nouvelle hitbox après déplacement
        Hitbox futureHitbox = new Hitbox(prochainX, prochainY, TAILLE50, TAILLE50);
        return futureHitbox;
    }


    public void deplacerVers(Position cible) {
        double distance = distance(cible);
        if (distance > 0) {
            effectuerDeplacement(cible,distance);
        }
    }

    public void effectuerDeplacement(Position cible, double distance){
        double[] diff = calculerDiffEntreMoiEtCible(cible);
        double diffX = diff[0];
        double diffY = diff[1];

        double directionX = (diffX / distance);
        double directionY = (diffY / distance);

        Direction newDirection = new Direction(directionX,directionY);
        direction.changementDirection(newDirection.getDx(), newDirection.getDy());

        double[] prochainePosition = calculerProchainePosition();
        double prochainX = prochainePosition[0];
        double prochainY = prochainePosition[1];

        Hitbox futureHitbox = new Hitbox(prochainX, prochainY, TAILLE50, TAILLE50);

        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            getPosition().setX(prochainX);
            getPosition().setY(prochainY);
        }
    }

    public boolean estEnDehorsDeLaCarte(double xHG, double yHG, double xHD, double yBG) {
        int largeurMap = getEnvironnement().getMap().getLargeur();
        int hauteurMap = getEnvironnement().getMap().getHauteur();
        return xHG < 0 || yHG < 0 || xHD >= largeurMap || yBG >= hauteurMap;
    }

    public boolean estObstacle(int[][] map, double x, double y) {
        return map[(int) y][(int) x] > 20;
    }

    public boolean collisionAvecObstacleDansCarte(double xHG, double yHG, double xHD, double yBG) {
        int[][] map = getEnvironnement().getMap().getTabNum();
        return estObstacle(map, xHG, yHG) || estObstacle(map, xHD, yHG) || estObstacle(map, xHG, yBG) || estObstacle(map, xHD, yBG);
    }

    public boolean collisionAvecObstacle(Hitbox futureHitbox) {
        double[] coins = futureHitbox.calculerCoinsHitbox();
        double coinHautGaucheX = coins[0];
        double coinHautGaucheY = coins[1];
        double coinHautDroitX = coins[2];
        double coinBasGaucheY = coins[3];

        if (estEnDehorsDeLaCarte(coinHautGaucheX, coinHautGaucheY, coinHautDroitX, coinBasGaucheY)) {
            return true;
        }
        return collisionAvecObstacleDansCarte(coinHautGaucheX, coinHautGaucheY, coinHautDroitX, coinBasGaucheY);
    }

    public boolean acteurEstEnCollision(Hitbox futureHitbox, Acteur acteur) {
        if (this.getId().equals(acteur.getId())) {
            return false;
        }
        Hitbox ennemiHitbox = acteur.getHitbox();
        return futureHitbox.getHitbox().getBoundsInParent().intersects(ennemiHitbox.getHitbox().getBoundsInParent());
    }

    public boolean collisionAvecActeur(Hitbox futureHitbox) {
        for (Acteur acteur : getEnvironnement().acteursProperty()) {
            if (acteurEstEnCollision(futureHitbox, acteur)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "vitesse=" + vitesse +
                ", direction=" + direction +
                ", hitbox=" + hitbox +
                '}';
    }
}
