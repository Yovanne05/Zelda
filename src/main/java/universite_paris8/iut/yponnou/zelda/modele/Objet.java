package universite_paris8.iut.yponnou.zelda.modele;

public class Objet extends Tile {

    private static int valeur = 2;
    private String id;
    private static int incremente = 0;
    Environnement env;

    public Objet(int x, int y, Environnement environnement) {
        super(x,y);
        env = environnement;
        id = "Ob"+incremente++;
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