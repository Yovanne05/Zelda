package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;

public class Environnement {

    private int largeur;
    private int hauteur;
    private MapVue tilemap;
    private ObservableList<Acteur> acteurs = FXCollections.observableArrayList();
    private ObservableList<Objet> objets = FXCollections.observableArrayList();;
    private Map map;

    public Environnement(int largeur, int hauteur, Map map) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.map = map;
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
//        map.setTabNum(acteur);
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


    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }


    public Environnement(MapVue tilemap) {
        this.tilemap = tilemap;
    }

    public MapVue getTilemap() {
        return tilemap;
    }
}

