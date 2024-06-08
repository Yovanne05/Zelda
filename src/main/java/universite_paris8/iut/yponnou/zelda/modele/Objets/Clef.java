package universite_paris8.iut.yponnou.zelda.modele.Objets;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Clef extends Objet {

    private boolean etat = true;

    public Clef(String id,double x, double y, Environnement environnement) {
        super(x, y, environnement);
        setId("Clef".concat(id));
    }

    @Override
    public String toString() {
        return "";
    }
}
