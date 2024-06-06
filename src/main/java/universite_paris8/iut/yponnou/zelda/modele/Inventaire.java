package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class Inventaire{

    private final ObservableList<Objet> objets = FXCollections.observableArrayList();
    private final int taille;

    public Inventaire(int capaciteStockage) {
        taille = capaciteStockage;
    }

    public ObservableList<Objet> getObjets() {
        return objets;
    }
    public int getTaille() {
        return taille;
    }

    public void ajouterObjet(Objet objet) {
        objets.add(objet);
    }
    public void deposerObjet(Objet objet) {
        objets.remove(objet);
    }

}