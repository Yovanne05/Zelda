package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.controleurs.Dimension;

public class Environnement implements Dimension{

    private final int largeur;
    private final int hauteur;
    private ObservableList<Acteur> acteurs = FXCollections.observableArrayList();
    private ObservableList<Objet> objets = FXCollections.observableArrayList();
    private Map map;

    public Environnement(Map map) {
        this.map = map;
        this.largeur = this.map.getLargeur()* getTailleCaseX();
        this.hauteur = this.map.getHauteur()* getTailleCaseY();
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

    public Map getMap(){
        return map;
    }

    public boolean dansMap(double x, double y) {
        return x >= 0 && y >= 0 && x <= largeur-getTailleCaseX() && y <= hauteur-getTailleCaseY();
    }

}
