package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import universite_paris8.iut.yponnou.zelda.modele.Armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

import java.util.LinkedList;
import java.util.Queue;

import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEX;
import static universite_paris8.iut.yponnou.zelda.Constante.TAILLECASEY;


public abstract class Ennemi extends Guerrier {

    private int cpt = 0;

    public Ennemi(String nom, double x, double y, int pv, double vitesse, Environnement environnement, int dx, int dy, Arme arme) {
        super(nom, x, y, pv, vitesse, environnement, dx, dy, arme);
    }

    public Hero verifHeroProx() {
        for (Acteur a : this.getPosition().getEnv().getLstActeurs()) {
            double dist = 80;
            if ((Math.abs(getPosition().getX() - a.getPosition().getX()) <= dist && Math.abs(getPosition().getY() - a.getPosition().getY()) <= dist)) {
                if (a instanceof Hero) {
                    return (Hero) a;
                }
            }
        }
        return null;
    }

    public abstract void deplacementEnnemi();

    public void deplacementBFSversHero(Hero h) {
        boolean[][] visited = new boolean[getPosition().getEnv().getMap().getLargeur()][getPosition().getEnv().getMap().getHauteur()];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node((int) getPosition().getX(), (int) getPosition().getY()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (x == (int) h.getPosition().getX() && y == (int) h.getPosition().getY()) {
                // Nous avons trouvé le héros, terminons la recherche
                break;
            }

            // Trouver la direction vers laquelle se déplacer pour se rapprocher du héros
            int dx = (x < (int) h.getPosition().getX()) ? 1 : ((x > (int) h.getPosition().getX()) ? -1 : 0);
            int dy = (y < (int) h.getPosition().getY()) ? 1 : ((y > (int) h.getPosition().getY()) ? -1 : 0);

            // Déplacer l'ennemi dans la direction trouvée
            deplacerVers(x + dx, y + dy);

            // Marquer le nœud actuel comme visité
            visited[x][y] = true;

            // Ajouter les voisins non visités à la file d'attente
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        int newX = x + i;
                        int newY = y + j;
                        if (getPosition().getEnv().dansMap(newX, newY) && !visited[newX][newY]) {
                            queue.add(new Node(newX, newY));
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
        }
    }


    private void deplacerVers(int x, int y) {
        // Récupérer la position actuelle du garde
        int gardeX = (int) getPosition().getX();
        int gardeY = (int) getPosition().getY();

        // Calculer les différences de position entre le garde et la position cible
        int diffX = x - gardeX;
        int diffY = y - gardeY;

        // Déterminer la direction du déplacement
        int dx = (diffX > 0) ? 1 : ((diffX < 0) ? -1 : 0);
        int dy = (diffY > 0) ? 1 : ((diffY < 0) ? -1 : 0);

        // Vérifier si le déplacement est possible en fonction des obstacles
        if (dx != 0 && getPosition().getEnv().dansMap(gardeX + dx, gardeY) && getPosition().getEnv().getMap().getTabNum()[gardeY][(int) (gardeX / TAILLECASEX + dx)] <= 20) {
            // Déplacement horizontal possible
            setDx(dx);
            setDy(0);
        } else if (dy != 0 && getPosition().getEnv().dansMap(gardeX, gardeY + dy) && getPosition().getEnv().getMap().getTabNum()[(int) (gardeY / TAILLECASEY + dy)][gardeX] <= 20) {
            // Déplacement vertical possible
            setDx(0);
            setDy(dy);
        } else {
            // Aucun déplacement possible
            setDx(0);
            setDy(0);
        }

        // Déplacer l'ennemi dans la direction calculée
        deplacement();
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}