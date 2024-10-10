
package universite_paris8.iut.yponnou.zelda.modele.environnements;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;

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
        getHero().setEnvironnement(this);
        getHero().getDirection().setDx(0);
        getHero().getDirection().setDy(0);
        Epee e=new Epee(800,580,this);
        Epee e2=new Epee(800,580,this);
        e.setPtsDegats(5);
        e2.setPtsDegats(2);
        Direction dBoss = new Direction(0,0);
        Direction dChevalier1 = new Direction(1,0);
        Direction dChevalier2 = new Direction(1,0);
        Direction dFrere = new Direction(1,0);
        Boss boss = new Boss(730,100,this,dBoss,e);
        Chevalier chevalier = new Chevalier(270,770,this,dChevalier1,e2);
        Chevalier chevalier2 = new Chevalier(1220,760,this,dChevalier2,e2);
        Frere frere =new Frere(300,100,this,dFrere);


        this.ajouterActeur(getHero());
        this.ajouterActeur(boss);
        this.ajouterActeur(chevalier);
        this.ajouterActeur(chevalier2);
        this.ajouterActeur(frere);
    }
    public boolean verifEnnemiMort(){
        for (int i=0;i<acteursProperty().size();i++){
            if(acteursProperty().get(i) instanceof Ennemi){
                if(((Ennemi) acteursProperty().get(i)).getPv()>0){
                    return false;
                }
            }
        }
        return true;
    }

}
