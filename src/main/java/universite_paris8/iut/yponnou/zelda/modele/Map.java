package universite_paris8.iut.yponnou.zelda.modele;


public class Map{
    private int[][] tabNum;
    private int hauteur, largeur;

    public Map(int h, int l) {
        this.hauteur =h;
        this.largeur =l;
        this.tabNum = new int[h][l];
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int[][] getTabNum() {
        return tabNum;
    }

    public void initialisationMap() {
        for (int i = 0; i < tabNum.length; i++) {
            for (int j = 0; j < tabNum[i].length; j++) {
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
                    tabNum[i][j] = 1;
                } else {
                    tabNum[i][j] = 0;
                }
            }
        }
    }
}

