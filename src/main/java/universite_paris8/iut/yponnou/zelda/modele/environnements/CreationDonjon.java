package universite_paris8.iut.yponnou.zelda.modele.environnements;

import javafx.beans.Observable;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Boss;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Chevalier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Frere;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;

public class CreationDonjon implements CreationEnv{


    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapDonjon();
        Hero hero = environnement.getHero();
        environnement.getHero().changeEnvObjets(environnement);
        environnement.getHero().getPosition().setX(720);
        environnement.getHero().getPosition().setY(530);
        environnement.getHero().setEnvironnement(environnement);
        environnement.getHero().getDirection().setDx(0);
        environnement.getHero().getDirection().setDy(0);

        Epee e = new Epee(800, 580, environnement);
        Epee e2 = new Epee(800, 580, environnement);
        e.setPtsDegats(5);
        e2.setPtsDegats(2);

        Direction dBoss = new Direction(0, 0);
        Direction dChevalier1 = new Direction(1, 0);
        Direction dChevalier2 = new Direction(1, 0);
        Direction dFrere = new Direction(1, 0);

        // Créer les personnages et objets du Donjon
        Boss boss = new Boss(730, 100, environnement, dBoss, e);
        Chevalier chevalier = new Chevalier(270, 770, environnement, dChevalier1, e2);
        Chevalier chevalier2 = new Chevalier(1220, 760, environnement, dChevalier2, e2);
        Frere frere = new Frere(300, 100, environnement, dFrere);

        // Ajouter les acteurs à l'environnement
        environnement.ajouterActeur(hero);
        environnement.ajouterActeur(boss);
        environnement.ajouterActeur(chevalier);
        environnement.ajouterActeur(chevalier2);
        environnement.ajouterActeur(frere);
    }
}
