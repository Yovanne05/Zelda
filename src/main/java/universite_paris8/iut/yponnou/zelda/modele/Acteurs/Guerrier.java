
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.PositionEnv;

public abstract class Guerrier extends Acteur {
    private Arme arme;
    private IntegerProperty pv;

    public Guerrier(double x, double y, Environnement environnement, double vitesse, Direction direction, Arme arme, int pv) {
        super(x, y, environnement, vitesse, direction);
        this.arme = arme;
        this.pv = new SimpleIntegerProperty(pv);
    }

    public Arme getArme() {
        return arme;
    }
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setPv(int pv) {
        this.pv.setValue(pv);
    }


    public int getPv() {
        return pv.getValue();
    }
    public IntegerProperty pvProperty() {
        return pv;
    }

    public boolean estMort(){
        return this.getPv()<0;
    }

    public void seFaitAttaquer(int degats) {
        int nouveauxPv = calculerNouveauxPv(degats);
        if (nouveauxPv > 0) {
            setPv(nouveauxPv);
        } else {
            mourir();
        }
    }

    public int calculerNouveauxPv(int degats) {
        return Math.max(0, getPv() - degats); //renvoie la valeur la plus grande pour ne pas renvoyez des pv négatif
    }

    public void mourir() {
        setPv(0);
        getEnvironnement().enleverActeur(this);
    }

    public boolean estProcheDeActeur(Acteur acteur, double distanceSeuil) {
        double distance = distance(acteur.getPosition());
        return distance <= distanceSeuil;
    }

    public void subitDegats(int degats){
        setPv(calculerNouveauxPv(degats));
    }
}
