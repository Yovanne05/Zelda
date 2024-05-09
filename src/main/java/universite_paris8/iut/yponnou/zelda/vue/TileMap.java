package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileMap extends Pixable {

    private int[][] tab;
    private TilePane tilePane;

    public TileMap(int[][] tab, TilePane tilePane) {
        this.tab = tab;
        this.tilePane = tilePane;
        setTailleCaseX((int)(tilePane.getPrefWidth() / tab.length));
        setTailleCaseY((int)(tilePane.getPrefHeight() / tab[0].length));
    }

    public int[][] getTab() {
        return tab;
    }
    public TilePane getTilePane() {
        return tilePane;
    }

    @Override
    public void afficher() {
        for(int i=0;i<getTab().length;i++){
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
                getTilePane().getChildren().add(rectangle);
            }
        }
    }
}
