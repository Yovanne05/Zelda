package universite_paris8.iut.yponnou.zelda.modele.Armes;

public class ArmeDistance extends Arme{
    private double portee;

    public ArmeDistance(String nom, double ptsDegats, double portee) {
        super(nom, ptsDegats);
        this.portee=portee;
    }
}
