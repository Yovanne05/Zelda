package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.action.ActionComposite;
import universite_paris8.iut.yponnou.zelda.modele.action.ComboFoncerAttaque;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.armes.decorator.ArmeDistanceFeu;
import universite_paris8.iut.yponnou.zelda.modele.armes.decorator.ArmePouvoir;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.inventaire.Inventaire;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

import java.util.ArrayList;

public class Hero extends Guerrier {

    private final Inventaire inventaire;
    private ArrayList<ActionComposite> lstCombo;

    public Hero(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 10, direction, arme, 100);
        this.inventaire = new Inventaire(5, this);
        this.lstCombo = new ArrayList<>();
        ajoutComboDeBase();
    }

    public void ajoutComboDeBase(){
        ComboFoncerAttaque comboFoncerAttaque = new ComboFoncerAttaque();
        this.lstCombo.add(comboFoncerAttaque);
    }

    public void realiserFoncerEtAttque(){
        for(ActionComposite action : lstCombo){
            if(action instanceof ComboFoncerAttaque){
                action.executer(this);
            }
        }
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
                if(ob instanceof Arme){
                    ((Arme) ob).setProprietaire(this);
                    ((Arme) ob).setPosition(this.getPosition());
                }
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
