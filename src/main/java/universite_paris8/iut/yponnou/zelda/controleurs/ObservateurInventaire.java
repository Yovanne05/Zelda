package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Objet;

public class ObservateurInventaire extends ObservateurObjets {

    private static double x = 5;
    private static double y = 5;

    public ObservateurInventaire(HBox hBox) {
        super(hBox);
    }

    @Override
    public void creerSprite(Objet ob){
        Rectangle rectangle = new Rectangle(Constante.TAILLECASEX, Constante.TAILLECASEY);
        rectangle.setFill(Color.GREEN);
        rectangle.setId(ob.getId());
        rectangle.setX(x);
        rectangle.setY(y);
        getPane().getChildren().add(rectangle);
        x += Constante.TAILLECASEX+10;
    }
}