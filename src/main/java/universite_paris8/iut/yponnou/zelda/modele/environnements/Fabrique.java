package universite_paris8.iut.yponnou.zelda.modele.environnements;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

public class Fabrique {

    /**
     * La classe Fabrique est responsable de la création d'objets et d'acteurs dans l'environnement du jeu.
     * Elle fournit des méthodes pour générer des acteurs (comme les vendeurs, paysans, etc.) et des objets (comme les pommes, clés).
     * Cette classe permet d'isoler la logique de création et de centraliser la gestion des instances.
     */

    private Environnement environnement;

    public Fabrique(Environnement environnement) {
        this.environnement = environnement;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public Acteur creationActeur(String type, int x, int y, int dx, int dy){
        Direction directionActeur = new Direction(dx, dy);
        switch (type) {
            case "Vendeur":
                Vendeur vendeur = new Vendeur(x, y, getEnvironnement(), directionActeur);
                return vendeur;
            case "Paysan" :
                Paysan paysan = new Paysan(x, y, getEnvironnement(), directionActeur);
                return paysan;
            case "Frere" :
                Frere frere = new Frere(300, 100, getEnvironnement(), directionActeur);
                return frere;
            case "Garde" :
                Epee e = new Epee(0, 0, getEnvironnement(),null,60);
                Garde g = new Garde(x, y, getEnvironnement(), directionActeur, e);
                return g;
            case "Chevalier" :
                Epee echevalier = new Epee(0, 0, getEnvironnement(),null,80);
                Chevalier chevalier = new Chevalier(x, y, getEnvironnement(), directionActeur, echevalier);
                return chevalier;
            case "Boss" :
                Epee eboss = new Epee(0, 0, getEnvironnement(),null,350);
                Boss boss = new Boss(x, y, getEnvironnement(), directionActeur, eboss);
                return boss;
            default:
                return null;
        }
    }

    public Objet creationObjet(String type, int x, int y){
        switch (type) {
            case "Pomme" :
                Pomme p = new Pomme(x, y, environnement);
                return p;
            case "Clef" :
                Clef cle = new Clef("1", x, y, environnement);
                return cle;
            default:
                return null;

        }
    }
}
