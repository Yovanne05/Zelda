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
        Hero hero = environnement.getHero(); // Récupérer l'Hero depuis l'Environnement
        environnement.getHero().changeEnvObjets(environnement);
        environnement.getHero().setEnvironnement(environnement);
        environnement.getHero().getDirection().setDx(0);
        environnement.getHero().getDirection().setDy(0);

        Epee e = new Epee(0, 0, environnement);

        Direction d = new Direction(0, 0);

        // Créer les gardes et objets du Labyrinthe
        Garde g1 = new Garde(500, 350, environnement, d, e);
        Garde g2 = new Garde(750, 50, environnement, d, e);
        Garde g3 = new Garde(890, 350, environnement, d, e);
        Garde g4 = new Garde(1250, 300, environnement, d, e);
        Garde g5 = new Garde(1250, 650, environnement, d, e);
        Garde g6 = new Garde(800, 740, environnement, d, e);
        Garde g7 = new Garde(1350, 390, environnement, d, e);
        Garde g8 = new Garde(1350, 100, environnement, d, e);

        Clef cle = new Clef("1", 900, 700, environnement);

        // Ajouter les acteurs et objets à l'environnement
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
