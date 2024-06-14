package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Map;


public class Village extends Environnement{
    private Paysan paysan;
    private Vendeur vendeur;


    public Village(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapVillage();
    }

    @Override
    public void creationEnvironnement(){
        getHero().getPosition().setX(830);
        getHero().getPosition().setY(510);
        getHero().getPosition().setEnv(this);
        getHero().setDx(0);
        getHero().setDy(0);
        vendeur = new Vendeur(1400, 500, this, 0, 0);
        paysan = new Paysan(310,320,this,0,0);

        this.ajouterActeur(vendeur);
        this.ajouterActeur(paysan);
        this.ajouterActeur(getHero());
    }
}
