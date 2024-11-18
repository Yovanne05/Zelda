package universite_paris8.iut.yponnou.zelda.modele.objets;

import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class Clef extends Objet {

    /**
     * La classe Clef représente un objet de type clef dans le jeu qui permet d'ouvrir certaine porte.
     * Une clef est associée à un identifiant unique et à une position dans l'environnement.
     *
     * Cette classe étend la classe `Objet` et redéfinit la méthode `nom()` pour retourner "Clef",
     * ce qui permet d'identifier cet objet spécifique comme une clef.
     */


    public Clef(String id,double x, double y, Environnement environnement) {
        super(x, y, environnement);
        setId("Clef-".concat(id));
    }

    public String nom(){
        return "Clef";
    }
}
