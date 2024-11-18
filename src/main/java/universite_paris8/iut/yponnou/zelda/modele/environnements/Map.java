
package universite_paris8.iut.yponnou.zelda.modele.environnements;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map{

    /**
     * La classe Map représente une carte du jeu, stockant les éléments du terrain dans un tableau bidimensionnel.
     * Elle charge les données de la carte depuis des fichiers CSV et permet d'initialiser différents types d'environnements.
     */

    private int[][] tabNum;
    private int hauteur, largeur;

    public Map(int h, int l) {
        this.hauteur = h;
        this.largeur = l;
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

    //Lire le fichier CSV et remplir le tableau
    public void readFromCSV(String filePath) {
        ArrayList<int[]> tempList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int[] row = new int[values.length];
                for (int col = 0; col < values.length; col++) {
                    row[col] = Integer.parseInt(values[col].trim());
                }
                tempList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tabNum = new int[tempList.size()][30];

        for (int row = 0; row < tempList.size(); row++) {
            int[] values = tempList.get(row);
            for (int col = 0; col < values.length && col < tabNum[row].length; col++) {
                tabNum[row][col] = values[col]; // Copiez les valeurs dans tabNum
            }
        }
    }


    public void initialisationMapVillage() {
        readFromCSV("src/main/resources/universite_paris8/iut/yponnou/zelda/maps/village.csv");
    }
    public void initialisationMapLabyrinthe() {
        readFromCSV("src/main/resources/universite_paris8/iut/yponnou/zelda/maps/labyrinthe.csv");
    }
    public void initialisationMapDonjon() {
        readFromCSV("src/main/resources/universite_paris8/iut/yponnou/zelda/maps/donjon.csv");
    }
    public void initialisationMapEntreeDonjon() {
        readFromCSV("src/main/resources/universite_paris8/iut/yponnou/zelda/maps/entreeDonjon.csv");
    }

}
