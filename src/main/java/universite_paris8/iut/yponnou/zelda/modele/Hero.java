package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;
import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;

import java.util.ArrayList;

public class Hero extends Acteur{

    private ArrayList<Objet> inventaire;

    public Hero(String nom, int pv, int x, int y, Map map, Environnement environnement) {
        super(nom, pv, x, y, 0.3,map, environnement);
        inventaire = new ArrayList<>(5);
    }

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }

    public Objet objetsProches(){
        int Xgauche = (getX()/ActeurVue.getTailleCaseX())-1;
        int Xdroite = (getX()/ActeurVue.getTailleCaseX())+1;
        int Yhaut = (getY()/ActeurVue.getTailleCaseY())-1;
        int Ybas = (getY()/ActeurVue.getTailleCaseY())+1;

        int actuelX = getX()/ActeurVue.getTailleCaseX();
        int actuelY = getY()/ActeurVue.getTailleCaseY();
        int objetX,objetY;

//        return ((Xgauche > 0 && getMap().getTabNum()[Xgauche][actuelY] == 2) || (Xdroite < getMap().getLargeur() && getMap().getTabNum()[Xdroite][actuelY] == 2)
//                || (Yhaut < getMap().getHauteur() && getMap().getTabNum()[actuelX][Yhaut] == 2) || (Ybas < getMap().getHauteur() && getMap().getTabNum()[actuelX][Ybas] == 2)
//                || Xgauche > 0 && Yhaut > 0 && getMap().getTabNum()[Xgauche][Yhaut] == 2) || (Xdroite < getMap().getLargeur() && Yhaut > 0 && getMap().getTabNum()[Xdroite][Yhaut] == 2)
//                || (Xgauche > 0 && Ybas < getMap().getHauteur() && getMap().getTabNum()[Xgauche][Ybas] == 2) || (Xdroite < getMap().getLargeur() && Ybas < getMap().getHauteur() && getMap().getTabNum()[Xdroite][Ybas] == 2);
        for(Objet obj : getEnvironnement().getObjets()){
            objetX = obj.getX()/ObjetVue.getTailleCaseX();
            objetY = obj.getY()/ObjetVue.getTailleCaseY();
            if ((Xgauche == objetX && actuelY == objetY) || (Xdroite == objetX && actuelY == objetY)
                || (actuelX == objetX && Yhaut == objetY) || (actuelX == objetX && Ybas == objetY)
                || (Xgauche == objetX && Yhaut == objetY) || (Xgauche == objetX && Ybas == objetY)
                || (Xdroite == objetX && Yhaut == objetY) || (Xdroite == objetX && Ybas == objetY)){
                return obj;
            }
        }
        return null;
    }


    public void recuperer(Objet objet){
        int objetX = objet.getX()/ ObjetVue.getTailleCaseX();
        int objetY = objet.getY()/ ObjetVue.getTailleCaseY();

        inventaire.add(objet);
        getMap().setIndexTab(objetX,objetY,0);
        objet.getEnvironnement().enleverObjet(objet);
        objet.setMap(getMap());
    }
    @Override
    void parler() {

    }
}
