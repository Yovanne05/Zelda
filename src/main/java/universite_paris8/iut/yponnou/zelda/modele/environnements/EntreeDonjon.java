package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;


public class EntreeDonjon extends Environnement{
    public EntreeDonjon(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapEntreeDonjon();
    }

    @Override
    public void creationEnvironnement() {
        getHero().changeEnvObjets(this);
        getHero().setEnvironnement(this);

        getHero().getDirection().setDx(0);
        getHero().getDirection().setDy(0);
        this.ajouterActeur(getHero());

    }
}
