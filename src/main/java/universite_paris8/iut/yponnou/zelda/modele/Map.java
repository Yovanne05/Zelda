package universite_paris8.iut.yponnou.zelda.modele;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Map {
    private int[][] tab;
    private int h,l;
    public Map(int h, int l) {
        this.h=h;
        this.l=l;
        this.tab = new int[h][l];
    }

    public int getH() {
        return h;
    }

    public int getL() {
        return l;
    }

    public int[][] getTab() {
        return tab;
    }

    public void initialisationMap() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if ((i == 2 && j == 3) || (i == 5 && j == 7) || (i == 8 && j == 2) ||
                        (i == 4 && j == 6) || (i == 1 && j == 4) || (i == 7 && j == 5) ||
                        (i == 3 && j == 2) || (i == 6 && j == 1) || (i == 9 && j == 8) ||
                        (i == 2 && j == 7) || (i == 5 && j == 3) || (i == 8 && j == 5) ||
                        (i == 4 && j == 2) || (i == 1 && j == 8) || (i == 7 && j == 4) ||
                        (i == 3 && j == 6) || (i == 6 && j == 8) || (i == 9 && j == 1) ||
                        (i == 12 && j == 15) || (i == 17 && j == 18) || (i == 20 && j == 10) ||
                        (i == 14 && j == 16) || (i == 11 && j == 14) || (i == 18 && j == 15) ||
                        (i == 13 && j == 12) || (i == 16 && j == 11) || (i == 19 && j == 18) ||
                        (i == 12 && j == 17) || (i == 15 && j == 13)  || (i == 14 && j == 12) ||
                        (i == 11 && j == 18) || (i == 17 && j == 14) || (i == 13 && j == 16) ||
                        (i == 16 && j == 18) || (i == 19 && j == 11)) {
                    tab[i][j] = 0;
                } else {
                    tab[i][j] = 1;
                }
            }
        }
    }
}

