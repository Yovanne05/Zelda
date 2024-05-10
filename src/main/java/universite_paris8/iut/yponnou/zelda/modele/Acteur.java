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
            setX(this.getX()+dx*50*this.vitesse);
            setY(this.getY()+dy*50*this.vitesse);
        }
    }



    /*
    public boolean directionValide(double x, double y){
        double pixelXHG = x * 50*this.vitesse + this.getX();
        double pixelYHG = y * 50*this.vitesse + this.getY();
        int tableauXHG = (int) (pixelXHG / 50);
        int tableauYHG = (int) (pixelYHG / 50);

        double pixelXBD = x * 50*this.vitesse + this.getX()+48;
        double pixelYBD = y * 50*this.vitesse + this.getY()+48;
        int tableauXBD = (int) (pixelXBD / 50);
        int tableauYBD = (int) (pixelYBD / 50);

        double pixelXBG = x * 50*this.vitesse + this.getX()+48;
        double pixelYBG = y * 50*this.vitesse + this.getY();
        int tableauXBG = (int) (pixelXBD / 50);
        int tableauYBG = (int) (pixelYBD / 50);

        double pixelXHD = x * 50*this.vitesse + this.getX();
        double pixelYHD = y * 50*this.vitesse + this.getY()+48;
        int tableauXHD = (int) (pixelXBD / 50);
        int tableauYHD = (int) (pixelYBD / 50);

        return (this.map.getTab()[tableauXHG][tableauYHG]!=0 && pixelXHG>=0 && pixelXHG < map.getL()*50 && pixelYHG>=0 && pixelYHG <map.getH()*50-600 &&

                this.map.getTab()[tableauXBD][tableauYBD]!=0 && pixelXBD>=0 && pixelXBD < map.getL()*50 && pixelYBD>=0 && pixelYBD <map.getH()*50-600 &&

                this.map.getTab()[tableauXBG][tableauYBG]!=0 && pixelXBG>=0 && pixelXBG < map.getL()*50 && pixelYBG>=0 && pixelYBG <map.getH()*50-600 &&

                this.map.getTab()[tableauXHD][tableauYHD]!=0 && pixelXHD>=0 && pixelXHD < map.getL()*50 && pixelYHD>=0 && pixelYHD <map.getH()*50-600 );
    }*/

    public boolean directionValide(double x, double y){
        boolean valid=true;
        double pixelX = x * 50*this.vitesse + this.getX();
        double pixelY = y * 50*this.vitesse + this.getY();
        int tableauX = (int) (pixelX / 50);
        int tableauY = (int) (pixelY / 50);
        for(int i=0;i<=48;i++){
            double pixelfinX = x * 50*this.vitesse + this.getX()+i;
            double pixelfinY = y * 50*this.vitesse + this.getY()+i;

            int tableaufinX = (int) (pixelfinX / 50);
            int tableaufinY = (int) (pixelfinY / 50);
            if(!(this.map.getTab()[tableauX][tableauY]==1 && pixelX>=0 && pixelX < map.getL()*50 && pixelY>=0 && pixelY <map.getH()*50 &&
                    this.map.getTab()[tableaufinX][tableaufinY]==1 && pixelfinX>=0 && pixelfinX < map.getL()*50 && pixelfinY>=0 && pixelfinY <map.getH()*50)){
                valid=false;
                System.out.println("false");
            }
        }
        return valid;
    }


    public double getVitesse() {
        return vitesse;
    }
}