package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Map;

public class EntreeDonjon extends Environnement{
    public EntreeDonjon(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapEntreeDonjon();
    }

    @Override
    public void creationEnvironnement() {
        getHero().changeEnvArc(this);
        getHero().getPosition().setEnv(this);

        getHero().setDx(0);
        getHero().setDy(0);
        this.ajouterActeur(getHero());

    }
}
