package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Clef;

public class Porte {

    private final String id;
    private static int incremente = 0;
    private final double x;
    private final double y;
    private final Environnement environnement;
    private boolean etat;

    public Porte(double x, double y, Environnement environnement) {
        double clefX, clefY;
        this.id = "Porte"+incremente++;
        this.x = x;
        this.y = y;
        this.environnement = environnement;
        this.etat = false;
        do {
            clefX = (Math.random()*this.environnement.getLargeur());
            clefY = (Math.random()*this.environnement.getHauteur());
        }while (this.environnement.dansMap(clefX,clefY));
        new Clef(id,clefX,clefY,environnement);
    }

    public String getId() {
        return id;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Environnement getEnvironnement() {
        return environnement;
    }

    public boolean estOuverte() {
        return etat;
    }

    public void ouverture(Clef clef) {
        if (clef.getId().contains(getId()))
            etat = true;
    }
}
