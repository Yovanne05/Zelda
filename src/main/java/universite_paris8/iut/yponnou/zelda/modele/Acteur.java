package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    private String nom;
    private int pv;
    private IntegerProperty x,y;
    private Map monde;

    public Acteur(String nom, int pv, int x, int y) {
        this.nom = nom;
        this.pv = pv;
        this.x =  new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
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
            setX(this.getX()+dx);
            setY(this.getY()+dy);

        }
    }
    public boolean directionValide(int x, int y){
        return (x>=0 && x< monde.getL() && y>=0 && y<monde.getH() && monde.getTab()[x][y]!=0);
    }
}
