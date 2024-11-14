package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;

public class CreationLabyrinthe implements CreationEnv{

    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapLabyrinthe();
        Hero hero = environnement.getHero();
        environnement.heroChangeEnv(60,800);

        Epee e1 = new Epee(0, 0, environnement,null,60);
        Epee e2 = new Epee(0, 0, environnement,null,60);
        Epee e3 = new Epee(0, 0, environnement,null,60);
        Epee e4 = new Epee(0, 0, environnement,null,60);
        Epee e5 = new Epee(0, 0, environnement,null,60);
        Epee e6 = new Epee(0, 0, environnement,null,60);
        Epee e7 = new Epee(0, 0, environnement,null,60);
        Epee e8 = new Epee(0, 0, environnement,null,60);

        Direction d = new Direction(0, 0);

        Garde g1 = new Garde(500, 350, environnement, d, e1);
        Garde g2 = new Garde(750, 50, environnement, d, e2);
        Garde g3 = new Garde(890, 350, environnement, d, e3);
        Garde g4 = new Garde(1250, 300, environnement, d, e4);
        Garde g5 = new Garde(1250, 650, environnement, d, e5);
        Garde g6 = new Garde(800, 740, environnement, d, e6);
        Garde g7 = new Garde(1350, 390, environnement, d, e7);
        Garde g8 = new Garde(1350, 100, environnement, d, e8);

        Clef cle = new Clef("1", 900, 700, environnement);

        environnement.ajouterActeur(hero);
        environnement.ajouterObjet(cle);
        environnement.ajouterActeur(g1);
        environnement.ajouterActeur(g2);
        environnement.ajouterActeur(g3);
        environnement.ajouterActeur(g4);
        environnement.ajouterActeur(g5);
        environnement.ajouterActeur(g6);
        environnement.ajouterActeur(g7);
        environnement.ajouterActeur(g8);
    }
}
