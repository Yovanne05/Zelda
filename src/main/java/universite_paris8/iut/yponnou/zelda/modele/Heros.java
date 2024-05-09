package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;

import java.util.ArrayList;

public class Heros extends Acteur{

    private ArrayList<Objet> inventaire;

    public Heros(String nom, int pv, int x, int y, Map map) {
        super(nom, pv, x, y, 0.3,map);
        inventaire = new ArrayList<>(5);
    }

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }

    public boolean objetsProches(){
        int Xgauche = (getX()/ActeurVue.getTailleCaseX())-1;
        int Xdroite = (getX()/ActeurVue.getTailleCaseX())+1;
        int Yhaut = (getY()/ActeurVue.getTailleCaseY())-1;
        int Ybas = (getY()/ActeurVue.getTailleCaseY())+1;

        int actuelX = getX()/ActeurVue.getTailleCaseX();
        int actuelY = getY()/ActeurVue.getTailleCaseY();

        return ((Xgauche > 0 && getMap().getTabNum()[Xgauche][actuelY] == 2) || (Xdroite < getMap().getLargeur() && getMap().getTabNum()[Xdroite][actuelY] == 2)
                || (Yhaut < getMap().getHauteur() && getMap().getTabNum()[actuelX][Yhaut] == 2) || (Ybas < getMap().getHauteur() && getMap().getTabNum()[actuelX][Ybas] == 2)
                || Xgauche > 0 && Yhaut > 0 && getMap().getTabNum()[Xgauche][Yhaut] == 2) || (Xdroite < getMap().getLargeur() && Yhaut > 0 && getMap().getTabNum()[Xdroite][Yhaut] == 2)
                || (Xgauche > 0 && Ybas < getMap().getHauteur() && getMap().getTabNum()[Xgauche][Ybas] == 2) || (Xdroite < getMap().getLargeur() && Ybas < getMap().getHauteur() && getMap().getTabNum()[Xdroite][Ybas] == 2);
    }


    public void recuperer(Objet objet){
        inventaire.add(objet);
//        objet.getMap().getTabNum()[getX()/objet.getMap().getTabNum().length][getY()/objet.getMap().getTabNum()[0].length] = 0;
        objet.getMap().setIndexTab(getX()/ ObjetVue.getTailleCaseX(),getY()/ObjetVue.getTailleCaseY(),0);
        objet.setMap(getMap());
    }
    @Override
    void parler() {

    }
}
