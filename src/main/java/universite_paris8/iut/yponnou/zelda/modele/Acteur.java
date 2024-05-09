package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.vue.ActeurVue;

public abstract class Acteur extends Case {
    private String nom;
    private int pv;
    private double v;

    public Acteur(String nom, int pv, int x, int y, double vitesse, Map map) {
        super(x,y,map);
        this.nom = nom;
        this.pv = pv;
        v = vitesse;
    }

    public String getNom() {
        return nom;
    }
    public int getPv() {
        return pv;
    }
    public final double getVitesse(){
        return v;
    }

    public void deplacement(int dx, int dy){
        int prochainX = getX()+ dx* ActeurVue.getTailleCaseX();
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
        int prochainX = dx * ActeurVue.getTailleCaseX() + this.getX();
        int prochainY = dy * ActeurVue.getTailleCaseY() + this.getY();
        int tableauX = prochainX / ActeurVue.getTailleCaseX();
        int tableauY = prochainY / ActeurVue.getTailleCaseY();
        return (this.getMap().getTabNum()[tableauX][tableauY]==0 && prochainX>=0 && prochainX < getMap().getLargeur()*ActeurVue.getTailleCaseX()
                && prochainY >= 0 && prochainY < getMap().getHauteur()*ActeurVue.getTailleCaseY());
    }

    abstract void parler();
}
