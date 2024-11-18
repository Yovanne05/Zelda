package universite_paris8.iut.yponnou.zelda.modele.environnements;

public class CreationVillage implements CreationEnv {

    /**
     * Cette classe gère la création de l'environnement de type Village.
     * Elle initialise la carte du village et y place plusieurs acteurs (vendeur, paysans) ainsi que des objets (pommes).
     */

    @Override
    public void creationEnvironnement(Environnement environnement) {
        Fabrique fabrique = new Fabrique(environnement);
        environnement.getMap().initialisationMapVillage();
        environnement.heroChangeEnv(300,500);

        environnement.ajouterActeur(fabrique.creationActeur("Vendeur", 500,500,0,0));
        environnement.ajouterActeur(fabrique.creationActeur("Paysan", 330,300,0,0));
        environnement.ajouterObjet(fabrique.creationObjet("Pomme",400,400));
        environnement.ajouterObjet(fabrique.creationObjet("Pomme",800,200));
        environnement.ajouterObjet( fabrique.creationObjet("Pomme",1200,450));
        environnement.ajouterObjet(fabrique.creationObjet("Pomme",900,550));
        environnement.ajouterObjet(fabrique.creationObjet("Pomme",1100,550));

        environnement.ajouterActeur(environnement.getHero());
    }

}
