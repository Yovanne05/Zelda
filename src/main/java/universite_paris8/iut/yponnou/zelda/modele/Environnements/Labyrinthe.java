package universite_paris8.iut.yponnou.zelda.modele.Environnements;


import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Clef;


public class Labyrinthe extends Environnement{

    public Labyrinthe(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapLabyrinthe();
    }

    @Override
    public void creationEnvironnement(){
        getHero().getInventaire().changeEnvObjets(this);
        System.out.println("Labyrinthe");
        getHero().getPosition().setEnv(this);
        getHero().setDx(0);
        getHero().setDy(0);
        Epee e=new Epee(0,0,this);

        Garde g1 = new Garde(500,350,this,0,0,e);
        Garde g2 = new Garde(750,50,this,0,0,e);
        Garde g3 = new Garde(890,350,this,0,0,e);
        Garde g4 = new Garde(1250,300,this,0,0,e);
        Garde g5 = new Garde(1250,650,this,0,0,e);
        Garde g6= new Garde(800,740,this,0,0,e);
        Garde g7 = new Garde(1350,390,this,0,0,e);
        Garde g8 = new Garde(1350,100,this,0,0,e);
        Clef cle=new Clef(""+1,900,700,this);


        this.ajouterActeur(getHero());
        this.ajouterObjet(cle);
        this.ajouterActeur(g1);
        this.ajouterActeur(g2);
        this.ajouterActeur(g3);
        this.ajouterActeur(g4);
        this.ajouterActeur(g5);
        this.ajouterActeur(g6);
        this.ajouterActeur(g7);
        this.ajouterActeur(g8);
    }


}
