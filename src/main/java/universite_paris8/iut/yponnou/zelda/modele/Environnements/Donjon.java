
package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Boss;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Chevalier;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Map;

public class Donjon extends Environnement{

    public Donjon(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapDonjon();
    }

    @Override
    public void creationEnvironnement(){
        getHero().changeEnvArc(this);
        getHero().getPosition().setX(720);
        getHero().getPosition().setY(530);
        getHero().getPosition().setEnv(this);
        getHero().setDx(0);
        getHero().setDy(0);
        Epee e=new Epee(800,580,this);
        Epee e2=new Epee(800,580,this);
        e.setPtsDegats(5);
        e2.setPtsDegats(2);
        Boss boss = new Boss(730,100,this,1,0,e);
        Chevalier chevalier = new Chevalier(270,770,this,1,0,e2);
        Chevalier chevalier2 = new Chevalier(1220,760,this,1,0,e2);


        this.ajouterActeur(getHero());
        this.ajouterActeur(boss);
        this.ajouterActeur(chevalier);
        this.ajouterActeur(chevalier2);
    }

    @Override
    public void entree() {

    }
}
