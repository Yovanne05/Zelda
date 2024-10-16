package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Vendeur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Paysan;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;

public class CreationVillage implements CreationEnv {
    @Override
    public void creationEnvironnement(Environnement environnement) {
        environnement.getMap().initialisationMapVillage();
        Hero hero = environnement.getHero(); // On récupère l'Hero directement depuis l'Environnement
        hero.changeEnvObjets(environnement);
        hero.getPosition().setX(300);
        hero.getPosition().setY(500);
        hero.setEnvironnement(environnement);
        hero.getDirection().setDx(0);
        hero.getDirection().setDy(0);

        Direction directionVendeur = new Direction(0, 0);
        Direction directionPaysan = new Direction(0, 0);

        // Créer les acteurs et objets spécifiques au Village
        Vendeur vendeur = new Vendeur(500, 500, environnement, directionVendeur);
        Paysan paysan = new Paysan(330, 300, environnement, directionPaysan);

        Pomme p1 = new Pomme(400, 400, environnement);
        Pomme p2 = new Pomme(800, 200, environnement);
        Pomme p3 = new Pomme(1200, 450, environnement);
        Pomme p4 = new Pomme(900, 550, environnement);
        Pomme p5 = new Pomme(1100, 550, environnement);
        System.out.println(p5.getId());

        // Ajouter les acteurs et objets à l'environnement
        environnement.ajouterActeur(vendeur);
        environnement.ajouterActeur(paysan);
        environnement.ajouterObjet(p1);
        environnement.ajouterObjet(p2);
        environnement.ajouterObjet(p3);
        environnement.ajouterObjet(p4);
        environnement.ajouterObjet(p5);
        environnement.ajouterActeur(hero);
    }

}
