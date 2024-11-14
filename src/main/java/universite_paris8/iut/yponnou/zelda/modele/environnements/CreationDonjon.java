package universite_paris8.iut.yponnou.zelda.modele.environnements;

import javafx.beans.Observable;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;

public class CreationDonjon implements CreationEnv{


    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapDonjon();

        environnement.heroChangeEnv(720,530);

        Epee eboss = new Epee(800, 580, environnement,null,350);
        Epee echevalier = new Epee(800, 580, environnement,null,80);
        Epee echevalier2 = new Epee(800, 580, environnement,null,80);

        Direction dBoss = new Direction(0, 0);
        Direction dChevalier1 = new Direction(1, 0);
        Direction dChevalier2 = new Direction(1, 0);
        Direction dFrere = new Direction(1, 0);

        Boss boss = new Boss(730, 100, environnement, dBoss, eboss);
        Chevalier chevalier = new Chevalier(270, 770, environnement, dChevalier1, echevalier);
        Chevalier chevalier2 = new Chevalier(1220, 760, environnement, dChevalier2, echevalier2);
        Frere frere = new Frere(300, 100, environnement, dFrere);

        environnement.ajouterActeur(environnement.getHero());
        environnement.ajouterActeur(boss);
        environnement.ajouterActeur(chevalier);
        environnement.ajouterActeur(chevalier2);
        environnement.ajouterActeur(frere);
    }
}
