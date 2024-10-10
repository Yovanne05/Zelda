
package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;


public abstract class Acteur extends Objet {

    private static int incremente = 0;
    private final String id;

    private final double vitesse;
    private Direction direction;
    private final Hitbox hitbox;

    public Acteur(double x, double y, Environnement environnement, double vitesse, Direction direction) {
        super(x, y, environnement);
        this.vitesse = vitesse;
        id = "A"+incremente++;
        hitbox = new Hitbox(x,y,TAILLE50,TAILLE50);
        this.direction=direction;
        hitbox.xProperty().bind(this.getPosition().xProperty());
        hitbox.yProperty().bind(this.getPosition().yProperty());
    }

    public String getId() {
        return id;
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
        double prochainX = getPosition().getX() + getDirection().getDx() * vitesse * TAILLE50;
        double prochainY = getPosition().getY() + getDirection().getDy() * vitesse * TAILLE50;
        return new double[] { prochainX, prochainY };
    }

    public int[] calculerDiffEntreMoiEtCible(Position cible) {
        int diffX = (int) (cible.getX() - getPosition().getX());
        int diffY = (int) (cible.getY() - getPosition().getY());
        return new int[] { diffX, diffY };
    }

    public double distance(Position cible) {
        int[] diff = calculerDiffEntreMoiEtCible(cible);
        int diffX = diff[0];
        int diffY = diff[1];
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public void deplacement() {
        Hitbox futureHitbox = futureHitbox();

        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            getPosition().setX(futureHitbox.getHitbox().getX());
            getPosition().setY(futureHitbox.getHitbox().getY());
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
        int[] diff = calculerDiffEntreMoiEtCible(cible);
        int diffX = diff[0];
        int diffY = diff[1];

        int directionX = (int) (diffX / distance);
        int directionY = (int) (diffY / distance);
        Direction newDirection = new Direction(directionX,directionY);


        // Nouvelle pos
        double[] prochainePosition = calculerProchainePosition();
        double prochainX = prochainePosition[0];
        double prochainY = prochainePosition[1];

        Hitbox futureHitbox = new Hitbox(prochainX, prochainY, TAILLE50, TAILLE50);

        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            getPosition().setX(prochainX);
            getPosition().setY(prochainY);
        }
    }

    public boolean estEnDehorsDeLaCarte(int xHG, int yHG, int xHD, int yBG) {
        int largeurMap = getEnvironnement().getMap().getLargeur();
        int hauteurMap = getEnvironnement().getMap().getHauteur();
        return xHG < 0 || yHG < 0 || xHD >= largeurMap || yBG >= hauteurMap;
    }

    public boolean estObstacle(int[][] map, int x, int y) {
        return map[y][x] > 20;
    }

    public boolean collisionAvecObstacleDansCarte(int xHG, int yHG, int xHD, int yBG) {
        int[][] map = getEnvironnement().getMap().getTabNum();
        return estObstacle(map, xHG, yHG) || estObstacle(map, xHD, yHG) || estObstacle(map, xHG, yBG) || estObstacle(map, xHD, yBG);
    }

    public boolean collisionAvecObstacle(Hitbox futureHitbox) {
        int[] coins = futureHitbox.calculerCoinsHitbox();
        int coinHautGaucheX = coins[0];
        int coinHautGaucheY = coins[1];
        int coinHautDroitX = coins[2];
        int coinBasGaucheY = coins[3];

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
                "id='" + id + '\'' +
                ", vitesse=" + vitesse +
                ", direction=" + direction +
                ", hitbox=" + hitbox +
                '}';
    }
}
