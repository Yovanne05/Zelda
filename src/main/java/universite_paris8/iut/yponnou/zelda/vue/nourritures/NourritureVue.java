package universite_paris8.iut.yponnou.zelda.vue.nourritures;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Nourriture;
import universite_paris8.iut.yponnou.zelda.vue.objets.ObjetVue;


public class NourritureVue extends ObjetVue {

    public NourritureVue(Nourriture nourriture, Pane pane) {
        super(nourriture, pane);
    }

    @Override
    public void creerSprite(){
        Rectangle r = new Rectangle(Constante.TAILLE16,Constante.TAILLE16);
        r.setFill(Color.ORANGE);
        r.setId(getObjet().getId());
        r.setX(getObjet().getPosition().getX());
        r.setY(getObjet().getPosition().getY());
        getPane().getChildren().add(r);
    }
}
