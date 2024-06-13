package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Projectile;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

import java.util.ArrayList;

public class Environnement{
    private final Label toucheA = new Label("A");
    private final int largeur;
    private final int hauteur;
    private ObservableList<Acteur> acteurs = FXCollections.observableArrayList();
    private ObservableList<Objet> objets = FXCollections.observableArrayList();
    private ObservableList<Projectile> projectiles = FXCollections.observableArrayList();
    private Map map;
    private Paysan paysans;

    public Environnement(Map map) {
        this.map = map;
        this.largeur = this.map.getLargeur()*Constante.TAILLECASEX;
        this.hauteur = this.map.getHauteur()*Constante.TAILLECASEY;

    }

    public Hero heroEnv(){
        for(Acteur a :acteurs){
            if(a instanceof Hero){
                return (Hero) a;
            }
        }
        return null;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getLargeur() {
        return largeur;
    }
    public int getHauteur() {
        return hauteur;
    }

    public ObservableList<Acteur> acteursProperty() {
        return acteurs;
    }
    public void ajouterActeur(Acteur acteur) {
        acteurs.add(acteur);
    }
    public void enleverActeur(Acteur acteur) {
        acteurs.removeIf(a -> acteur.getId().equals(a.getId()));
        acteurs.removeIf(a -> acteur.getId().equals(a.getId()+"BarreVie"));
    }

    public ObservableList<Objet> objetsProperty() {
        return objets;
    }
    public void ajouterObjet(Objet objet) {
        objets.add(objet);
    }


    public void enleverObjet(Objet objet) {
        objets.remove(objet);
    }
    public void ajouterProjectile(Projectile p) {
        projectiles.add(p);
    }
    public void enleverProjectile(Projectile p) {
        projectiles.remove(p);
    }

    public Map getMap(){
        return map;
    }

    public boolean dansMap(double x, double y) {
        return x >= 0 && y >= 0 && x <= largeur-Constante.TAILLECASEX && y <= hauteur-Constante.TAILLECASEX;
    }

    public void toutLeMondeBouge(){
        ObservableList<Acteur> lstA= this.getActeurs();
        for (int i=0;i<lstA.size();i++) {
            if (lstA.get(i) instanceof Ennemi) {
                ((Ennemi) lstA.get(i)).deplacementEnnemi();
            }
        }
        for (int i = 0; i < this.getProjectiles().size(); i++) {
            if (this.getProjectiles().get(i) instanceof Fleche) {
                ((Fleche) this.getProjectiles().get(i)).utiliserFleche();
            }
        }
    }


    public ObservableList<Acteur> getActeurs() {
        return acteurs;
    }

    public ObservableList<Objet> getObjets() {
        return objets;
    }



    public ObservableList<Projectile> getProjectiles() {
        return projectiles;
    }

    public ArrayList<Acteur> getLstActeurs(){
        ArrayList<Acteur> lstA=new ArrayList<>();
        for(Acteur a: acteurs){
            lstA.add(a);
        }
        return lstA;
    }

    public Paysan paysansQuiParle(){
        for(Acteur a : acteurs){
            if(a instanceof Paysan){
                return (Paysan) a;
            }
        }
        return null;
    }
    public Vendeur obtenirVendeur(){
        for(Acteur a : acteurs){
            if(a instanceof Vendeur){
                return (Vendeur) a;
            }
        }
        return null;
    }

}
