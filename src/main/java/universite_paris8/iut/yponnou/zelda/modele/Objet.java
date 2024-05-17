package universite_paris8.iut.yponnou.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Objet{

    private static int valeur = 2;
    private String id;
    private static int incremente = 0;
    Environnement env;
    private IntegerProperty x;
    private IntegerProperty y;

    public Objet(Environnement env, int x, int y) {
        this.id = ""+incremente++;
        this.env = env;
        this.x = new SimpleIntegerProperty(x);
        env.getMap().getTabNum()[y][x] = valeur;
        this.y = new SimpleIntegerProperty(y);
    }



    public void setX(int x) {
        this.x.setValue(x);
    }

    public void setY(int y) {
        this.y.setValue(y);
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

    public String getId() {
        return id;
    }

    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        Objet.valeur = valeur;
    }

    public Environnement getEnvironnement() {
        return env;
    }

}
