package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

public class ObjetVue {

    private Pane pane;
    private Objet objet;

    public ObjetVue(Objet objet, Pane pane) {
        this.pane = pane;
        this.objet = objet;
    }

    public Objet getObjet() {
        return objet;
    }
    public Pane getPane() {
        return pane;
    }

    public void creerSprite(){
        Rectangle r = new Rectangle(Constante.TAILLE50,Constante.TAILLE50);
        r.setFill(Color.GREEN);
        r.setId(objet.getId());
        r.setX(objet.getPosition().getX());
        r.setY(objet.getPosition().getY());
        pane.getChildren().add(r);
    }
}
