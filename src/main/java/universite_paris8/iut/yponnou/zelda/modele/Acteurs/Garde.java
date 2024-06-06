package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Garde extends Ennemi {
    private static final long delaisAvantAttaque = 2000; // Délai de 2 secondes entre les attaques
    private long derniereAttaque;

    public Garde(String nom, double coeurs, double x, double y, double vitesse, Environnement environnement, int dx, int dy, Epee epee) {
        super(nom, coeurs, x, y, vitesse, environnement, dx, dy, epee);
    }


    @Override
    public void attaquer(int dx, int dy) {
        long now = System.currentTimeMillis();
        if (peuxAttaquer(now)) {
            Hero h = verifHeroProx();
            if (h != null) {
                h.seFaitAttquer(getArme().getPtsDegats());
                derniereAttaque = now;
            }
        }
    }

    private boolean peuxAttaquer(long now) {
        return (now - derniereAttaque) >= delaisAvantAttaque;
    }
}

