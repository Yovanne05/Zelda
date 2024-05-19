package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.controleurs.ObservateurActeurs;

public abstract class Acteur extends Case {

    private String idActeur;
    private static int incremente = 0;
    private String nom;
    private int pv;
    private double vitesse;
    private Environnement env;

    public Acteur(String nom, int pv, double x, double y, double vitesse, Map map, Environnement environnement) {
        super(x,y,map);
        this.nom = nom;
        this.pv = pv;
        this.vitesse = vitesse;
        this.env = environnement;
        idActeur = "Acteur-"+incremente++;
    }

    public String getId() {
        return idActeur;
    }
    public String getNom() {
        return nom;
    }
    public int getPv() {
        return pv;
    }
    public final double getVitesse(){
        return vitesse;
    }
    public Environnement getEnvironnement() {
        return env;
    }

    public void deplacement(int dx, int dy){
        double prochainX = getX()+dx*vitesse;
        double prochainY = getY()+ dy*vitesse;
        int tableauX = (int)(prochainX/ ObservateurActeurs.getTailleCaseX());
        int tableauY = (int)(prochainY/ ObservateurActeurs.getTailleCaseY());

        if (prochainX < 0 || prochainY < 0 || prochainX >= getMap().getLargeur()* ObservateurActeurs.getTailleCaseX() || prochainY >= getMap().getHauteur()* ObservateurActeurs.getTailleCaseY()) {
            System.out.print("BORD ");
        }
        else if (getMap().getTabNum()[tableauY][tableauX] == 1){
            System.out.print("OBSTACLE ");
        }
        else if (getMap().getTabNum()[tableauY][tableauX] == 2) {
            System.out.print("OBJET ");
        }
        else if(directionValide(dx,dy)){
            setX(prochainX);
            setY(prochainY);
        }

    }
    public boolean directionValide(int dx, int dy){
        double prochainX, prochainY;
        int tableauX, tableauY;
//        double prochainFinalX, prochainFinalY;
//        int tableauFinX, tableauFinY;

        prochainX = dx * vitesse + this.getX();
        prochainY = dy * vitesse + this.getY();
        tableauX = (int)(prochainX / ObservateurActeurs.getTailleCaseX());
        tableauY = (int)(prochainY / ObservateurActeurs.getTailleCaseY());

//        for (int i = 0; i < ActeurVue.getTailleCaseX()-2; i++){
//            prochainFinalX = prochainX+i;
//            prochainFinalY = prochainY+i;
//
//            tableauFinX = (int)(prochainFinalX/ActeurVue.getTailleCaseX());
//            tableauFinY = (int)(prochainFinalY/ActeurVue.getTailleCaseY());
//
//        }
        return (this.getMap().getTabNum()[tableauY][tableauX]==0 && prochainX>=0 && prochainX < getMap().getLargeur()* ObservateurActeurs.getTailleCaseX()
                && prochainY >= 0 && prochainY < getMap().getHauteur()* ObservateurActeurs.getTailleCaseY());
    }

    abstract void parler();
}
