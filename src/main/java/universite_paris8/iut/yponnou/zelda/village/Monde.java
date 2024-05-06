package universite_paris8.iut.yponnou.zelda.village;

import java.util.Random;

public class Monde {


    private int[][] tab;

    public Monde(int h, int l) {
        this.tab = new int[h][l];
    }

    public int[][] getTab() {
        return tab;
    }

    public void creationMap() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i%7==0 || j%8==0) {
                    tab[i][j]=0;
                }else {
                    tab[i][j]=1;
            }
        }
    }


}
}
