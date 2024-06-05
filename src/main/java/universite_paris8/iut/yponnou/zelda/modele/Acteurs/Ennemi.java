package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.controleurs.ObservateurBarreDeVie;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public abstract class Ennemi extends Guerrier {

    private int cpt = 0;
    public Ennemi(String nom, double x, double y, int pv, double vitesse, Environnement environnement, Arme arme) {
        super(nom, x, y, pv, vitesse, environnement, arme);
    }

    public void initialisationEnnemi(Pane pane){
        pvProperty().addListener(new ObservateurBarreDeVie(this,pane));
        setPv(120);
    }

    public Hero verifHeroProx(){
        for (Acteur a : getPosition().getEnv().acteursProperty()) {
            if (((getPosition().getX() + 1) == a.getPosition().getX()) || (getPosition().getX() - 1 == a.getPosition().getX()) || getPosition().getY() + 1 == a.getPosition().getY() || getPosition().getY() - 1 == a.getPosition().getY()) {
                if(a instanceof Hero){
                    return (Hero) a;
                }
            }
        }
        return null;
    }
    public void deplacementEnRonde() {
        int dx;
        int dy = 0;
        if(cpt<500){
            cpt++;
            dx=1;
        }else{
            cpt++;
            dx=-1;
        }
        if(cpt>999){
            cpt=0;
        }
        deplacement(dx, dy);

    }

}
