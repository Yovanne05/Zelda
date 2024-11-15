package universite_paris8.iut.yponnou.zelda.modele.environnements;

public class CreationDonjon implements CreationEnv{


    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapDonjon();
        environnement.heroChangeEnv(720,530);
        Fabrique fabrique = new Fabrique(environnement);

        environnement.ajouterActeur(fabrique.creationActeur("Boss",730,100,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Chevalier",270,770,1,0));
        environnement.ajouterActeur(fabrique.creationActeur("Chevalier",1220,760,1,0));
        environnement.ajouterActeur(fabrique.creationActeur("Frere",300,100,0,0));

        environnement.ajouterActeur(environnement.getHero());
    }
}
