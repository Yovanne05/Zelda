package universite_paris8.iut.yponnou.zelda.modele.acteurs;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.inventaire.Inventaire;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

public class Hero extends Guerrier {

    private final Inventaire inventaire;

    public Hero(double x, double y, Environnement environnement, Direction direction, Arme arme) {
        super(x, y, environnement, 10, direction, arme, 100);
        this.inventaire = new Inventaire(5, this);
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public Ennemi verifEnnemiAcoter(double distanceSeuil) {
        for (Acteur acteur : this.getEnvironnement().acteursProperty()) {
            if (acteur instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) acteur;
                if (estProcheDeActeur(ennemi, distanceSeuil)) {
                    return ennemi;
                }
            }
        }
        return null;
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
        Ennemi ennemiProche = verifEnnemiAcoter(100);

        if (getArme() instanceof ArmeDistance) {
            attaquerDistance();
        } else if (ennemiProche != null) {
            attaquerMelee(ennemiProche);
        }
    }

    public void attaquerDistance() {
        ArmeDistance armeDistance = (ArmeDistance) getArme();
        double dx = getDirection().getDx();
        double dy = getDirection().getDy();
        Direction d = new Direction(dx, dy); // Create a new direction to avoid side effects
        Fleche fleche = new Fleche(getPosition().getX(), getPosition().getY(), getEnvironnement(), d);
        armeDistance.setProjectile(fleche);
        armeDistance.utiliserArme();
    }

    public void attaquerMelee(Guerrier ennemi) {
        ArmeMelee armeMelee = (ArmeMelee) getArme();
        ennemi.seFaitAttaquer(armeMelee.getPtsDegats());
        if (ennemi.estMort()) {
            getEnvironnement().enleverActeur(ennemi);
        }
    }

    public boolean estProcheDeActeur(Acteur acteur, double distanceSeuil) {
        double distance = distance(acteur.getPosition());
        return distance <= distanceSeuil;
    }
}
