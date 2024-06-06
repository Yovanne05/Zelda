package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.controleurs.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeDistance;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Inventaire;
import universite_paris8.iut.yponnou.zelda.modele.Objet;


public class Hero extends Guerrier {

    private Inventaire inventaire;

    public Hero(String nom, double coeurs, double x, double y, double vitesse, Environnement environnement, int dx, int dy, Arme arme) {
        super(nom, coeurs, x, y, vitesse, environnement, dx, dy, arme);
        inventaire=new Inventaire(5);
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
                objetX = (int)Math.abs(Math.random() * (getX()+2* Constante.TAILLECASEX+1)) - Constante.TAILLECASEX;
                objetY = (int)Math.abs(Math.random() * (getY()+2*Constante.TAILLECASEY+1)) - Constante.TAILLECASEY;
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
        return (this.getY()-Constante.TAILLECASEY<= obj.getY() && obj.getY() <= getY()+Constante.TAILLECASEY
                && this.getX()-Constante.TAILLECASEX<= obj.getX() && obj.getX() <= getX()+Constante.TAILLECASEX);
    }

    // méthode qui prends en paramètre des coordonnées x et y de type double et renvoie un rectangle rect placé autour du hero
    public Rectangle depotPossible(double x, double y){
        Rectangle rect = new Rectangle(x, y, Constante.TAILLECASEX, Constante.TAILLECASEY);
        // verifie qu'il n'y a pas de collision avec des obstacles
        if(!collisionAvecObstacle(rect)
                && ( // vérifie que les coordonnées sont autour du hero
                ((Math.abs(getX()-x) == Constante.TAILLECASEX && Math.abs(getY()-y) <= Constante.TAILLECASEY)
                        || (Math.abs(getY()-y) == Constante.TAILLECASEY) && Math.abs(getX()-x) <= Constante.TAILLECASEX))
        )
        {
            return rect;
        }
        return null;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "inventaire=" + inventaire +
                '}';
    }

    @Override
    public void attaquer(int dx, int dy) {
        Acteur e = this.verifEnnemiAcoter();
        if(this.getArme() instanceof  ArmeDistance){
            ((ArmeDistance) this.getArme()).getProjectile().setX(this.getX());
            ((ArmeDistance) this.getArme()).getProjectile().setY(this.getY());
            this.getArme().utiliser(dx, dy);
        }else if(e!=null){
            e.seFaitAttquer(this.getArme().utiliser(dx, dy));
            if(e.getCoeurs()==0){
                ObservableList<Acteur> lstA= getEnvironnement().getActeurs();
                for(Acteur a : lstA){
                    if(e.getId().equals(a.getId())){
                        lstA.remove(a);
                    }
                }
            }
        }
    }
}