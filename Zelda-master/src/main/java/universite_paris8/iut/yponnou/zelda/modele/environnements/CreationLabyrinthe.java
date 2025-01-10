package universite_paris8.iut.yponnou.zelda.modele.environnements;

public class CreationLabyrinthe implements CreationEnv{

    /**
     * Cette classe gère la création d'un environnement de type Labyrinthe.
     * Elle initialise la carte du labyrinthe et place plusieurs gardes et objets dans l'environnement.
     */

    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapLabyrinthe();
        environnement.heroChangeEnv(60,800);
        Fabrique fabrique = new Fabrique(environnement);

        environnement.ajouterActeur(fabrique.creationActeur("Garde", 500,350,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Garde", 750,50,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Garde", 890,350,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Garde", 1250,300,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Garde", 800,740,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Garde", 1350,390,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Garde", 1350,100,0,0));

        environnement.ajouterObjet(fabrique.creationObjet("Clef",900,700));

        environnement.ajouterActeur(environnement.getHero());
    }
}
