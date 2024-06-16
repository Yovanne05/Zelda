package universite_paris8.iut.yponnou.zelda.modele.TestJunit;


import javafx.scene.shape.Rectangle;
import org.junit.Test;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Boss;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Village;

import static org.junit.Assert.*;

public class ActeurTest {

    private Epee e = new Epee(0, 0, null);
    private Hero h = new Hero(299, 299, null, 1, 0, e);
    private Environnement environnement = new Village(h);
    private Acteur acteur = new Acteur("TestActeur", 400, 400, 100, 1.0, environnement, 1, 0);

    @Test
    public void testCreationActeur() {
        assertEquals("TestActeur", acteur.getNom());
        assertEquals(400.0, acteur.getPosition().getX(), 0.0001); // Ajout du delta pour comparaison des flottants
        assertEquals(400.0, acteur.getPosition().getY(), 0.0001); // Ajout du delta pour comparaison des flottants
        assertEquals(100, acteur.getPv());
        assertEquals(1.0, acteur.getVitesse(), 0.0001); // Ajout du delta pour comparaison des flottants
    }

    @Test
    public void testDeplacement() {
        acteur.deplacement();
        assertEquals(450, acteur.getPosition().getX(), 0.0001); // Ajout du delta pour comparaison des flottants
        assertEquals(400, acteur.getPosition().getY(), 0.0001); // Ajout du delta pour comparaison des flottants
    }

    @Test
    public void testCollisionAvecObstacle() {
        Rectangle futureHitbox = new Rectangle(450, 400, 50, 50);
        assertFalse(acteur.collisionAvecObstacle(futureHitbox)); // Adaptez selon votre environnement
    }

    @Test
    public void testCollisionAvecActeur() {
        Acteur autreActeur = new Acteur("AutreActeur", 50, 0, 100, 1.0, environnement, 0, 0);
        environnement.ajouterActeur(autreActeur); // Méthode à adapter pour ajouter un acteur à l'environnement
        Rectangle futureHitbox = new Rectangle(50, 0, 50, 50);
        assertTrue(acteur.collisionAvecActeur(futureHitbox));
    }

    @Test
    public void testSeFaitAttaquer() {
        acteur.seFaitAttaquer(50);
        assertEquals(50, acteur.getPv());
    }

    @Test
    public void testSubitDegats() {
        acteur.subitDegats(30);
        assertEquals(70, acteur.getPv());
    }

    @Test
    public void bossAttaqueHero(){
        Boss boss = new Boss(300, 300, environnement, 1, 0,e);
        Hero h2 = new Hero(270, 270, environnement, 1, 0, e);
        environnement.ajouterActeur(boss);
        environnement.ajouterActeur(h2);
        assertEquals(100, h2.getPv());
        boss.attaquer();
        assertEquals(95, h2.getPv());
    }

    @Test
    public void testDeplacerVersSansCollision() {
        double cibleX = 450;
        double cibleY = 400;

        acteur.deplacerVers(cibleX, cibleY);

        assertEquals(cibleX, acteur.getPosition().getX(), 0.0001);
        assertEquals(cibleY, acteur.getPosition().getY(), 0.0001);
    }

    @Test
    public void testDeplacerVersAvecObstacle() {
        // Créer un autre acteur à la position cible
        Acteur a1 = new Acteur("a1", 500, 400, 100, 1.0, environnement, 1, 0);
        environnement.ajouterActeur(a1);

        double cibleX = 500;
        double cibleY = 400;

        // Enregistrer la position actuelle de l'acteur avant de tenter le déplacement
        double positionXInitiale = acteur.getPosition().getX();
        double positionYInitiale = acteur.getPosition().getY();

        // Appeler la méthode deplacerVers()
        acteur.deplacerVers(cibleX, cibleY);

        // Vérifier que l'acteur n'a pas bougé car il y a un obstacle (un autre acteur)
        assertEquals(positionXInitiale, acteur.getPosition().getX(), 0.0001);
        assertEquals(positionYInitiale, acteur.getPosition().getY(), 0.0001);
    }

    @Test
    public void guerisonActeur() {
        Pomme p=new Pomme(50,50,environnement);
        h.ajouterObjet(p);
        assertEquals(100, h.getPv(), 0.0001);
        h.subitDegats(30);
        h.guerison();
        assertEquals(75, h.getPv(), 0.0001);
    }
}
