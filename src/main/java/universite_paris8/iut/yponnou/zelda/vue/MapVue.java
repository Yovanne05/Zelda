package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.Constante;

import java.util.ArrayList;
import java.util.List;

public class MapVue {

    private final Image grass;
    //PLATE
    private final Image plateKingdom;
    private final Image plateVillage;
    //NATURE
    private final Image arbre;
    //WATER
    private final Image water0;
    private final Image water1;
    private final Image water2;
    private final Image water3;
    private final Image water4;
    private final Image water5;
    private final Image water6;
    private final Image water7;
    private final Image water8;
    private final Image water9;
    private final Image water10;
    private final Image water11;
    private final Image water12;
    private final Image water13;
    //ROAD
    private final Image road0;
    private final Image road1;
    private final Image road2;
    private final Image road3;
    private final Image road4;
    private final Image road5;
    private final Image road6;
    private final Image road7;
    private final Image road8;
    private final Image road9;
    private final Image road10;
    private final Image road11;
    private final Image road12;
    //HOUSE
    private final Image house1;
    private final Image house2;
    private final Image house3;
    private final Image house4;
    private final Image house5;
    private final Image house6;
    private final Image house7;
    private final Image house8;
    private final Image house9;
    private final Image house10;
    private final Image house11;
    private final Image house12;
    private final Image house13;
    private final Image house14;
    private final Image house15;
    private final Image house16;
    ///////////////////////
    private final Image mossyBrick1;
    private final Image mossyBrick2;
    private final Image mossyCobble;
    private final Image floor_castle;
    private final Image cube_brick;
    private final Image cobblestone;
    private final Image dungeonDoor00;
    private final Image dungeonDoor01;
    private final Image dungeonDoor02;
    private final Image dungeonDoor03;
    private final Image dungeonDoor04;
    private final Image brick_stairs;
    private final Image brick_stairsL;
    private final Image brick_stairsR;
    /////LABURYNTH
    private final Image wall_LabLB;
    private final Image wall_LabBR;
    private final Image wall_LabLeft;
    private final Image wall_LabLT;
    private final Image wall_LabRight;
    private final Image wall_LabS;
    private final Image wall_LabTR;
    private final Image wall_LabUp;
    private final Image wall_LabX;
    private final Image wall_LabY;
    private final Image wall_LabM_B;
    private final Image wall_LabM_T;
    private final Image wall_LabM_R;
    private final Image wall_LabM_L;


    private final int[][] tab;
    private final TilePane tilePane;
    private int[][] tabNum;



    public MapVue(int[][] tab, TilePane tilePane) {
        this.tilePane=tilePane;
        this.tab = tab;
        grass = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/grass/grass01.png");
        arbre = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/nature/tree.png");
//PLATE
        plateVillage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/plate/plate_village.png");
        plateKingdom = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/plate/plate_castle.png");
//WATER
        water0= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water00.png");
        water1= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water01.png");
        water2= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water02.png");
        water3= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water03.png");
        water4= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water04.png");
        water5= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water05.png");
        water6= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water06.png");
        water7= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water07.png");
        water8= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water08.png");
        water9= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water09.png");
        water10= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water10.png");
        water11= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water11.png");
        water12= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water12.png");
        water13= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/water/water13.png");
//ROAD
        road0= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road00.png");
        road1= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road01.png");
        road2= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road02.png");
        road3= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road03.png");
        road4= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road04.png");
        road5= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road05.png");
        road6= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road06.png");
        road7= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road07.png");
        road8= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road08.png");
        road9= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road09.png");
        road10= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road10.png");
        road11= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road11.png");
        road12= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/road/road12.png");

//HOUSE
        house1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison1.png");
        house2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison2.png");
        house3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison3.png");
        house4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison4.png");
        house5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison5.png");
        house6 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison6.png");
        house7 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison7.png");
        house8 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison8.png");
        house9= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison9.png");
        house10 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison10.png");
        house11 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison11.png");
        house12 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison12.png");
        house13 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison13.png");
        house14 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison14.png");
        house15 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison15.png");
        house16 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/house/maison16.png");
        ///BRICKS
        mossyBrick1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/mossyBrick.PNG");
        mossyBrick2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/mossyBrick2.PNG");
        mossyCobble = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/mossyCobble.PNG");
        floor_castle = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/floor_castle.gif");
        cube_brick= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/cube_block_brick.PNG");
        cobblestone =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/Cobblestone.jpg");
        dungeonDoor00 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/dungeonDoor00.jpg");
        dungeonDoor01 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/dungeonDoor01.jpg");
        dungeonDoor02 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/dungeonDoor02.jpg");
        dungeonDoor03 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/dungeonDoor03.jpg");
        dungeonDoor04 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/dungeonDoor04.jpg");
        brick_stairs = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/staires.PNG");
        brick_stairsL =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/stairesL.PNG");
        brick_stairsR =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/bricks/stairesR.PNG");


/////LABURYNTH
        wall_LabLB= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabLB.gif");
        wall_LabBR= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabBR.gif");
        wall_LabLeft= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabLeft.gif");
        wall_LabLT= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabLT.gif");
        wall_LabRight= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabRight.gif");
        wall_LabS= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabS.gif");
        wall_LabTR= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabTR.gif");
        wall_LabUp= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabUp.gif");
        wall_LabX= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabX.gif");
        wall_LabY= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabY.gif");

        wall_LabM_B= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabM_B.gif");
        wall_LabM_T = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabM_T.gif");
        wall_LabM_R= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabM_R.gif");
        wall_LabM_L= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/textures/labyrinth/wall_LabM_L.gif");

    }

