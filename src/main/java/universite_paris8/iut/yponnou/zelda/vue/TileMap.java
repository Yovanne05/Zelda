package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileMap extends Affichable {


    public TileMap(int[][] tab, TilePane tilePane) {
        super(tab,tilePane);
    }


    public void creerSprite() {
        for(int i=0;i< getTab().length;i++){
            for (int j=0; j < getTab()[i].length;j++){
                Rectangle rectangle = new Rectangle(getTailleCaseX(),getTailleCaseY());
                rectangle.setX(i*getTailleCaseX());
                rectangle.setY(j*getTailleCaseY());
                if(getTab()[j][i]==0){
                    rectangle.setFill(Color.BLACK);
                }
                else if (getTab()[j][i]==1){
                    rectangle.setFill(Color.RED);
                }
                getPane().getChildren().add(rectangle);
            }
        }
    }
}
