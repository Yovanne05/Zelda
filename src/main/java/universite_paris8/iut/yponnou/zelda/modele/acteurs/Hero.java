package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.action.ActionComposite;
import universite_paris8.iut.yponnou.zelda.modele.action.ComboFoncerAttaque;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.inventaire.Inventaire;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import java.util.ArrayList;

public class Hero extends Guerrier {

    /**
     * La classe Hero représente le personnage principal du jeu contrôlé par le joueur.
     * Elle gère les points de vie, la stamina, l'inventaire, et diverses actions spécifiques
     * comme les attaques, la récupération d'objets, et la guérison. Elle inclut également la
     * gestion des combos d'actions pour des interactions complexes.
     */


    private final Inventaire inventaire;
    private ArrayList<ActionComposite> lstCombo;
    private DoubleProperty stamina; // Ajout de l'attribut stamina

    public Hero(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 10, direction, arme, 100);
        this.inventaire = new Inventaire(5, this);
        this.lstCombo = new ArrayList<>();
        this.stamina = new SimpleDoubleProperty(100);  // 100% de stamina au départ
        ajoutComboDeBase();
    }
    public DoubleProperty staminaProperty() {
        return stamina;
    }

    public void ajoutComboDeBase() {
        ComboFoncerAttaque comboFoncerAttaque = new ComboFoncerAttaque();
        this.lstCombo.add(comboFoncerAttaque);
    }

    public void realiserFoncerEtAttaque() {
        if (this.getStamina() >= 50) {
            for (ActionComposite action : lstCombo) {
                if (action instanceof ComboFoncerAttaque) {
                    action.executer(this);
                    this.setStamina(this.getStamina() - 50);
                }
            }
        }
    }

    public double getStamina() {
        return stamina.get();
    }
    public void setStamina(double stamina) {
        this.stamina.set(stamina);
    }

    public void augmenterStamina() {
        setStamina(Math.min(getStamina()+0.5,100));
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public boolean guerison() {
        Nourriture aliment = inventaire.possedeNourriture();
        if (aliment == null) {
            return false;
        }
        if (!pleineSante()) {
            inventaire.consommerNourriture(aliment);
            return true;
        }
        return false;
    }

    public boolean pleineSante() {
        return getPv() >= 100;
    }

    public void recuperer() {
        Objet ob = objetsProches();
        if (ob != null) {
            if (!inventaire.estPlein() && estObjetProche(ob)) {
                inventaire.ajouterObjet(ob);
            }
        }
    }

    private boolean estObjetProche(Objet ob) {
        double distance = distance(ob.getPosition());
        return distance <= 500;
    }

    public Objet objetsProches() {
        for (Objet obj : getEnvironnement().objetsProperty()) {
            if (estDansRayon(obj.getPosition(), 30)) {
                return obj;
            }
        }
        return null;
    }

    private boolean estDansRayon(Position pos, int distanceSeuil) {
        return Math.abs(this.getPosition().getX() - pos.getX()) <= distanceSeuil &&
                Math.abs(this.getPosition().getY() - pos.getY()) <= distanceSeuil;
    }

    public void deposer(Objet objet) {
        if(objet instanceof Arme){
            ((Arme) objet).setProprietaire(null);
        }
        inventaire.deposer(objet);
    }

    public void changeEnvObjets(Environnement env) {
        inventaire.changeEnvObjets(env);
    }

    public void selectionObjet(int index) {
        inventaire.selectionObjet(index);
    }

    public boolean possedeClef() {
        return inventaire.possedeClef();
    }

    public void attaquer() {
        try {
            getArme().utiliserArme();
        }catch (Exception e){
            System.out.println("Pas d'arme en mains");
        }

    }
    public boolean estProcheDeActeur(Acteur acteur, double distanceSeuil) {
        double distance = distance(acteur.getPosition());
        return distance <= distanceSeuil;
    }
}