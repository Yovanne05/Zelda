package universite_paris8.iut.yponnou.zelda.modele;

import javafx.scene.shape.Rectangle;

public abstract class Acteur extends Tile {

    private final String idActeur;
    private static int incremente = 0;
    private final String nom;
    private final int pv;
    private final double vitesse;
    private Environnement env;
    private final Rectangle hitbox;

    public Acteur(String nom, int pv, double x, double y, double vitesse, Environnement environnement) {
        super(x,y);
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
    public void setEnvironnement(Environnement environnement) {
        this.env = environnement;
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

    public boolean collisionAvecObstacle(Rectangle futurHitbox) {
        // Calcul des positions des quatre coins de la hitbox
        double x = futurHitbox.getX();
        double y = futurHitbox.getY();
        double width = futurHitbox.getWidth();
        double height = futurHitbox.getHeight();

        // Coordonnées des coins de la hitbox en terme de cases
        int tableauXHG = (int) (x / getTailleCaseX());
        int tableauYHG = (int) (y / getTailleCaseY());
        int tableauXHD = (int) ((x + width-1) / getTailleCaseX());
        int tableauYBG = (int) ((y + height-1) / getTailleCaseY());

        // Vérification des collisions avec les obstacles
        int[][] map = env.getMap().getTabNum();
        return map[tableauYHG][tableauXHG] == 1 || map[tableauYHG][tableauXHD] == 1 || map[tableauYBG][tableauXHG] == 1 || map[tableauYBG][tableauXHD] == 1; // Collision avec un obstacle
    }

    abstract void parler();
}
