package universite_paris8.iut.yponnou.zelda.modele;

public class Hero extends Acteur{

    private Inventaire inventaire;

    public Hero(String nom, int pv, int x, int y, Map map, Environnement environnement) {
        super(nom, pv, x, y, 10,map, environnement);
        inventaire = new Inventaire(5);
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public Objet objetsProches(){
        for(Objet obj : getEnvironnement().getObjets()){
            if (verifObjetsAutour(obj)){
                return obj;
            }
        }
        return null;
    }

    public void recuperer(Objet objet){
        inventaire.ajouterObjet(objet);
        objet.getEnvironnement().enleverObjet(objet);
    }

    public void deposer(Objet objet){
        double objetX, objetY;
        do {
            objetX = (Math.random()*getTailleCaseX()) + getX();
            objetY = (Math.random()*getTailleCaseX()) + getY();
        }while (!getEnvironnement().dansMap(objetX,objetY) && !verifObjetsAutour(objet));

        objet.setX(objetX);
        objet.setY(objetY);
        inventaire.deposerObjet(objet);
        objet.getEnvironnement().ajouterObjet(objet);
    }


    public boolean verifObjetsAutour(Objet obj){
        return (this.getY()-getTailleCaseY()<= obj.getY() && obj.getY() <= getY()+getTailleCaseY()
                && this.getX()-getTailleCaseX()<= obj.getX() && obj.getX() <= getX()+getTailleCaseX());
    }
    @Override
    void parler() {

    }
}
