package universite_paris8.iut.yponnou.zelda.modele.environnements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;


public class Environnement{

    /**
     * Classe représentant l'environnement de jeu. Un environnement contient la carte du jeu, les acteurs
     * (comme le héros, les ennemis, etc.) et les objets présents dans le jeu.
     */

    private static Environnement uniqueInstance=null;
    private ObservableList<Acteur> acteurs = FXCollections.observableArrayList();
    private ObservableList<Objet> objets = FXCollections.observableArrayList();

    private int largeur;
    private int hauteur;
    private Map map;

    private CreationEnv creationEnv;
    private Hero hero;

    public Environnement() {
        this.map = null;
        this.hero = null;
        this.largeur = 0;
        this.hauteur = 0;
        creationEnv = null;
    }

    public void miseEnPlaceEnv(Map map, Hero hero) {
        this.map = map;
        this.hero = hero;
        this.largeur = this.map.getLargeur()*Constante.TAILLE50;
        this.hauteur = this.map.getHauteur()*Constante.TAILLE50;
        creationEnv = null;
    }

    public static Environnement getInstance() {
        if(uniqueInstance==null) {
            uniqueInstance= new Environnement();
        }
        return uniqueInstance;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ObservableList<Acteur> getActeurs() {
        return acteurs;
    }

    public ObservableList<Objet> getObjets() {
        return objets;
    }
    public Map getMap(){
        return map;
    }

    public void creationMap(){
        creationEnv.creationEnvironnement(this);
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
        this.objetsProperty().add(objet);
    }
    public void enleverObjet(Objet objet) {
        this.objetsProperty().remove(objet);
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
            Acteur a = acteurs.get(i);
            if(a!=heroEnv()){
                a.deplacement();
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

    public CreationEnv getCreationEnv() {
        return creationEnv;
    }

    public void setCreationEnv(CreationEnv creationEnv) {
        this.creationEnv = creationEnv;
    }

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

    public void heroChangeEnv(int x, int y){
        hero.getPosition().setX(x);
        hero.getPosition().setY(y);
        hero.getDirection().setDx(0);
        hero.getDirection().setDy(0);
    }

    public boolean verifEnnemiMort() {
        if (creationEnv instanceof CreationDonjon) {
            return acteurs.stream().noneMatch(acteur -> acteur instanceof Boss);
        }
        return false;
    }
}