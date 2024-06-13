package universite_paris8.iut.yponnou.zelda.modele;

import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Boss;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Chevalier;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;

public class Donjon extends Environnement{
    private Hero hero;

    public Donjon() {
        super(new Map(30, 30));
        this.getMap().initialisationMapDonjon();
    }

    public void creationDonjon(){
        hero=new Hero(720,530,this,0,0,null);
        Epee e=new Epee(800,580,this);
        Epee e2=new Epee(800,580,this);
        e.setPtsDegats(5);
        e2.setPtsDegats(2);
        Boss boss = new Boss(730,100,this,1,0,e);
        Chevalier chevalier = new Chevalier(270,770,this,1,0,e2);
        Chevalier chevalier2 = new Chevalier(1220,760,this,1,0,e2);


        this.ajouterActeur(hero);
        this.ajouterActeur(boss);
        this.ajouterActeur(chevalier);
        this.ajouterActeur(chevalier2);
    }
}
