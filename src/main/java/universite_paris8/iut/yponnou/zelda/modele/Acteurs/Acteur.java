
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.PositionEnv;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;


public class Acteur {

    private final String id;
    private String directionString;
    private static int incremente = 0;
    private final String nom;
    private final PositionEnv position;
    private final double vitesse;
    private final IntegerProperty pv;
    private final Hitbox hitbox;
    private Direction direction;

    public Acteur(String nom, double x, double y, int pv, double vitesse, Environnement environnement, Direction direction) {
        this.nom = nom;
        position = new PositionEnv(x,y,environnement);
        this.pv = new SimpleIntegerProperty(pv);
        this.vitesse = vitesse;
        id = "A"+incremente++;
        hitbox = new Hitbox(x,y,TAILLE50,TAILLE50);
        this.direction=direction;
        this.directionString="down";
        hitbox.xProperty().bind(this.getPosition().xProperty());
        hitbox.yProperty().bind(this.getPosition().yProperty());
    }

    public String getDirectionString() {
        return directionString;
    }

    public void setDirectionString(String directionString) {
        this.directionString = directionString;
    }

    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv.getValue();
    }
    public void setPv(int pv) {
        this.pv.setValue(pv);
    }

    public IntegerProperty pvProperty() {
        return pv;
    }

    public PositionEnv getPosition() {
        return position;
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

    public double[] calculerProchainePosition(Position p, Direction d, Double vitessev) {
        double prochainX = p.getX() + d.getDx() * vitessev * TAILLE50;
        double prochainY = p.getY() + d.getDy() * vitessev * TAILLE50;
        return new double[] { prochainX, prochainY };
    }

    public double[] calculerDiffEntreMoiEtCible(Position cible) {
        double diffX = cible.getX() - getPosition().getX();
        double diffY = cible.getY() - getPosition().getY();
        return new double[] { diffX, diffY };
    }

    public double distance(Position cible) {
        double[] diff = calculerDiffEntreMoiEtCible(cible);
        double diffX = diff[0];
        double diffY = diff[1];
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public void deplacement() {
        double[] prochainePosition = calculerProchainePosition(position, direction, vitesse);
        double prochainX = prochainePosition[0];
        double prochainY = prochainePosition[1];

        // Création de la nouvelle hitbox après déplacement
        Hitbox futureHitbox = new Hitbox(prochainX, prochainY, TAILLE50, TAILLE50);
        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            position.setX(prochainX);
            position.setY(prochainY);
        }
    }

    public boolean estMort(){
        return this.getPv()<0;
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

        double directionX = diffX / distance;
        double directionY = diffY / distance;
        Direction newDirection = new Direction(directionX,directionY);

        // Nouvelle pos
        double[] prochainePosition = calculerProchainePosition(position, newDirection, vitesse);
        double prochainX = prochainePosition[0];
        double prochainY = prochainePosition[1];

        Hitbox futureHitbox = new Hitbox(prochainX, prochainY, TAILLE50, TAILLE50);

        if (!collisionAvecObstacle(futureHitbox) && !collisionAvecActeur(futureHitbox)) {
            position.setX(prochainX);
            position.setY(prochainY);
        }
    }

    public boolean estEnDehorsDeLaCarte(int xHG, int yHG, int xHD, int yBG) {
        int largeurMap = position.getEnv().getMap().getLargeur();
        int hauteurMap = position.getEnv().getMap().getHauteur();
        return xHG < 0 || yHG < 0 || xHD >= largeurMap || yBG >= hauteurMap;
    }

    public boolean estObstacle(int[][] map, int x, int y) {
        return map[y][x] > 20;
    }

    public boolean collisionAvecObstacleDansCarte(int xHG, int yHG, int xHD, int yBG) {
        int[][] map = position.getEnv().getMap().getTabNum();
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
        for (Acteur acteur : getPosition().getEnv().acteursProperty()) {
            if (acteurEstEnCollision(futureHitbox, acteur)) {
                return true;
            }
        }
        return false;
    }


    public void seFaitAttaquer(int degats) {
        int nouveauxPv = calculerNouveauxPv(degats);
        if (nouveauxPv > 0) {
            setPv(nouveauxPv);
        } else {
            mourir();
        }
    }

    public int calculerNouveauxPv(int degats) {
        return Math.max(0, getPv() - degats); //renvoie la valeur la plus grande pour ne pas renvoyez des pv négatif
    }

    public void mourir() {
        setPv(0);
        getPosition().getEnv().enleverActeur(this);
    }

    public boolean estProcheDeActeur(Acteur acteur, double distanceSeuil) {
        double distance = distance(acteur.position);
        return distance <= distanceSeuil;
    }

    public void subitDegats(int degats){
        setPv(calculerNouveauxPv(degats));
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "idActeur='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", coeurs=" + pv +
                ", v=" + vitesse +
                ", env=" + position.getEnv() +
                ", x=" + position.getX() +
                ", y=" + position.getY() +
                ", hitbox=" + hitbox +
                '}';
    }

}
