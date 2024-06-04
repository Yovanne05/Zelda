package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.controleurs.ObservateurActeurs;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;


public class Npc extends Acteur{

        public Npc(String nom, int x, int y, double vitesse, Environnement environnement) {
            super(nom, 99999999, x, y, vitesse, environnement);
        }

        public void parler() {

        }


    }
