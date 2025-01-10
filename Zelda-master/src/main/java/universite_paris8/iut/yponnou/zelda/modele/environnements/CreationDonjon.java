package universite_paris8.iut.yponnou.zelda.modele.environnements;

public class CreationDonjon implements CreationEnv{

    /**
     * Cette classe gère la création d'un environnement de type Donjon.
     * Elle initialise la carte du donjon, place le héros, et ajoute des acteurs spécifiques (comme des Boss et Chevaliers).
     * Elle gère aussi l'ajout du boss et des chevaliers, ainsi que d'autres personnages importants dans le donjon.
     */

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
