
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Hitbox;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.PositionEnv;


public class Hero extends Guerrier {

    private final ObservableList<Objet> inventaire = FXCollections.observableArrayList();
    private final int capaciteMax;

    public Hero(double x, double y, Environnement environnement, String nom, PositionEnv position, double vitesse, Direction direction, Arme arme) {
        super(x, y, environnement, nom, position, vitesse, direction, arme, 100);
        this.capaciteMax = 5;
    }

    public ObservableList<Objet> inventaireProperty() {
        return inventaire;
    }

    public Ennemi verifEnnemiAcoter(double distanceSeuil) {
        for (Acteur acteur : this.getPosition().getEnv().acteursProperty()) {
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
        Nourriture aliment = possedeNourritures();
        if (aliment == null) {
            System.out.println("Aucun aliment trouvé");
            return false;
        }
        if (!pleineSante()) {
            consommerNourriture(aliment);
            return true;
        }
        System.out.println("Votre santé est déjà complète !");
        return false;
    }

    public void subitDegats(int degats){
        super.subitDegats(degats);
        System.out.println(getNom()+" a perdu "+degats+" pv");
    }

    public boolean pleineSante(){
        return getPv() == 100;
    }

    public void recuperer() {
        Objet ob = objetsProches();
        if (ob != null) {
            if (inventaire.size() < capaciteMax) {
                if (estObjetProche(ob)) {
                    ajouterObjet(ob);
                } else {
                    System.out.println("L'objet n'est pas à portée !");
                }
            } else {
                System.out.println("Inventaire complet !");
            }
        } else {
            System.out.println("Aucun objet trouvé !");
        }
    }

    private boolean estObjetProche(Objet ob) {
        double distance = distance(ob.getPositionEnv());
        return distance <= 500;
    }

    /* methode qui depose l'objet de l'inventaire du hero
     * Il genere des coordonnées aléatoire jusqu'a ce qu'elle soit bonne
     * càd qu'elle soit sur la map, qu'elle soit autour du hero et qu'elle ne traverse pas les obstacles
     */
    public void deposer(Objet objet) {
        Position posAleatoire = genererPositionAleatoire(objet);

        while (!estPositionValide(posAleatoire)) {
            posAleatoire = genererPositionAleatoire(objet);
        }

        Hitbox hitbox = depotPossible(objet, posAleatoire);
        while (hitbox == null) {
            posAleatoire = genererPositionAleatoire(objet);
            hitbox = depotPossible(objet, posAleatoire);
        }

        placerObjet(objet, posAleatoire.getX(), posAleatoire.getY());
    }

    public int distanceMaxPossibe(){
        return 30;
    }

    public Position genererPositionAleatoire(Objet objet) {
        int taille = distanceMaxPossibe();
        Position posAleatoire;
        int objetX, objetY;
        do {
            objetX = (int) (Math.random() * (900 - taille)); //50 = limite taille autour
            objetY = (int) (Math.random() * (900 - taille));
            posAleatoire = new Position(objetX, objetY);
        } while (!estPositionValide(posAleatoire));

        return posAleatoire;
    }

    public boolean estPositionValide(Position p) {
        return getPosition().getEnv().dansMap(p.getX(), p.getY());
    }

    private void placerObjet(Objet objet, double x, double y) {
        objet.getPositionEnv().setX(x);
        objet.getPositionEnv().setY(y);
        inventaire.remove(objet);
        if (objet instanceof Arme) {
            mettreAJourArme();
        }
        objet.getPositionEnv().getEnv().ajouterObjet(objet);
    }

    private void mettreAJourArme() {
        if (this.possedeArme() == null) {
            setArme(null);
        } else {
            setArme(this.possedeArme());
        }
    }

    // méthode qui renvoie un objet trouvé autour du hero
    public Objet objetsProches(){
        for(Objet obj : getPosition().getEnv().objetsProperty()){
            if (verifObjetsAutour(obj))
                return obj;
        }
        return null;
    }

    public boolean possedeClef(){
        for (Objet objet : inventaire) {
            if (objet instanceof Clef)
                return true;
        }
        return false;
    }

    public Nourriture possedeNourritures(){
        for (Objet objet : inventaire) {
            if (objet instanceof Nourriture)
                return (Nourriture) objet;
        }
        return null;
    }


    public Arme possedeArme(){
        for (Objet objet : inventaire) {
            if (objet instanceof Arme) {
                return (Arme) objet;
            }
        }
        return null;
    }


    private Hitbox creerHitboxObjet(Objet objet, double x, double y) {
        int taille = distanceMaxPossibe();
        return new Hitbox(x, y, taille, taille);
    }

    private Hitbox depotPossible(Objet objet, Position position) {
        Hitbox hitbox = creerHitboxObjet(objet, position.getX(), position.getY());
        if (!collisionAvecObstacle(hitbox) && depotAutour(objet, position)) {
            return hitbox;
        }
        return null;
    }

    private boolean estDansRayon(Position pos, int distanceSeuil) {
        return Math.abs(this.getPosition().getX() - pos.getX()) <= distanceSeuil &&
                Math.abs(this.getPosition().getY() - pos.getY()) <= distanceSeuil;
    }


    private boolean verifObjetsAutour(Objet obj) {
        int distance = distanceMaxPossibe();
        return estDansRayon(obj.getPositionEnv(), distance);
    }

    private boolean verifPaysansAutour(Paysan p) {
        return estDansRayon(p.getPosition(), Constante.TAILLE50);
    }

    private boolean depotAutour(Objet objet, Position position) {
        int taille = distanceMaxPossibe();
        return estDansRayon(position, taille);
    }

    public boolean estProcheDePersonnage(Acteur personnage, int distance) {
        if (personnage == null) {
            return false;
        }
        return estDansRayon(personnage.getPosition(),distance);
    }

    public boolean estProcheDePaysan(Paysan paysan, int distance) {
        return estProcheDePersonnage(paysan,distance);
    }

    public boolean estProcheDeVendeur(Vendeur vendeur, int distance) {
        return estProcheDePersonnage(vendeur,distance);
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
        int dx = getDirection().getDx();
        int dy = getDirection().getDy();
        Direction d = new Direction(dx,dy); //Direction différente pour ne pas que la direction soit la même que celle de l'héro (sinon gros bug)
        Fleche fleche = new Fleche(getPosition().getX(), getPosition().getY(), getPosition().getEnv(),d);
        armeDistance.setProjectile(fleche);
        armeDistance.utiliser();
    }

    public void attaquerMelee(Guerrier ennemi) {
        ArmeMelee armeMelee = (ArmeMelee) getArme();
        ennemi.seFaitAttaquer(armeMelee.getPtsDegats());
        if (ennemi.estMort()) {
            getPosition().getEnv().acteursProperty().removeIf(a -> ennemi.getId().equals(a.getId()));
        }
    }

    public void changeEnvObjets(Environnement env){
        for(Objet o : inventaire){
            o.getPositionEnv().setEnv(env);
        }
    }

    public void ajouterObjet(Objet o){
        inventaire.add(o);
        o.getPositionEnv().getEnv().enleverObjet(o);
    }

    public void selectionObjet(int index) {
        if (index < inventaire.size()) {
            Objet objet = inventaire.get(index);
            if (objet instanceof Nourriture) {
                consommerNourriture((Nourriture) objet);
            } else if (objet instanceof Arme) {
                equiperArme((Arme) objet);
            }
        }
    }

    private void consommerNourriture(Nourriture nourriture) {
        if (!pleineSante()) {
            setPv(getPv() + nourriture.getPv());
            inventaire.remove(nourriture);
        }
    }
    private void equiperArme(Arme arme) {
        setArme(arme);
    }
}
