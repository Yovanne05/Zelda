package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapVue {
    private int[][] tab;
    private TilePane tilepane;
    public MapVue(int[][] tab, TilePane tilepane){
        this.tab=tab;
        this.tilepane=tilepane;
    }
    public void creationMap(){
        for(int i=0;i<tab.length;i++){
            for (int j=0;j<tab[i].length;j++){
                Rectangle rectangle = new Rectangle(50,50);
                rectangle.setX(i*50);
                rectangle.setY(j*50);
                if(tab[j][i]==1){
                    rectangle.setFill(Color.BLACK);
                }
                else{
                    rectangle.setFill(Color.RED);
                }
                tilepane.getChildren().add(rectangle);
            }
        }
    }
}
