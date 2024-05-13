package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;

public abstract class Acteur extends Case {

    private String idActeur;
    private static int incremente = 0;
    private String nom;
    private double coeurs;
    private double v;
    private Environnement env;

    public Acteur(String nom, double coeurs, int x, int y, double vitesse, Map map, Environnement environnement) {
        super(x,y,map);
        this.nom = nom;
        this.coeurs = coeurs;
        v = vitesse;
        this.env = environnement;
        idActeur = "Acteur-"+incremente++;
    }

    public String getId() {
        return idActeur;
    }
    public String getNom() {
        return nom;
    }
    public double getCoeurs() {
        return coeurs;
    }

    public void setCoeurs(double coeurs) {
        this.coeurs = coeurs;
    }

    public final double getVitesse(){
        return v;
    }
    public Environnement getEnvironnement() {
        return env;
    }

    public void deplacement(int dx, int dy){
        int prochainX = getX()+dx*ActeurVue.getTailleCaseX();
        int prochainY = getY()+ dy*ActeurVue.getTailleCaseY();
        int tableauX = prochainX/ActeurVue.getTailleCaseX();
        int tableauY = prochainY/ActeurVue.getTailleCaseY();

        if (prochainX < 0 || prochainY < 0 || prochainX >= getMap().getLargeur()*ActeurVue.getTailleCaseX() || prochainY >= getMap().getHauteur()*ActeurVue.getTailleCaseY()) {
            System.out.print("BORD ");
        } else if(directionValide(dx,dy)){
            setX(prochainX);
            setY(prochainY);
        }
        else if (getMap().getTabNum()[tableauX][tableauY] == 1){
            System.out.print("OBSTACLE ");
        }
        else if (getMap().getTabNum()[tableauX][tableauY] == 2) {
            System.out.print("OBJET ");
        }
    }
    public boolean directionValide(int dx, int dy){
        int prochainX, prochainY;
        int tableauX, tableauY;
//        double prochainFinalX, prochainFinalY;
//        int tableauFinX, tableauFinY;

        prochainX = dx * ActeurVue.getTailleCaseX() + this.getX();
        prochainY = dy * ActeurVue.getTailleCaseY() + this.getY();
        tableauX = prochainX / ActeurVue.getTailleCaseX();
        tableauY = prochainY / ActeurVue.getTailleCaseY();

//        for (int i = 0; i < ActeurVue.getTailleCaseX()-2; i++){
//            prochainFinalX = prochainX+i;
//            prochainFinalY = prochainY+i;
//
//            tableauFinX = (int)(prochainFinalX/ActeurVue.getTailleCaseX());
//            tableauFinY = (int)(prochainFinalY/ActeurVue.getTailleCaseY());
//
//        }
        return (this.getMap().getTabNum()[tableauX][tableauY]==0 && prochainX>=0 && prochainX < getMap().getLargeur()*ActeurVue.getTailleCaseX()
                && prochainY >= 0 && prochainY < getMap().getHauteur()*ActeurVue.getTailleCaseY());
    }

    abstract void parler();
}
