package universite_paris8.iut.yponnou.zelda.modele;

import javafx.scene.shape.Rectangle;

public abstract class Acteur extends Tile {

    private String idActeur;
    private static int incremente = 0;
    private String nom;
    private int pv;
    private double vitesse;
    private Environnement env;
    private Rectangle hitbox;

    public Acteur(String nom, int pv, double x, double y, double vitesse, Map map, Environnement environnement) {
        super(x,y,map);
        this.nom = nom;
        this.pv = pv;
        this.vitesse = vitesse;
        this.env = environnement;
        idActeur = "A"+incremente++;
        hitbox = new Rectangle(x, y, getTailleCaseX(), getTailleCaseY());
    }

    public String getId() {
        return idActeur;
    }
    public String getNom() {
        return nom;
    }
    public int getPv() {
        return pv;
    }

    public void setX(double x) {
        super.setX(x);
        hitbox.setX(x);
    }
    public void setY(double y) {
        super.setY(y);
        hitbox.setY(y);
    }

    public final double getVitesse(){
        return vitesse;
    }
    public Environnement getEnvironnement() {
        return env;
    }

    public void deplacement(int dx, int dy){
        double prochainX = getX()+dx*vitesse;
        double prochainY = getY()+dy*vitesse;

        Rectangle futureHitbox = new Rectangle(prochainX, prochainY, getTailleCaseX(), getTailleCaseY());

        if (env.dansMap(prochainX, prochainY) && !collisionAvecObstacle(futureHitbox)) {
            setX(prochainX);
            setY(prochainY);
        }
    }

    private boolean collisionAvecObstacle(Rectangle futureHitbox) {
        // Calcul des positions des quatre coins de la hitbox
        double x = futureHitbox.getX();
        double y = futureHitbox.getY();
        double width = futureHitbox.getWidth();
        double height = futureHitbox.getHeight();

        // Coordonnées des coins de la hitbox en termes de cases
        int tableauXHG = (int) (x / getTailleCaseX());
        int tableauYHG = (int) (y / getTailleCaseY());
        int tableauXHD = (int) ((x + width-1) / getTailleCaseX());
        int tableauYHD = tableauYHG;
        int tableauXBG = tableauXHG;
        int tableauYBG = (int) ((y + height-1) / getTailleCaseY());
        int tableauXBD = tableauXHD;
        int tableauYBD = tableauYBG;

        // Vérification des collisions avec les obstacles
        int[][] map = env.getMap().getTabNum();
        return map[tableauYHG][tableauXHG] == 1 || map[tableauYHD][tableauXHD] == 1 || map[tableauYBG][tableauXBG] == 1 || map[tableauYBD][tableauXBD] == 1; // Collision avec un obstacle
    }

    abstract void parler();
}
