package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Pomme;


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
        vendeur = new Vendeur(500, 500, this, 0, 0);
        paysan = new Paysan(310,320,this,0,0);

        Pomme p1=new Pomme(400,400,this);
        Pomme p2=new Pomme(800,200,this);
        Pomme p3=new Pomme(1200,450,this);

        this.ajouterActeur(vendeur);
        this.ajouterActeur(paysan);
        this.ajouterObjet(p1);
        this.ajouterObjet(p2);
        this.ajouterObjet(p3);
        this.ajouterActeur(getHero());
    }
}
