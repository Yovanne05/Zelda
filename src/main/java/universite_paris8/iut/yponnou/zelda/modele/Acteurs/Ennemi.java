package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;


public abstract class Ennemi extends Guerrier {

    private int cpt =0;

    public Ennemi(String nom, double x, double y, int pv, double vitesse, Environnement environnement, int dx, int dy, Arme arme) {
        super(nom, x, y, pv, vitesse, environnement, dx, dy, arme);
    }
    public Hero verifHeroProx(){
        for (Acteur a : this.getPosition().getEnv().getLstActeurs()) {
            double dist=80;
            if ((Math.abs(getPosition().getX() - a.getPosition().getX()) <= dist && Math.abs(getPosition().getY() - a.getPosition().getY()) <= dist)) {
                if(a instanceof Hero){
                    return (Hero) a;
                }
            }
        }
        return null;
    }
    public abstract void deplacementEnnemi();



}