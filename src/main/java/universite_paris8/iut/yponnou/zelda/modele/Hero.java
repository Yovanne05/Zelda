package universite_paris8.iut.yponnou.zelda.modele;

import javafx.scene.shape.Rectangle;

public class Hero extends Acteur{

    private Inventaire inventaire;

    public Hero(String nom, int pv, int x, int y, Environnement environnement) {
        super(nom, pv, x, y, 10, environnement);
        inventaire = new Inventaire(5);
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    // méthode qui renvoie un objet trouvé autour du hero
    public Objet objetsProches(){
        for(Objet obj : getEnvironnement().getObjets()){
            if (verifObjetsAutour(obj)){
                return obj;
            }
        }
        return null;
    }

    // méthode qui récupère un objet de la map
    public void recuperer(Objet objet){
        inventaire.ajouterObjet(objet);
        objet.getEnvironnement().enleverObjet(objet);
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
                objetX = (int)Math.abs(Math.random() * (getX()+2*getTailleCaseX()+1)) - getTailleCaseX();
                objetY = (int)Math.abs(Math.random() * (getY()+2*getTailleCaseY()+1)) - getTailleCaseY();
            }while (!getEnvironnement().dansMap(objetX,objetY));
            hitbox = depotPossible(objetX,objetY);
        }while (hitbox == null);

        objet.setX(objetX);
        objet.setY(objetY);
        inventaire.deposerObjet(objet);
        objet.getEnvironnement().ajouterObjet(objet);
    }

    // méthode qui renvoie vrai si un objet se trouve à portée du hero
    public boolean verifObjetsAutour(Objet obj){
        return (this.getY()-getTailleCaseY()<= obj.getY() && obj.getY() <= getY()+getTailleCaseY()
                && this.getX()-getTailleCaseX()<= obj.getX() && obj.getX() <= getX()+getTailleCaseX());
    }

    // méthode qui prends en paramètre des coordonnées x et y de type double et renvoie un rectangle rect placé autour du hero
    public Rectangle depotPossible(double x, double y){
        Rectangle rect = new Rectangle(x, y, getTailleCaseX(), getTailleCaseY());
            // verifie qu'il n'y a pas de collision avec des obstacles
        if(!collisionAvecObstacle(rect)
           && ( // vérifie que les coordonnées sont autour du hero
               ((Math.abs(getX()-x) == getTailleCaseX() && Math.abs(getY()-y) <= getTailleCaseY())
               || (Math.abs(getY()-y) == getTailleCaseY()) && Math.abs(getX()-x) <= getTailleCaseX()))
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
