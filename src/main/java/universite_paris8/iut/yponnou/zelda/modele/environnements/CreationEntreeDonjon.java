package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

public class CreationEntreeDonjon implements CreationEnv{

    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapEntreeDonjon();
        environnement.heroChangeEnv(725,540);
        environnement.ajouterActeur(environnement.getHero());
    }

}
