package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class MapVue extends Affichable {

    private Image grass;
    //PLATE
    private Image plateKingdom;
    private Image plateVillage;
    //NATURE
    private Image arbre;
    //WATER
    private Image water0;
    private Image water1;
    private Image water2;
    private Image water3;
    private Image water4;
    private Image water5;
    private Image water6;
    private Image water7;
    private Image water8;
    private Image water9;
    private Image water10;
    private Image water11;
    private Image water12;
    private Image water13;
    //ROAD
    private Image road0;
    private Image road1;
    private Image road2;
    private Image road3;
    private Image road4;
    private Image road5;
    private Image road6;
    private Image road7;
    private Image road8;
    private Image road9;
    private Image road10;
    private Image road11;
    private Image road12;
    //HOUSE
    private Image house1;
    private Image house2;
    private Image house3;
    private Image house4;
    private Image house5;
    private Image house6;
    private Image house7;
    private Image house8;
    private Image house9;
    private Image house10;
    private Image house11;
    private Image house12;
    private Image house13;
    private Image house14;
    private Image house15;
    private Image house16;


    private List<Rectangle> obstaclesHitboxes;


    public MapVue(int[][] tab, TilePane tilePane) {
        super(tab, tilePane);
        grass = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\grass\\grass01.png");
        arbre = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\nature\\tree.png");
//PLATE
        plateVillage = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\plate\\plate_village.png");
        plateKingdom = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\plate\\plate_castle.png");
//WATER
        water0= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water00.png");
        water1= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water01.png");
        water2= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water02.png");
        water3= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water03.png");
        water4= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water04.png");
        water5= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water05.png");
        water6= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water06.png");
        water7= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water07.png");
        water8= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water08.png");
        water9= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water09.png");
        water10= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water10.png");
        water11= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water11.png");
        water12= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water12.png");
        water13= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\water\\water13.png");
//ROAD
        road0= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road00.png");
        road1= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road01.png");
        road2= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road02.png");
        road3= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road03.png");
        road4= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road04.png");
        road5= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road05.png");
        road6= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road06.png");
        road7= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road07.png");
        road8= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road08.png");
        road9= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road09.png");
        road10= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road10.png");
        road11= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road11.png");
        road12= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\road\\road12.png");
//HOUSE
        house1 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison1.png");
        house2 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison2.png");
        house3 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison3.png");
        house4 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison4.png");
        house5= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison5.png");
        house6 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison6.png");
        house7 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison7.png");
        house8= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison8.png");
        house9= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison9.png");
        house10= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison10.png");
        house11 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison11.png");
        house12 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison12.png");
        house13 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison13.png");
        house14 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison14.png");
        house15 = new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison15.png");
        house16= new Image("file:src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\textures\\house\\maison16.png");







        obstaclesHitboxes = new ArrayList<>();
    }

    public void creerSprite() {
        for (int y = 0; y < getTab().length; y++) {
            for (int x = 0; x < getTab()[y].length; x++) {
                ImageView imageView;
//GRASS
                if (getTab()[y][x] == 0) {
                    imageView = new ImageView(grass);
                }
// TREE
                else if (getTab()[y][x] == 43) {
                    imageView = new ImageView(arbre);
                }
// PLATE
                else if (getTab()[y][x] == 41) {
                    imageView = new ImageView(plateVillage);
                }
                else if (getTab()[y][x] == 42) {
                    imageView = new ImageView(plateKingdom);
                }

// WATER
                else if (getTab()[y][x] == 20) {
                    imageView = new ImageView(water0);
                } else if (getTab()[y][x] == 21) {
                    imageView = new ImageView(water1);
                }else if (getTab()[y][x] == 22) {
                    imageView = new ImageView(water2);
                } else if (getTab()[y][x] == 23) {
                    imageView = new ImageView(water3);
                }else if (getTab()[y][x] == 24) {
                    imageView = new ImageView(water4);
                } else if (getTab()[y][x] == 25) {
                    imageView = new ImageView(water5);
                }else if (getTab()[y][x] == 26) {
                    imageView = new ImageView(water6);
                } else if (getTab()[y][x] == 27) {
                    imageView = new ImageView(water7);
                }else if (getTab()[y][x] == 28) {
                    imageView = new ImageView(water8);
                }else if (getTab()[y][x] == 29) {
                    imageView = new ImageView(water9);
                }else if (getTab()[y][x] == 30) {
                    imageView = new ImageView(water10);
                }else if (getTab()[y][x] == 31) {
                    imageView = new ImageView(water11);
                }else if (getTab()[y][x] == 32) {
                    imageView = new ImageView(water12);
                }else if (getTab()[y][x] == 33) {
                    imageView = new ImageView(water13);
                }
// ROAD
                else if (getTab()[y][x] == 1) {
                    imageView = new ImageView(road0);
                } else if (getTab()[y][x] == 2) {
                    imageView = new ImageView(road1);
                }else if (getTab()[y][x] == 3) {
                    imageView = new ImageView(road2);
                } else if (getTab()[y][x] == 4) {
                    imageView = new ImageView(road3);
                }else if (getTab()[y][x] == 5) {
                    imageView = new ImageView(road4);
                } else if (getTab()[y][x] == 6) {
                    imageView = new ImageView(road5);
                }else if (getTab()[y][x] == 7) {
                    imageView = new ImageView(road6);
                } else if (getTab()[y][x] == 8) {
                    imageView = new ImageView(road7);
                }else if (getTab()[y][x] == 9) {
                    imageView = new ImageView(road8);
                }else if (getTab()[y][x] == 10) {
                    imageView = new ImageView(road9);
                }else if (getTab()[y][x] == 11) {
                    imageView = new ImageView(road10);
                }else if (getTab()[y][x] == 12) {
                    imageView = new ImageView(road11);
                }else if (getTab()[y][x] == 13) {
                    imageView = new ImageView(road12);
                }
//HOUSE
                else if (getTab()[y][x] == 51) {
                    imageView = new ImageView(house1);
                } else if (getTab()[y][x] == 52) {
                    imageView = new ImageView(house2);
                }else if (getTab()[y][x] == 53) {
                    imageView = new ImageView(house3);
                } else if (getTab()[y][x] == 54) {
                    imageView = new ImageView(house4);
                }else if (getTab()[y][x] == 55) {
                    imageView = new ImageView(house5);
                } else if (getTab()[y][x] == 56) {
                    imageView = new ImageView(house6);
                }else if (getTab()[y][x] == 57) {
                    imageView = new ImageView(house7);
                } else if (getTab()[y][x] == 58) {
                    imageView = new ImageView(house8);
                }else if (getTab()[y][x] == 59) {
                    imageView = new ImageView(house9);
                }else if (getTab()[y][x] == 60) {
                    imageView = new ImageView(house10);
                }else if (getTab()[y][x] == 61) {
                    imageView = new ImageView(house11);
                }else if (getTab()[y][x] == 62) {
                    imageView = new ImageView(house12);
                }else if (getTab()[y][x] == 63) {
                    imageView = new ImageView(house13);
                }else if (getTab()[y][x] == 64) {
                    imageView = new ImageView(house14);
                }else if (getTab()[y][x] == 65) {
                    imageView = new ImageView(house15);
                }else if (getTab()[y][x] == 66) {
                    imageView = new ImageView(house16);
                }

                else {
                    continue; // Ignore other valuesz
                }

                imageView.setFitWidth(getTailleCaseX());
                imageView.setFitHeight(getTailleCaseY());
                imageView.setX(x * getTailleCaseX());
                imageView.setY(y * getTailleCaseY());
                getPane().getChildren().add(imageView);
            }
        }
    }







    public List<Rectangle> getObstacleHitboxes() {
        return obstaclesHitboxes;
    }
}
