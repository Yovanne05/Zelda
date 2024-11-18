package universite_paris8.iut.yponnou.zelda.modele.armes.strategy;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArmeMelee;

import java.util.ArrayList;
import java.util.List;

public class ComportementMelee implements ComportementArme{

    /**
     * Implémentation du comportement d'une arme de mêlée.
     * Cette classe gère la logique d'attaque des armes de mêlée, infligeant des dégâts aux guerriers proches.
     */

    private ArmeMelee armeMelee;

    public ComportementMelee(ArmeMelee armeMelee) {
        this.armeMelee = armeMelee;
    }

    @Override
    public void infligeDegat() {
        List<Acteur> acteursList = new ArrayList<>(armeMelee.getEnvironnement().acteursProperty());

        for (Acteur acteur : acteursList) {
            if (acteur instanceof Ennemi) {
                Ennemi ennemi = (Ennemi) acteur;
                if (ennemi != armeMelee.getProprietaire() && armeMelee.getProprietaire().estProcheDeActeur(ennemi, armeMelee.getPortee())) {
                    ennemi.seFaitAttaquer(armeMelee.getPtsDegats());
                }
            }
        }
    }
}

