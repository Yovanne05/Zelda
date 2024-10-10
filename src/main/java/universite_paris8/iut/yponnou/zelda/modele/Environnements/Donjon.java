
package universite_paris8.iut.yponnou.zelda.modele.Environnements;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Map;

public class Donjon extends Environnement{

    public Donjon(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapDonjon();
    }

    @Override
    public void creationEnvironnement(){
        getHero().changeEnvObjets(this);
        getHero().getPosition().setX(720);
        getHero().getPosition().setY(530);
        getHero().getPosition().setEnv(this);
        getHero().getDirection().setDx(0);
        getHero().getDirection().setDy(0);
        Epee e=new Epee(800,580,this);
        Epee e2=new Epee(800,580,this);
        e.setPtsDegats(5);
        e2.setPtsDegats(2);
        Direction d = new Direction(1,0);
        Boss boss = new Boss(730,100,this,d,e);
        Chevalier chevalier = new Chevalier(270,770,this,d,e2);
        Chevalier chevalier2 = new Chevalier(1220,760,this,d,e2);
        Frere frere =new Frere(300,100,this,d);


        this.ajouterActeur(getHero());
        this.ajouterActeur(boss);
        this.ajouterActeur(chevalier);
        this.ajouterActeur(chevalier2);
        this.ajouterActeur(frere);
    }
    public boolean verifEnnemiMort(){
        for (int i=0;i<acteursProperty().size();i++){
            if(acteursProperty().get(i) instanceof Ennemi){
                if(acteursProperty().get(i).getPv()>0){
                    return false;
                }
            }
        }
        return true;
    }

}
