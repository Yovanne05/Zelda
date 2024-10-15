package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

public class CreationEntreeDonjon implements CreationEnv{
    public CreationEntreeDonjon() {

    }

    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapEntreeDonjon();
        Hero hero = environnement.getHero();
        hero.changeEnvObjets(environnement);
        hero.setEnvironnement(environnement);

        hero.getDirection().setDx(0);
        hero.getDirection().setDy(0);
        environnement.ajouterActeur(hero);
    }
}