    public void creerSprite() {
        for (int y = 0; y < tab.length; y++) {
            for (int x = 0; x < tab[y].length; x++) {
                ImageView imageView;
//GRASS
                if (tab[y][x] == 0) {
                    imageView = new ImageView(grass);
                }
// TREE
                else if (tab[y][x] == 43) {
                    imageView = new ImageView(arbre);
                }
// PLATE
                else if (tab[y][x] == 41) {
                    imageView = new ImageView(plateVillage);
                }
                else if (tab[y][x] == 42) {
                    imageView = new ImageView(plateKingdom);
                }

// WATER
                else if (tab[y][x] == 20) {
                    imageView = new ImageView(water0);
                } else if (tab[y][x] == 21) {
                    imageView = new ImageView(water1);
                }else if (tab[y][x] == 22) {
                    imageView = new ImageView(water2);
                } else if (tab[y][x] == 23) {
                    imageView = new ImageView(water3);
                }else if (tab[y][x] == 24) {
                    imageView = new ImageView(water4);
                } else if (tab[y][x] == 25) {
                    imageView = new ImageView(water5);
                }else if (tab[y][x] == 26) {
                    imageView = new ImageView(water6);
                } else if (tab[y][x] == 27) {
                    imageView = new ImageView(water7);
                }else if (tab[y][x] == 28) {
                    imageView = new ImageView(water8);
                }else if (tab[y][x] == 29) {
                    imageView = new ImageView(water9);
                }else if (tab[y][x] == 30) {
                    imageView = new ImageView(water10);
                }else if (tab[y][x] == 31) {
                    imageView = new ImageView(water11);
                }else if (tab[y][x] == 32) {
                    imageView = new ImageView(water12);
                }else if (tab[y][x] == 33) {
                    imageView = new ImageView(water13);
                }
// ROAD
                else if (tab[y][x] == 1) {
                    imageView = new ImageView(road0);
                } else if (tab[y][x] == 2) {
                    imageView = new ImageView(road1);
                }else if (tab[y][x] == 3) {
                    imageView = new ImageView(road2);
                } else if (tab[y][x] == 4) {
                    imageView = new ImageView(road3);
                }else if (tab[y][x] == 5) {
                    imageView = new ImageView(road4);
                } else if (tab[y][x] == 6) {
                    imageView = new ImageView(road5);
                }else if (tab[y][x] == 7) {
                    imageView = new ImageView(road6);
                } else if (tab[y][x] == 8) {
                    imageView = new ImageView(road7);
                }else if (tab[y][x] == 9) {
                    imageView = new ImageView(road8);
                }else if (tab[y][x] == 10) {
                    imageView = new ImageView(road9);
                }else if (tab[y][x] == 11) {
                    imageView = new ImageView(road10);
                }else if (tab[y][x] == 12) {
                    imageView = new ImageView(road11);
                }else if (tab[y][x] == 13) {
                    imageView = new ImageView(road12);
                }
                /////////////////
                else if (tab[y][x] == 14) {
                    imageView = new ImageView(floor_castle);
                }else if (tab[y][x] == 71) {
                    imageView = new ImageView(mossyBrick1);
                }else if (tab[y][x] == 72) {
                    imageView = new ImageView(mossyBrick2);
                }else if (tab[y][x] == 73) {
                    imageView = new ImageView(mossyCobble);
                }else if (tab[y][x] == 74) {
                    imageView = new ImageView(cube_brick);
                }else if (tab[y][x] == 15) {
                    imageView = new ImageView(brick_stairs);
                }else if (tab[y][x] == 16) {
                    imageView = new ImageView(cobblestone);
                }else if (tab[y][x] == 17) {
                    imageView = new ImageView(brick_stairsL);
                }else if (tab[y][x] == 18) {
                        imageView = new ImageView(brick_stairsR);
                }else if (tab[y][x] == 75) {
                    imageView = new ImageView(dungeonDoor00);
                }else if (tab[y][x] == 76) {
                    imageView = new ImageView(dungeonDoor01);
                }else if (tab[y][x] == 77) {
                    imageView = new ImageView(dungeonDoor02);
                }else if (tab[y][x] == 78) {
                    imageView = new ImageView(dungeonDoor03);
                }else if (tab[y][x] == 79) {
                    imageView = new ImageView(dungeonDoor04);
                }
//HOUSE
                else if (tab[y][x] == 51) {
                    imageView = new ImageView(house1);
                } else if (tab[y][x] == 52) {
                    imageView = new ImageView(house2);
                }else if (tab[y][x] == 53) {
                    imageView = new ImageView(house3);
                } else if (tab[y][x] == 54) {
                    imageView = new ImageView(house4);
                }else if (tab[y][x] == 55) {
                    imageView = new ImageView(house5);
                } else if (tab[y][x] == 56) {
                    imageView = new ImageView(house6);
                }else if (tab[y][x] == 57) {
                    imageView = new ImageView(house7);
                } else if (tab[y][x] == 58) {
                    imageView = new ImageView(house8);
                }else if (tab[y][x] == 59) {
                    imageView = new ImageView(house9);
                }else if (tab[y][x] == 60) {
                    imageView = new ImageView(house10);
                }else if (tab[y][x] == 61) {
                    imageView = new ImageView(house11);
                }else if (tab[y][x] == 62) {
                    imageView = new ImageView(house12);
                }else if (tab[y][x] == 63) {
                    imageView = new ImageView(house13);
                }else if (tab[y][x] == 64) {
                    imageView = new ImageView(house14);
                }else if (tab[y][x] == 65) {
                    imageView = new ImageView(house15);
                }else if (tab[y][x] == 66) {
                    imageView = new ImageView(house16);
                }
                ///////////////Labirynth

                else if (tab[y][x] == 100) {
                    imageView = new ImageView(wall_LabLB);
                }else if (tab[y][x] == 101) {
                    imageView = new ImageView(wall_LabBR);
                } else if (tab[y][x] == 103) {
                    imageView = new ImageView(wall_LabLeft);
                }else if (tab[y][x] == 104) {
                    imageView = new ImageView(wall_LabLT);
                }else if (tab[y][x] == 105) {
                    imageView = new ImageView(wall_LabRight);
                }else if (tab[y][x] == 106) {
                    imageView = new ImageView(wall_LabS);
                }else if (tab[y][x] == 107) {
                    imageView = new ImageView(wall_LabTR);
                }else if (tab[y][x] == 108) {
                    imageView = new ImageView(wall_LabUp);
                }else if (tab[y][x] == 109) {
                    imageView = new ImageView(wall_LabX);
                }else if (tab[y][x] == 110) {
                    imageView = new ImageView(wall_LabY);
                }
                else if (tab[y][x] == 111) {
                    imageView = new ImageView(wall_LabM_B);
                }else if (tab[y][x] == 112) {
                    imageView = new ImageView(wall_LabM_T);
                }else if (tab[y][x] == 113) {
                    imageView = new ImageView(wall_LabM_R);
                }else if (tab[y][x] == 114) {
                    imageView = new ImageView(wall_LabM_L);
                }

                else {
                    continue; // Ignore other valuesz
                }

                imageView.setFitWidth(Constante.TAILLE50);
                imageView.setFitHeight(Constante.TAILLE50);
                imageView.setX(x * Constante.TAILLE50);
                imageView.setY(y * Constante.TAILLE50);
                tilePane.getChildren().add(imageView);
            }
        }
    }


    public void setMap(int[][] newMap) {
        this.tabNum = newMap;
    }
}