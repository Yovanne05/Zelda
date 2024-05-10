package universite_paris8.iut.yponnou.zelda.vue;


import javafx.scene.layout.Pane;

import javax.swing.text.Element;

public abstract class Affichable {
    private int[][] tab;
    private Pane pane;
    private static int tailleCaseX;
    private static int tailleCaseY;

    public Affichable(int[][] tab, Pane pane) {
        this.tab = tab;
        this.pane = pane;
        tailleCaseX = (int)pane.getPrefWidth()/tab.length;
        tailleCaseY = (int)pane.getPrefHeight()/tab[0].length;
    }

    public int[][] getTab() {
        return tab;
    }
    public Pane getPane() {
        return pane;
    }

    public static int getTailleCaseX() {
        return tailleCaseX;
    }
    public static int getTailleCaseY() {
        return tailleCaseY;
    }

//    public void setTailleCaseX(int tailleCaseX) {
//        Affichable.tailleCaseX = tailleCaseX;
//    }
//    public void setTailleCaseY(int tailleCaseY) {
//        Affichable.tailleCaseY = tailleCaseY;
//    }

}
