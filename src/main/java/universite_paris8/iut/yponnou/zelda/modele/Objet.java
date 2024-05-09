package universite_paris8.iut.yponnou.zelda.modele;

public class Objet extends Case{

    private int valeur = 2;
    private int id;
    private static int incremente = 0;

    public Objet(int x, int y, Map map) {
        super(x,y,map);
        getMap().getTabNum()[x][y] = getValeur();
        id = incremente++;
    }

    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

//    public void agit(Heros hero){
//
//    }

}
