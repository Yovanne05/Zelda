package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Hero extends Guerrier {

    private final ObservableList<Objet> inventaire = FXCollections.observableArrayList();
    private final int capaciteMax;

    public Hero(int x, int y, Environnement environnement, int dx, int dy, Arme arme) {
        super("Joseph", x, y, 100, 0.2, environnement, dx, dy, arme);
        capaciteMax = 5;
        inventaire.add(arme);
    }

    public ObservableList<Objet> getInventaire() {
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

    // méthode qui renvoie un objet Nourriture si l'inventaire du héro en possède.
    public Nourriture possedeNourritures(){
        for (Objet objet : inventaire) {
            if (objet instanceof Nourriture)
                return (Nourriture) objet;
        }
        return null;
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
        } else if (ob != null) {
            System.out.println("Inventaire complet !");
        } else {
            System.out.println("Aucun objets trouvés !");
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

    // méthode qui renvoie vrai si un objet se trouve à portée du hero
    private boolean verifObjetsAutour(Objet obj){
        {
            if (obj instanceof Nourriture) {
                return (this.getPosition().getY() - Constante.TAILLE16 <= obj.getPosition().getY() && obj.getPosition().getY() <= getPosition().getY() + Constante.TAILLE50
                        && this.getPosition().getX() - Constante.TAILLE16 <= obj.getPosition().getX() && obj.getPosition().getX() <= getPosition().getX() + Constante.TAILLE50);
            } else {
                return (this.getPosition().getY() - Constante.TAILLE32 <= obj.getPosition().getY() && obj.getPosition().getY() <= getPosition().getY() + Constante.TAILLE50
                        && this.getPosition().getX() - Constante.TAILLE32 <= obj.getPosition().getX() && obj.getPosition().getX() <= getPosition().getX() + Constante.TAILLE50);

            }
        }    }

    /* methode qui depose l'objet de l'inventaire du hero
     * Il genere des coordonnées aléatoire jusqu'a ce qu'elle soit bonne
     * càd qu'elle soit sur la map, qu'elle soit autour du hero et qu'elle ne traverse pas les obstacles
     */
    public void deposer(Objet objet){
        int objetX, objetY;
        Rectangle hitbox;
        do {
            do {
                if (objet instanceof Nourriture) {
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
            setArme(null);
        }
        objet.getPosition().getEnv().ajouterObjet(objet);
    }

    // méthode qui prends en paramètre des coordonnées x et y de type double et renvoie un rectangle rect placé autour du hero
    private Rectangle depotPossible(Objet objet, double x, double y){
        Rectangle rect;
        int longueurMin;
        int longueurMax = Constante.TAILLE32;

        if (objet instanceof Nourriture)
            longueurMin = Constante.TAILLE16;
        else // l'objet est une arme
            longueurMin = Constante.TAILLE32;

        rect = new Rectangle(x, y, longueurMin, longueurMin);
        // verifie qu'il n'y a pas de collision avec des obstacles et qu'il est au pied du hero
        if (!collisionAvecObstacle(rect) && auPied(x, y, longueurMin,longueurMax))
            return rect;
        return null;
    }

    // vérifie que les coordonnées de l'objet sont autour du hero
    private boolean auPied(double x, double y, int longueurMin, int longueurMax){
        return (x == getPosition().getX()-longueurMin && y == getPosition().getY()+ longueurMax) || (x == getPosition().getX()+longueurMax+10 && y == getPosition().getY()+ longueurMax);
    }

    private boolean verifPaysansAutour(Paysan p){
        return (this.getPosition().getY()-Constante.TAILLE50<= p.getPosition().getY() && p.getPosition().getY() <= getPosition().getY()+Constante.TAILLE50
                && this.getPosition().getX()-Constante.TAILLE50<= p.getPosition().getX() && p.getPosition().getX() <= getPosition().getX()+Constante.TAILLE50);
    }

    @Override
    public void attaquer() {
        Acteur e = this.verifEnnemiAcoter();
        if(this.getArme() instanceof ArmeDistance){
            Fleche f= new Fleche(getPosition().getX(),getPosition().getY(),getPosition().getEnv(), getDx(),getDy());
            ((ArmeDistance) this.getArme()).setProjectile(f);
            System.out.println("j'attaque");
            this.getArme().utiliser();

        }else if(e!=null){
            e.seFaitAttaquer(this.getArme().utiliser());
            if(e.getPv()==0){
                getPosition().getEnv().getActeurs().removeIf(a -> e.getId().equals(a.getId()));
            }
        }
        else
            System.out.println("Vous n'avez plus d'arme");
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
