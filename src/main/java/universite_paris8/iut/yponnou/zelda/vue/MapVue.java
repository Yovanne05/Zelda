package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.controleurs.Affichable;

public class MapVue extends Affichable {

    private int[][] tab;

    public MapVue(int[][] tab, TilePane tilePane) {
        super(tilePane);
        this.tab = tab;
    }

    public void affichageMap() {
        for(int y=0;y< tab.length;y++){
            for (int x=0; x < tab[y].length;x++){
                Rectangle rectangle = new Rectangle(getTailleCaseX(),getTailleCaseY());
                rectangle.setX(x*getTailleCaseX());
                rectangle.setY(y*getTailleCaseY());
                if(tab[y][x]==0){
                    rectangle.setFill(Color.BLACK);
                }
                else if (tab[y][x]==1){
                    rectangle.setFill(Color.RED);
                }
                getPane().getChildren().add(rectangle);
            }
        }
    }
}
