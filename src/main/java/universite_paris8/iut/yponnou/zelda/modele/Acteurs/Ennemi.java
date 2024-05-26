package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;


public abstract class Ennemi extends Guerrier {

    private int cpt =0;
    public Ennemi(String nom, double coeurs, int x, int y, double vitesse, Environnement environnement, Arme arme) {
        super(nom, coeurs, x, y, vitesse, environnement, arme);
    }
    public Hero verifHeroProx(){
        for (Acteur a : getEnvironnement().getActeurs()) {
            if (((getX() + 1) == a.getX()) || (getX() - 1 == a.getX()) || getY() + 1 == a.getY() || getY() - 1 == a.getY()) {
                if(a instanceof Hero){
                    return (Hero) a;
                }
            }
        }
        return null;
    }
    public void deplacementEnRonde() {
        int dx = 0;
        int dy = 0;
        if(cpt<50){
            cpt++;
            dx=1;
        }else{
            cpt++;
            dx=-1;
        }
        if(cpt>99){
            cpt=0;
        }
        deplacement(dx, dy);

    }



}
