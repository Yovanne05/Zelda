package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;

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
    public final int getX() {
        return x.getValue();
    }
    public final int getY(){
        return y.getValue();
    }
    public final void setX(int x){
        this.x.setValue(x);
    }
    public final void setY(int y){
        this.y.setValue(y);
    }
    public final IntegerProperty xProperty(){
        return x;
    }
    public final IntegerProperty yProperty(){
        return y;
    }
    public final double getVitesse(){
        return v;
    }
    public Map getMap(){
        return map;
    }

    public void deplacement(int dx, int dy){
        int prochainX = getX()+ dx*ActeurVue.tailleCaseX;
        int prochainY = getY()+ dy*ActeurVue.tailleCaseY;

        if (prochainX < 0 || prochainY < 0 || prochainX >= map.getLargeur()*ActeurVue.tailleCaseX || prochainY >= map.getHauteur()*ActeurVue.tailleCaseY) {
            System.out.print("BORD ");
        }
        else if(directionValide(dx,dy)){
            setX(prochainX);
            setY(prochainY);
        }
        else {
            System.out.print("OBSTACLE ");
        }
    }
    public boolean directionValide(int dx, int dy){
        int prochainX = dx * ActeurVue.tailleCaseX + this.getX();
        int prochainY = dy * ActeurVue.tailleCaseY + this.getY();
        int tableauX = prochainX / ActeurVue.tailleCaseX;
        int tableauY = prochainY / ActeurVue.tailleCaseY;
        return (this.map.getTabNum()[tableauX][tableauY]==0 && prochainX>=0 && prochainX < map.getLargeur()*ActeurVue.tailleCaseX
                && prochainY >= 0 && prochainY < map.getHauteur()*ActeurVue.tailleCaseY);
    }
}
