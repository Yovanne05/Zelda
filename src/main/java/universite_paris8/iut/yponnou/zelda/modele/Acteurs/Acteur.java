package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;

public abstract class Acteur {

    private String idActeur;
    private static int incremente = 0;
    private String nom;
    private double coeurs;
    private double v;
    private Environnement env;
    private IntegerProperty x;
    private IntegerProperty y;

    public Acteur(String nom, double coeurs, int x, int y, double vitesse,Environnement environnement) {
        this.x = new SimpleIntegerProperty(x);
        this.y= new SimpleIntegerProperty(y);
        this.nom = nom;
        this.coeurs = coeurs;
        v = vitesse;
        this.env = environnement;
        idActeur = "Acteur-"+incremente++;
    }

    public String getId() {
        return idActeur;
    }
    public String getNom() {
        return nom;
    }
    public double getCoeurs() {
        return coeurs;
    }

    public void setCoeurs(double coeurs) {
        this.coeurs = coeurs;
    }

    public int getX() {
        return x.getValue();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.getValue();
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setX(int x) {
        this.x.setValue(x);
    }

    public void setY(int y) {
        this.y.setValue(y);
    }

    public final double getVitesse(){
        return v;
    }
    public Environnement getEnvironnement() {
        return env;
    }

    public void deplacement(int dx, int dy){
        int prochainX = getX()+dx*ActeurVue.getTailleCaseX();
        int prochainY = getY()+ dy*ActeurVue.getTailleCaseY();
        int tableauX = prochainX/ActeurVue.getTailleCaseX();
        int tableauY = prochainY/ActeurVue.getTailleCaseY();

        if (prochainX < 0 || prochainY < 0 || prochainX >= env.getMap().getLargeur()*ActeurVue.getTailleCaseX() || prochainY >= env.getMap().getHauteur()*ActeurVue.getTailleCaseY()) {
            System.out.print("BORD ");
        } else if(directionValide(dx,dy)){
            setX(prochainX);
            setY(prochainY);
        }
        else if (env.getMap().getTabNum()[tableauY][tableauX] == 1){
            System.out.print("OBSTACLE ");
        }
        else if (env.getMap().getTabNum()[tableauY][tableauX] == 2) {
            System.out.print("OBJET ");
        }
    }
    public boolean directionValide(int dx, int dy){
        int prochainX, prochainY;
        int tableauX, tableauY;

        prochainX = dx * ActeurVue.getTailleCaseX() + this.getX();
        prochainY = dy * ActeurVue.getTailleCaseY() + this.getY();
        tableauX = prochainX / ActeurVue.getTailleCaseX();
        tableauY = prochainY / ActeurVue.getTailleCaseY();

        return (env.getMap().getTabNum()[tableauY][tableauX]==0 && prochainX>=0 && prochainX < env.getMap().getLargeur()*ActeurVue.getTailleCaseX()
                && prochainY >= 0 && prochainY < env.getMap().getHauteur()*ActeurVue.getTailleCaseY());
    }

//    public boolean verifEnnemi(){

//    }

    abstract void parler();


}
