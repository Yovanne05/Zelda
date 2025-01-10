package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

public class CreationEntreeDonjon implements CreationEnv{

    /**
     * Cette classe gère la création de l'environnement à l'entrée du donjon.
     * Elle initialise la carte d'entrée du donjon et place le héros au début de l'aventure.
     */

    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapEntreeDonjon();
        environnement.heroChangeEnv(50,1225);
        environnement.ajouterActeur(environnement.getHero());
    }

}
