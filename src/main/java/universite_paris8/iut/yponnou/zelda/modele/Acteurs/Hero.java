package universite_paris8.iut.yponnou.zelda.modele.Acteurs;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.*;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Hero extends Acteur {

    private final ObservableList<Objet> inventaire = FXCollections.observableArrayList();
    private final int capaciteMax;

    public Hero(String nom, int x, int y, Environnement environnement) {
        super(nom, x, y, 100, 10, environnement);
        capaciteMax = 5;
    }

    public ObservableList<Objet> getInventaire() {
        return inventaire;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void guerison(int pv){
        setPv(getPv()+pv);
    }
    public void subitDegats(int degats){
        setPv(getPv()-degats);
        System.out.println(getNom()+" a perdu "+degats+" pv");
    }

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

    // méthode qui renvoie un objet trouvé autour du hero
    public Objet objetsProches(){
        for(Objet obj : getPosition().getEnv().getObjets()){
            if (verifObjetsAutour(obj))
                return obj;
        }
        return null;
    }

    // méthode qui récupère un objet de la map
    public void recuperer(Objet objet){
        inventaire.add(objet);
        objet.getPosition().getEnv().enleverObjet(objet);
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
                objetX = (int)Math.abs(Math.random() * (getPosition().getX()+2* Constante.TAILLECASEX +1)) - Constante.TAILLECASEX;
                objetY = (int)Math.abs(Math.random() * (getPosition().getY()+2*Constante.TAILLECASEY+1)) - Constante.TAILLECASEY;
            }while (!getPosition().getEnv().dansMap(objetX,objetY));
            hitbox = depotPossible(objetX,objetY);
        }while (hitbox == null);

        objet.getPosition().setX(objetX);
        objet.getPosition().setY(objetY);
        inventaire.remove(objet);
        objet.getPosition().getEnv().ajouterObjet(objet);
    }

    // méthode qui renvoie vrai si un objet se trouve à portée du hero
    private boolean verifObjetsAutour(Objet obj){
        return (this.getPosition().getY()-Constante.TAILLECASEY<= obj.getPosition().getY() && obj.getPosition().getY() <= getPosition().getY()+Constante.TAILLECASEY
                && this.getPosition().getX()-Constante.TAILLECASEX<= obj.getPosition().getX() && obj.getPosition().getX() <= getPosition().getX()+Constante.TAILLECASEX);
    }

    // méthode qui prends en paramètre des coordonnées x et y de type double et renvoie un rectangle rect placé autour du hero
    private Rectangle depotPossible(double x, double y){
        Rectangle rect = new Rectangle(x, y, Constante.TAILLECASEX, Constante.TAILLECASEY);
            // verifie qu'il n'y a pas de collision avec des obstacles
        if(!collisionAvecObstacle(rect)
           && ( // vérifie que les coordonnées sont autour du hero
               ((Math.abs(getPosition().getX()-x) == Constante.TAILLECASEX && Math.abs(getPosition().getY()-y) <= Constante.TAILLECASEY)
               || (Math.abs(getPosition().getY()-y) == Constante.TAILLECASEY) && Math.abs(getPosition().getX()-x) <= Constante.TAILLECASEX))
               )
        {
            return rect;
        }
        return null;
    }
    @Override
    void parler() {

    }
}
