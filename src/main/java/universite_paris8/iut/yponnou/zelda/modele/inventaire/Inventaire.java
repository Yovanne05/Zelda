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
        Position posAleatoire = genererPositionAleatoire(objet);

        while (!estPositionValide(posAleatoire)) {
            posAleatoire = genererPositionAleatoire(objet);
        }

        if (depotPossible(objet, posAleatoire)) {
            placerObjet(objet, posAleatoire.getX(), posAleatoire.getY());
        }
    }

    private Position genererPositionAleatoire(Objet objet) {
        int taille = distanceMaxPossible();
        Position posAleatoire;
        double objetX, objetY;
        do {
            objetX = hero.getPosition().getX() + (Math.random() * 2 * taille - taille);
            objetY = hero.getPosition().getY() + (Math.random() * 2 * taille - taille);
            posAleatoire = new Position(objetX, objetY);
        } while (!estPositionValide(posAleatoire));

        return posAleatoire;
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
