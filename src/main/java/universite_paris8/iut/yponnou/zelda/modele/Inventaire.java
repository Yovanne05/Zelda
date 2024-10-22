package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

public class Inventaire {
    private final ObservableList<Objet> inventaire;

    public Inventaire() {
        this.inventaire = FXCollections.observableArrayList();
    }

    public ObservableList<Objet> inventaireProperty() {
        return inventaire;
    }

    public ObservableList<Objet> getInventaire() {
        return inventaire;
    }

    public boolean possedeClef(){
        for (Objet objet : inventaire) {
            if (objet instanceof Clef)
                return true;
        }
        return false;
    }

    // méthode qui renvoie un objet Nourriture si l'inventaire du héro en possède.
    public Nourriture possedeNourritures(){ // dans Inventaire
        for (Objet objet : inventaire) {
            if (objet instanceof Nourriture)
                return (Nourriture) objet;
        }
        return null;
    }

    // méthode qui renvoie un objet Arme si l'inventaire du héro en possède.
    public Arme possedeArme(){ // dans Inventaire
        for (Objet objet : inventaire) {
            if (objet instanceof Arme) {
                return (Arme) objet;
            }
        }
        return null;
    }




    public void ajouterObjet(Objet o){
        inventaire.add(o);
    } // dans Inventaire

    public void supp(Object o){
        this.inventaire.remove(o);
    }
}
