package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.controleurs.ObservateurActeurs;
import universite_paris8.iut.yponnou.zelda.controleurs.ObservateurObjets;

import java.util.ArrayList;

public class Hero extends Acteur{

    private Inventaire inventaire;

    public Hero(String nom, int pv, int x, int y, Map map, Environnement environnement) {
        super(nom, pv, x, y, 10,map, environnement);
        inventaire = new Inventaire(5);
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public Objet objetsProches(){
        double objetX,objetY;

        for(Objet obj : getEnvironnement().getObjets()){
            objetX = obj.getX()* ObservateurObjets.getTailleCaseX();
            objetY = obj.getY()* ObservateurObjets.getTailleCaseY();
            if (this.getY()- ObservateurActeurs.getTailleCaseY()<= objetY && objetY <= getY()+ ObservateurActeurs.getTailleCaseY()
                && this.getX()- ObservateurActeurs.getTailleCaseX()<= objetX && objetX <= getX()+ ObservateurActeurs.getTailleCaseX()
            ){
                return obj;
            }
        }
        return null;
    }


    public void recuperer(Objet objet){
        int objetX = (int)objet.getX();
        int objetY = (int)objet.getY();

        inventaire.ajouterObjet(objet);
        getMap().setIndexTab(objetX,objetY,0);
        objet.getEnvironnement().enleverObjet(objet);
        objet.setMap(getMap());
    }
    @Override
    void parler() {

    }
}
