package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Paysans;
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

    public Environnement(Map map) {
        this.map = map;
        this.largeur = this.map.getLargeur()*Constante.TAILLECASEX;
        this.hauteur = this.map.getHauteur()*Constante.TAILLECASEY;
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

    public Hero heroEnv(){
        for(Acteur a:getLstActeurs()){
            if (a instanceof Hero){
                return (Hero) a;
            }
        }
        return null;
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
        for (Acteur a: acteurs){
            if(a instanceof Garde){
                ((Garde) a).deplacementEnRonde();
            }
        }
        for(int i = 0;i<projectiles.size();i++){
            if(projectiles.get(i) instanceof Fleche){
                System.out.println("Fleche");
                ((Fleche) projectiles.get(i)).utiliserFleche();
            }
        }
        Hero p =heroEnv();
        Paysans villageois = p.paysansProches();
        if (villageois != null) {
            double distance = distance(p.getPosition().getX(), p.getPosition().getY(), villageois.getPosition().getX(), villageois.getPosition().getY());
            if (distance <= 800) {
                showToucheA();
            } else {
                hideToucheA();
            }
        }
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private void showToucheA() {
        toucheA.setVisible(true);
    }

    private void hideToucheA() {
        toucheA.setVisible(false);
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

}
