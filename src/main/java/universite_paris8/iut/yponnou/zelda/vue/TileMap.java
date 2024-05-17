package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileMap extends Affichable {


    public TileMap(int[][] tab, TilePane tilePane) {
        super(tab,tilePane);
    }


    public void creerSprite() {
        for(int y=0;y< getTab().length;y++){
            for (int x=0; x < getTab()[y].length;x++){
                Rectangle rectangle = new Rectangle(getTailleCaseX(),getTailleCaseY());
                rectangle.setX(x*getTailleCaseX());
                rectangle.setY(y*getTailleCaseY());
                if(getTab()[y][x]==0){
                    rectangle.setFill(Color.BLACK);
                }
                else if (getTab()[y][x]==1){
                    rectangle.setFill(Color.BLUE);
                }
                getPane().getChildren().add(rectangle);
            }
        }
    }
}
