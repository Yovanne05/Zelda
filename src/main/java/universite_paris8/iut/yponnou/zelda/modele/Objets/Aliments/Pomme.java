package universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments;

import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Pomme extends Nourriture {

    public Pomme(int x, int y, Environnement environnement) {
        super(x, y, environnement, 10);
        setNom("Pomme");
    }

    @Override
    public String toString(){
        return "une "+getNom();
    }
}
