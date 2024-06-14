package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Armes.*;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Hero extends Guerrier {

    private final ObservableList<Objet> inventaire = FXCollections.observableArrayList();
    private final int capaciteMax;

    public Hero(int x, int y, Environnement environnement, int dx, int dy, Arme arme) {
        super("Joseph", x, y, 100, 0.2, environnement, dx, dy, arme);
        capaciteMax = 5;
//        inventaire.add(arme);
    }

    public ObservableList<Objet> inventaireProperty() {
        return inventaire;
    }

    public void guerison(){
        Nourriture aliment = possedeNourritures();
        if (aliment != null) {
            if (!pleineSante()) {
                setPv(getPv()+ aliment.getPv());
                System.out.println(getNom() + " a mangé " + aliment.getNom());
                inventaire.remove(aliment);
            }
            else
                System.out.println("Votre santé déjà complète !");
        }
        else
            System.out.println("Aucun aliments trouvés");
    }

    public void subitDegats(int degats){
        super.subitDegats(degats);
        System.out.println(getNom()+" a perdu "+degats+" pv");
    }

    public boolean pleineSante(){
        return getPv() == 100;
    }

    // méthode qui récupère un objet de la map
    public void recuperer(){
        Objet ob = objetsProches();
        if (ob != null && inventaire.size() != capaciteMax) {
            if (ob instanceof Arme)
                setArme((Arme)ob);
            inventaire.add(ob);
            ob.getPosition().getEnv().enleverObjet(ob);
            System.out.println("Objet récupéré !");
        }
        else if (inventaire.size() == capaciteMax)
            System.out.println("Inventaire complet !");
        else
            System.out.println("Aucun objets trouvés !");
    }

    /* methode qui depose l'objet de l'inventaire du hero
     * Il genere des coordonnées aléatoire jusqu'a ce qu'elle soit bonne
     * càd qu'elle soit sur la map, qu'elle soit autour du hero et qu'elle ne traverse pas les obstacles
     */
    public void deposer(Objet objet){
        int objetX, objetY;
        Rectangle hitbox;
        do {
            do {
                if (objet instanceof Nourriture || objet instanceof Clef) {
                    objetX = (int) (Math.random() * getPosition().getX() + Constante.TAILLE50 + Constante.TAILLE16 + 1) - Constante.TAILLE16;
                    objetY = (int) (Math.random() * getPosition().getY() + Constante.TAILLE50 + Constante.TAILLE16 + 1) - Constante.TAILLE16;
                }
                else {
                    objetX = (int) (Math.random() * getPosition().getX() + Constante.TAILLE50 + Constante.TAILLE32 + 1) - Constante.TAILLE32;
                    objetY = (int) (Math.random() * getPosition().getY() + Constante.TAILLE50 + Constante.TAILLE32 + 1) - Constante.TAILLE32;
                }
            }while (!getPosition().getEnv().dansMap(objetX,objetY));
            hitbox = depotPossible(objet,objetX,objetY);
        }while (hitbox == null);
        objet.getPosition().setX(objetX);
        objet.getPosition().setY(objetY);
        inventaire.remove(objet);
        if (objet instanceof Arme){
            if (this.possedeArme() == null)
                setArme(null);
            else
                setArme(this.possedeArme());
        }
        objet.getPosition().getEnv().ajouterObjet(objet);
    }

    // méthode qui renvoie un objet trouvé autour du hero
    public Objet objetsProches(){
        for(Objet obj : getPosition().getEnv().objetsProperty()){
            if (verifObjetsAutour(obj))
                return obj;
        }
        return null;
    }

    // méthode qui renvoie un objet Nourriture si l'inventaire du héro en possède.
    public Nourriture possedeNourritures(){
        for (Objet objet : inventaire) {
            if (objet instanceof Nourriture)
                return (Nourriture) objet;
        }
        return null;
    }


    // méthode qui renvoie un objet Arme si l'inventaire du héro en possède.
    public Arme possedeArme(){
        for (Objet objet : inventaire) {
            if (objet instanceof Arme) {
                return (Arme) objet;
            }
        }
        return null;
    }

    // méthode qui prends en paramètre des coordonnées x et y de type double de l'objet et renvoie un rectangle rect placé autour du hero
    private Rectangle depotPossible(Objet objet, double x, double y){
        Rectangle hitbox;
        int dimension;

        if (objet instanceof Nourriture || objet instanceof Clef)
            dimension = Constante.TAILLE16;
        else // l'objet est une arme
            dimension = Constante.TAILLE32;

        hitbox = new Rectangle(x,y,dimension,dimension);
        // verifie qu'il n'y a pas de collision avec des obstacles et qu'il est au pied du hero
        if (!collisionAvecObstacle(hitbox) && depotAutour(objet,x,y))
            return hitbox;
        return null;
    }

    // méthode qui renvoie vrai si un objet se trouve à portée du hero
    private boolean verifObjetsAutour(Objet obj){
        if (obj instanceof Nourriture || obj instanceof Clef) {
            return (this.getPosition().getY() - Constante.TAILLE16 <= obj.getPosition().getY() && obj.getPosition().getY() <= getPosition().getY() + Constante.TAILLE50
                    && this.getPosition().getX() - Constante.TAILLE16 <= obj.getPosition().getX() && obj.getPosition().getX() <= getPosition().getX() + Constante.TAILLE50);
        } else {
            return (this.getPosition().getY() - Constante.TAILLE32 <= obj.getPosition().getY() && obj.getPosition().getY() <= getPosition().getY() + Constante.TAILLE50
                    && this.getPosition().getX() - Constante.TAILLE32 <= obj.getPosition().getX() && obj.getPosition().getX() <= getPosition().getX() + Constante.TAILLE50);
        }
    }

    private boolean verifPaysansAutour(Paysan p){
        return (this.getPosition().getY()-Constante.TAILLE50<= p.getPosition().getY() && p.getPosition().getY() <= getPosition().getY()+Constante.TAILLE50
                && this.getPosition().getX()-Constante.TAILLE50<= p.getPosition().getX() && p.getPosition().getX() <= getPosition().getX()+Constante.TAILLE50);
    }

    // vérifie que les coordonnées de l'objet déposé sont autour du hero
    private boolean depotAutour(Objet objet, double x, double y){
        if (objet instanceof Nourriture || objet instanceof Clef) {
            return (this.getPosition().getY() - Constante.TAILLE16 <= y && y <= getPosition().getY() + Constante.TAILLE50
                    && this.getPosition().getX() - Constante.TAILLE16 <= x && x <= getPosition().getX() + Constante.TAILLE50);
        } else {
            return (this.getPosition().getY() - Constante.TAILLE32 <= y && y <= getPosition().getY() + Constante.TAILLE50
                    && this.getPosition().getX() - Constante.TAILLE32 <= x && x <= getPosition().getX() + Constante.TAILLE50);
        }
    }

    public boolean estProcheDePaysan(Paysan paysan, int distance) {
        if(paysan==null){
            return false;
        }
        return Math.abs(this.getPosition().getX() - paysan.getPosition().getX()) <= distance &&
                Math.abs(this.getPosition().getY() - paysan.getPosition().getY()) <= distance;
    }

    public boolean estProcheDeVendeur(Vendeur vendeur, int distance) {
        return Math.abs(this.getPosition().getX() - vendeur.getPosition().getX()) <= distance &&
                Math.abs(this.getPosition().getY() - vendeur.getPosition().getY()) <= distance;
    }


    @Override
    public void attaquer() {
        Acteur e = this.verifEnnemiAcoter();
        if(this.getArme() instanceof ArmeDistance){
            Fleche f= new Fleche(getPosition().getX(),getPosition().getY(),getPosition().getEnv(), getDx(),getDy());
            ((ArmeDistance) this.getArme()).setProjectile(f);
            System.out.println("j'ai tiré une flèche !!!");
            ((ArmeDistance)this.getArme()).utiliser();
        }
        if(e!=null){
            if (getArme() != null){
                e.seFaitAttaquer(((ArmeMelee) this.getArme()).getPtsDegats());
                if (e.getPv() == 0) {
                    getPosition().getEnv().acteursProperty().removeIf(a -> e.getId().equals(a.getId()));
                }
            }
            else
                System.out.println("Vous n'avez pas d'arme !");
        }
    }

    public void changeEnvArc(Environnement env){
        for(Objet o : inventaire){
            if (o instanceof ArcArme){
                o.getPosition().setEnv(env);
            }
        }
    }

    public void selectionObjet(int indexe) {
        if (indexe < inventaire.size()){
            Objet ob = inventaire.get(indexe);
            if(ob instanceof Nourriture n) {
                if (!pleineSante()) {
                    setPv(getPv() + n.getPv());
                    System.out.println(getNom() + " a mangé " + n.getNom());
                    inventaire.remove(n);
                } else
                    System.out.println("Votre santé déjà complète !");
            }
            else if(ob instanceof Arme ar){
                setArme(ar);
            }
            System.out.println("Objet selectionné !");
        }
        else
            System.out.println("Vous n'avez pas d'objets à cet emplacement !");
    }
}
