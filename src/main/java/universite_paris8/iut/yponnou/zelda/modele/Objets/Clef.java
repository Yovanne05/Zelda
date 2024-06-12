package universite_paris8.iut.yponnou.zelda.modele.Objets;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class Clef extends Objet {

    public Clef(String id,double x, double y, Environnement environnement) {
        super(x, y, environnement);
        setId("Clef".concat(id));
    }

    @Override
    public String toString() {
        return "une Clef";
    }
}
