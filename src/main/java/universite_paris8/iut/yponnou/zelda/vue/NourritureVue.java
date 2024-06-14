package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Nourriture;

import static universite_paris8.iut.yponnou.zelda.Constante.TAILLE50;


public class NourritureVue extends ObjetVue{

    public NourritureVue(Nourriture nourriture, Pane pane) {
        super(nourriture, pane);
    }

    @Override
    public void creerSprite(){
        Rectangle r = new Rectangle(TAILLE50,TAILLE50);
        r.setFill(Color.ORANGE);
        r.setId(getObjet().getId());
        r.setX(getObjet().getPosition().getX());
        r.setY(getObjet().getPosition().getY());
        getPane().getChildren().add(r);
    }
}
