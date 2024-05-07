package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    private String nom;
    private int pv;
    private IntegerProperty x,y;
    private double v;
    private Map map;

    public Acteur(String nom, int pv, int x, int y, double vitesse, Map map) {
        this.nom = nom;
        this.pv = pv;
        this.x =  new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        v = vitesse;
        this.map=map;
    }
    public int getX() {
        return x.getValue();
    }
    public int getY(){
        return y.getValue();
    }
    public void setX(int x){
        this.x.setValue(x);
    }
    public void setY(int y){
        this.y.setValue(y);
    }
    public IntegerProperty xProperty(){
        return x;
    }
    public IntegerProperty yProperty(){
        return y;
    }
    public double getVitesse(){
        return v;
    }

    public void deplacement(int dx, int dy){
        int prochainX = getX()+dx*Map.tailleCase;
        int prochainY = getY()+dy*Map.tailleCase;

        if (prochainX < 0 || prochainY < 0 || prochainX > map.getLargeur()*Map.tailleCase || prochainY > map.getHauteur()*Map.tailleCase) {
            System.out.println("AU BORD");
        }
        else if(directionValide(dx,dy)){
            setX(prochainX);
            setY(prochainY);
        }
        else {
            System.out.println("rencontre un obstacle");
        }
    }
    public boolean directionValide(int dx, int dy){
        int prochainX = dx * Map.tailleCase + this.getX();
        int prochainY = dy * Map.tailleCase + this.getY();
        int tableauX = prochainX / Map.tailleCase;
        int tableauY = prochainY / Map.tailleCase;
        return (this.map.getTabNum()[tableauX][tableauY]==1 && prochainX>=0 && prochainX < map.getLargeur()*Map.tailleCase
                && prochainY>=0 && prochainY <= map.getHauteur()*Map.tailleCase);
    }
}
