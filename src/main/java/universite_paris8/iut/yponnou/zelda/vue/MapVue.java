package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;

public class MapVue extends Constante {

    private int[][] tab;
    private TilePane tilePane;

    public MapVue(int[][] tab, TilePane tilePane) {
        this.tilePane=tilePane;
        this.tab = tab;
    }

    public void affichageMap() {
        for(int y=0;y< tab.length;y++){
            for (int x=0; x < tab[y].length;x++){
                Rectangle rectangle = new Rectangle(TAILLECASEX,TAILLECASEY);
                rectangle.setX(x*TAILLECASEX);
                rectangle.setY(y*TAILLECASEY);
                if(tab[y][x]==0){
                    rectangle.setFill(Color.BLACK);
                }
                else if (tab[y][x]==1){
                    rectangle.setFill(Color.RED);
                }
                tilePane.getChildren().add(rectangle);
            }
        }
    }
}
