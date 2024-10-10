
package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;


public class Village extends Environnement{
    private Paysan paysan;
    private Vendeur vendeur;


    public Village(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapVillage();
    }

    @Override
    public void creationEnvironnement(){
        getHero().changeEnvObjets(this);
        getHero().getPosition().setX(300);
        getHero().getPosition().setY(500);
        getHero().setEnvironnement(this);
        getHero().getDirection().setDx(0);
        getHero().getDirection().setDy(0);
        Direction directionV = new Direction(0,0);
        Direction directionP = new Direction(0,0);
        vendeur = new Vendeur(500, 500, this, directionV);
        paysan = new Paysan(330,300,this,directionP);

        Pomme p1=new Pomme(400,400,this);
        Pomme p2=new Pomme(800,200,this);
        Pomme p3=new Pomme(1200,450,this);
        Pomme p4=new Pomme(900,550,this);
        Pomme p5=new Pomme(1100,550,this);

        this.ajouterActeur(vendeur);
        this.ajouterActeur(paysan);
        this.ajouterObjet(p1);
        this.ajouterObjet(p2);
        this.ajouterObjet(p3);
        this.ajouterObjet(p4);
        this.ajouterObjet(p5);
        this.ajouterActeur(getHero());
    }

}
