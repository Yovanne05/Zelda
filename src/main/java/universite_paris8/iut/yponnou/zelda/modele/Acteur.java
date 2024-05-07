package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    private String nom;
    private int pv;
    private IntegerProperty x,y;
    private Map map;

    public Acteur(String nom, int pv, int x, int y, Map map) {
        this.nom = nom;
        this.pv = pv;
        this.x =  new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
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

    public void deplacement(int dx, int dy){
        if(directionValide(dx,dy)){
            System.out.println("valide");
            setX(this.getX()+dx*50);
            setY(this.getY()+dy*50);
        }
    }
    public boolean directionValide(int x, int y){
        int pixelX = x * 50 + this.getX();
        int pixelY = y * 50 + this.getY();
        int tableauX = pixelX / 50;
        int tableauY = pixelY / 50;
        return (this.map.getTab()[tableauX][tableauY]==1 && pixelX>=0 && pixelX < map.getL()*50 && pixelY>=0 && pixelY <map.getH()*50);
    }
}
