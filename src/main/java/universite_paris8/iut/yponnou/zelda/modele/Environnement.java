package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.controleurs.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;

import java.util.ArrayList;

public class Environnement extends Constante {

    private final int largeur;
    private final int hauteur;
    private ObservableList<Acteur> acteurs;
    private ObservableList<Objet> objets;
    private Map map;

    public Environnement(Map map) {
        this.map = map;
        this.acteurs = FXCollections.observableArrayList();
        this.objets = FXCollections.observableArrayList();
        this.largeur = this.map.getLargeur()* TAILLECASEX;
        this.hauteur = this.map.getHauteur()* TAILLECASEY;
    }

    public int getLargeur() {
        return largeur;
    }
    public int getHauteur() {
        return hauteur;
    }

    public ObservableList<Acteur> getActeurs() {
        return acteurs;
    }
    public void ajouterActeur(Acteur acteur) {
        acteurs.add(acteur);
    }
    public void enleverActeur(Acteur acteur) {
        acteurs.remove(acteur);
    }

    public ObservableList<Objet> getObjets() {
        return objets;
    }
    public void ajouterObjet(Objet objet) {
        objets.add(objet);
    }
    public void enleverObjet(Objet objet) {
        objets.remove(objet);
    }

    public ArrayList<Acteur> getLstActeurs(){
        ArrayList<Acteur> lstA=new ArrayList<>();
        for(Acteur a: acteurs){
            lstA.add(a);
        }
        return lstA;
    }

    public Map getMap(){
        return map;
    }

    public boolean dansMap(double x, double y) {
        return x >= 0 && y >= 0 && x <= largeur-TAILLECASEX && y <= hauteur-TAILLECASEY;
    }

}