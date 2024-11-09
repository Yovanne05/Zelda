package universite_paris8.iut.yponnou.zelda.modele.objets;

import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Clef extends Objet {

    public Clef(String id,double x, double y, Environnement environnement) {
        super(x, y, environnement);
        setId("Clef-".concat(id));
    }

    public String nom(){
        return "Clef";
    }
}
