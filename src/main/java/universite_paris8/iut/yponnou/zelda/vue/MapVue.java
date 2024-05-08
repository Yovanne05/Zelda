package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapVue {
    private int[][] tab;
    private TilePane tilePane;
    public static int tailleCaseX;
    public static int tailleCaseY;

    public MapVue(int[][] tab, TilePane tilepane){
        this.tab = tab;
        this.tilePane = tilepane;
        tailleCaseX = (int)(tilepane.getPrefWidth() / tab.length);
        tailleCaseY = (int)(tilepane.getPrefHeight() / tab[0].length);
    }
    public void creationMap(){
        for(int i=0;i<tab.length;i++){
            for (int j=0;j<tab[i].length;j++){
                Rectangle rectangle = new Rectangle(tailleCaseX,tailleCaseY);
                rectangle.setX(i*tailleCaseX);
                rectangle.setY(j*tailleCaseY);
                if(tab[j][i]==0){
                    rectangle.setFill(Color.BLACK);
                }
                else{
                    rectangle.setFill(Color.RED);
                }
                tilePane.getChildren().add(rectangle);
            }
        }
    }
}
