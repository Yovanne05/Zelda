package universite_paris8.iut.yponnou.zelda.modele.acteurs.deplacement;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;

public interface ComportementEnnemi {
    void deplacer(Ennemi ennemi);
    void attaquer(Ennemi ennemi);
}
