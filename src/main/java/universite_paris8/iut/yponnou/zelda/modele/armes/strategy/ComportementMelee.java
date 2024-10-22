package universite_paris8.iut.yponnou.zelda.modele.armes.strategy;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;

public class ComportementMelee implements ComportementArme{
    private ArmeMelee armeMelee;

    public ComportementMelee(ArmeMelee armeMelee) {
        this.armeMelee = armeMelee;
    }

    @Override
    public void infligeDegat() {
        for (Acteur acteur : armeMelee.getEnvironnement().acteursProperty()) {
            if (acteur instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) acteur;
                if (armeMelee.touche(ennemi)) {
                    ennemi.seFaitAttaquer(armeMelee.getPtsDegats());
                }
            }
        }
    }
}

