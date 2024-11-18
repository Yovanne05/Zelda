package universite_paris8.iut.yponnou.zelda.modele.inventaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Position;

public class Inventaire {

    /**
     * La classe Inventaire gère les objets que le héros possède, permettant d'ajouter, retirer, utiliser et déposer des objets.
     * Elle offre également des fonctionnalités pour interagir avec les objets comme les armes, la nourriture et les clefs.
     */

    private final ObservableList<Objet> inventaire = FXCollections.observableArrayList();
    private final int capaciteMax;

    private final Hero hero;

    public Inventaire(int capaciteMax, Hero hero) {
        this.capaciteMax = capaciteMax;
        this.hero = hero;
    }

    public ObservableList<Objet> inventaireProperty() {
        return inventaire;
    }

    public void ajouterObjet(Objet objet) {
        if (inventaire.size() < capaciteMax) {
            if(objet instanceof Arme){
                objet.setPosition(hero.getPosition());
            }
            inventaire.add(objet);
            objet.getEnvironnement().enleverObjet(objet);
        }
    }

    public void retirerObjet(Objet objet) {
        inventaire.remove(objet);
    }

    public boolean estPlein() {
        return inventaire.size() >= capaciteMax;
    }

    public Nourriture possedeNourriture() {
        for (Objet objet : inventaire) {
            if (objet instanceof Nourriture) {
                return (Nourriture) objet;
            }
        }
        return null;
    }

    public Arme possedeArme() {
        for (Objet objet : inventaire) {
            if (objet instanceof Arme) {
                return (Arme) objet;
            }
        }
        return null;
    }

    public boolean possedeClef() {
        for (Objet objet : inventaire) {
            if (objet instanceof Clef) {
                return true;
            }
        }
        return false;
    }

    public void consommerNourriture(Nourriture nourriture) {
        if (!hero.pleineSante()) {
            hero.setPv(hero.getPv() + nourriture.getPv());
            retirerObjet(nourriture);
        }
    }

    public void equiperArme(Arme arme) {
        hero.setArme(arme);
    }

    public void selectionObjet(int index) {
        if (index < inventaire.size()) {
            Objet objet = inventaire.get(index);
            if (objet instanceof Nourriture) {
                consommerNourriture((Nourriture) objet);
            } else if (objet instanceof Arme) {
                equiperArme((Arme) objet);
            }
        }
    }

    public void deposer(Objet objet) {
        Position positionDevantLeHero = hero.getPosition().calculerPositionDevantActeur();

        if (estPositionValide(positionDevantLeHero) && !positionOccupeeParObjet(positionDevantLeHero)) {
            if (depotPossible(objet, positionDevantLeHero)) {
                placerObjet(objet, positionDevantLeHero.getX(), positionDevantLeHero.getY());
            }
        }
    }

    public ObservableList<Objet> getInventaire() {
        return inventaire;
    }

    private boolean positionOccupeeParObjet(Position position) {
        for (Objet o : hero.getEnvironnement().getObjets()) {
            if (position.estPositionOccupee(o.getPosition())) {
                return true;
            }
        }
        return false;
    }
    private boolean estPositionValide(Position p) {
        return hero.getEnvironnement().dansMap(p.getX(), p.getY());
    }

    private boolean depotPossible(Objet objet, Position position) {
        int taille = distanceMaxPossible();
        return estDansRayon(position, taille);
    }

    private void placerObjet(Objet objet, double x, double y) {
        objet.getPosition().setX(x);
        objet.getPosition().setY(y);
        retirerObjet(objet);
        if (objet instanceof Arme) {
            mettreAJourArme();
        }
        hero.getEnvironnement().ajouterObjet(objet);
    }

    private void mettreAJourArme() {
        Arme arme = possedeArme();
        hero.setArme(arme);
    }

    private int distanceMaxPossible() {
        return 30;
    }

    private boolean estDansRayon(Position pos, int distanceSeuil) {
        return Math.abs(hero.getPosition().getX() - pos.getX()) <= distanceSeuil &&
                Math.abs(hero.getPosition().getY() - pos.getY()) <= distanceSeuil;
    }

    public void changeEnvObjets(Environnement env) {
        for (Objet o : inventaire) {
            o.setEnvironnement(env);
        }
    }
}
