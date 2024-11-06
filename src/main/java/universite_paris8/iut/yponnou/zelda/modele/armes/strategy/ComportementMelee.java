package universite_paris8.iut.yponnou.zelda.modele.armes.strategy;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;

import java.util.ArrayList;
import java.util.List;

public class ComportementMelee implements ComportementArme{
    private ArmeMelee armeMelee;

    public ComportementMelee(ArmeMelee armeMelee) {
        this.armeMelee = armeMelee;
    }

    @Override
    public void infligeDegat() {
        List<Acteur> acteursList = new ArrayList<>(armeMelee.getEnvironnement().acteursProperty());

        for (Acteur acteur : acteursList) {
            if (acteur instanceof Guerrier && acteur != armeMelee.getProprietaire()) {
                Guerrier guerrier = (Guerrier) acteur;
                if (armeMelee.getProprietaire().estProcheDeActeur(guerrier, armeMelee.getPortee())) {
                    guerrier.seFaitAttaquer(armeMelee.getPtsDegats());
                }
            }
        }
    }
}

