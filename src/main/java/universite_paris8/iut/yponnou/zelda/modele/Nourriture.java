package universite_paris8.iut.yponnou.zelda.modele;

public class Nourriture extends Objet{

    private int gainPv;

    public Nourriture(int x, int y, Environnement environnement, int gainPv) {
        super(x, y, environnement);
        this.gainPv = gainPv;
    }

    public int getGainPv() {
        return gainPv;
    }
}
