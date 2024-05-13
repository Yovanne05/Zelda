package universite_paris8.iut.yponnou.zelda.modele;

public class Guerrier extends Acteur {
    private Arme arme;

    public Guerrier(String nom, double coeurs, int x, int y, double vitesse, Map map, Environnement environnement, Arme arme) {
        super(nom, coeurs, x, y, vitesse, map, environnement);
        this.arme = arme;
    }

    public void attaquer(){
        Acteur a = verifEnnemiAcoter();
        if(a !=null){
            a.setCoeurs(arme.getPtsDegats());
        }
    }
    public Acteur verifEnnemiAcoter() {
        for (Acteur a : getEnvironnement().getActeurs()) {
            if (((getX() + 1) == a.getX()) || (getX() - 1 == a.getX()) || getY() + 1 == a.getY() || getY() - 1 == a.getY()) {
                return a;
            }
        }
        return null;
    }

    @Override
    void parler() {

    }
}
