package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;


public abstract class Environnement{
    private final int largeur;
    private final int hauteur;
    private ObservableList<Acteur> acteurs = FXCollections.observableArrayList();
    private ObservableList<Objet> objets = FXCollections.observableArrayList();
    private Map map;
    private Hero hero;

    public Environnement(Map map, Hero hero) {
        this.map = map;
        this.hero = hero;
        this.largeur = this.map.getLargeur()*Constante.TAILLE50;
        this.hauteur = this.map.getHauteur()*Constante.TAILLE50;
    }

    public Map getMap(){
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public Hero getHero() {
        return hero;
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
        acteurs.removeIf(a -> acteur.getId().equals(a.getId()+"BarreVie"));// pour les ennemis
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

    public Hero heroEnv(){
        for(Acteur a :acteurs){
            if(a instanceof Hero){
                return (Hero) a;
            }
        }
        return null;
    }

    public boolean dansMap(double x, double y) {
        return x >= 0 && y >= 0 && x <= largeur-Constante.TAILLE50 && y <= hauteur-Constante.TAILLE50;
    }

    public void toutLeMondeBouge(){
        for (int i=0; i<acteurs.size(); i++) {
            if (acteurs.get(i) instanceof Ennemi) {
                ((Ennemi) acteurs.get(i)).deplacementEnnemi();
            }
            else if (acteurs.get(i) instanceof Fleche) {
                ((Fleche) acteurs.get(i)).utiliserFleche();
            }
        }
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

    public abstract void creationEnvironnement();

    @Override
    public String toString() {
        for(int i=0;i<map.getTabNum().length;i++){
            for(int j=0;j<map.getTabNum()[0].length;j++){
                System.out.print(map.getTabNum()[i][j]+" ");
            }
            System.out.println("");
        }
        return "Environnement{" +
                ", map=" + map.getTabNum() +
                '}';
    }

}