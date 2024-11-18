package universite_paris8.iut.yponnou.zelda.modele.acteurs.comportement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;

public interface ComportementEnnemi {
    /**
     * Interface définissant les comportements communs pour les ennemis.
     * Les ennemis doivent implémenter les méthodes de déplacement et d'attaque.
     */

    void deplacer(Ennemi ennemi);
    void attaquer(Ennemi ennemi);
}
