package universite_paris8.iut.yponnou.zelda.modele.utilitaire;

import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;

public class PositionEnv extends Position{

    private Environnement env;

    public PositionEnv(double x, double y, Environnement env) {
        super(x, y);
        this.env=env;
    }

    public Environnement getEnv() {
        return env;
    }

    public void setEnv(Environnement environnement) {
        this.env = environnement;
    }
}
