package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Objet;

public class ObservateurInventaire extends ObservateurObjets {

    private static double x = 5;
    private static double y = 4;

    public ObservateurInventaire(Pane pane) {
        super(pane);
    }

    @Override
    public void creerSprite(Objet ob){

        Rectangle rectangle = new Rectangle(ObservateurObjets.getTailleCaseX(), ObservateurObjets.getTailleCaseY());
        rectangle.setFill(Color.GREEN);
        rectangle.setId(ob.getId());
        rectangle.setX(x);
        rectangle.setY(y);
        getPane().getChildren().add(rectangle);
        x += ObservateurObjets.getTailleCaseX()+10;
    }
}
