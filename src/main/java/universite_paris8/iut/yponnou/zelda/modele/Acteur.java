package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    private String nom;
    private int pv;
    private DoubleProperty x,y;
    private Map map;
    private double vitesse;

    public Acteur(String nom, int pv, double x, double y, Map map) {
        this.nom = nom;
        this.pv = pv;
        this.x =  new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.map=map;
        this.vitesse=0.2;
    }
    public double getX() {
        return x.getValue();
    }
    public double getY(){
        return y.getValue();
    }
    public void setX(double x){
        this.x.setValue(x);
    }
    public void setY(double y){
        this.y.setValue(y);
    }
    public DoubleProperty xProperty(){
        return x;
    }
    public DoubleProperty yProperty(){
        return y;
    }

    public void deplacement(double dx, double dy){
        if(directionValide(dx,dy)){
            System.out.println("valide");
            setX(this.getX()+dx*50);
            setY(this.getY()+dy*50);
        }
    }
    public boolean directionValide(double x, double y){
        double pixelX = x * 50 + this.getX();
        double pixelY = y * 50 + this.getY();
        int tableauX = (int) (pixelX / 50);
        int tableauY = (int) (pixelY / 50);
        return (this.map.getTab()[tableauX][tableauY]==1 && pixelX>=0 && pixelX < map.getL()*50 && pixelY>=0 && pixelY <map.getH()*50);
    }

    public double getVitesse() {
        return vitesse;
    }
}
