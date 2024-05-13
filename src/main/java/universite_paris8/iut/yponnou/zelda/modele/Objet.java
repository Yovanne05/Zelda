package universite_paris8.iut.yponnou.zelda.modele;

public class Objet extends Case{

    private static int valeur = 2;
    private String id;
    private static int incremente = 0;
    Environnement env;

    public Objet(int x, int y, Map map, Environnement environnement) {
        super(x,y,map);
        getMap().getTabNum()[x][y] = valeur;
        env = environnement;
        id = "Objet-"+incremente++;
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

//    public void agit(Heros hero){}

}
