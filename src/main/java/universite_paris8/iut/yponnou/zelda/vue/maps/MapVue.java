package universite_paris8.iut.yponnou.zelda.vue.maps;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;


import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

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
    private final Image cube_brick;
    private final Image cobblestone;
    private final Image dungeonDoor1;
    private final Image dungeonDoor2;
    private final Image dungeonDoor3;
    private final Image dungeonDoor4;
    private final Image dungeonDoor6;
    private final Image doorInOutDungeon;
    private final Image dungeonDoor1D;
    private final Image dungeonDoor2D;
    private final Image dungeonDoor3D;
    private final Image dungeonDoor4D;
    private final Image dungeonDoor6D;
    private final Image brick_stairs;
    private final Image brick_stairsL;
    private final Image brick_stairsR;
    private final Image dungeon_brick;
    private final Image dungeon_brick_background;
    private final Image dungeon_brick_mur;

    /////LABYRINTHE
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
    private final Image prisonX;
    private final Image prisonY;
    private final Image prisonXY;


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
        mossyBrick1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/mossyBrick.PNG");
        mossyBrick2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/mossyBrick2.PNG");
        mossyCobble = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/mossyCobble.PNG");
        cube_brick= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/cube_block_brick.PNG");
        cobblestone =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/Cobblestone.jpg");
        dungeonDoor1 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor1.png");
        dungeonDoor2 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor2.png");
        dungeonDoor3 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor3.png");
        dungeonDoor4 =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor4.png");
        dungeonDoor6=new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor6.png");
        doorInOutDungeon =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor5.png");
        dungeonDoor1D =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor1D.png");
        dungeonDoor2D =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor2D.png");
        dungeonDoor3D =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor3D.png");
        dungeonDoor4D =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor4D.png");
        dungeonDoor6D=new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dungeondoor6D.png");
        brick_stairs = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/staires.PNG");
        brick_stairsL =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/stairesL.PNG");
        brick_stairsR =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/stairesR.PNG");
        dungeon_brick =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dangeon_bricks.gif");
        dungeon_brick_background =new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dangeon_bricks_background.gif");
        dungeon_brick_mur=new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/dangeon_bricks_mur.gif");
/////LABURYNTH
        wall_LabLB   = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabLB.gif");
        wall_LabBR   = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabBR.gif");
        wall_LabLeft = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabLeft.gif");
        wall_LabLT   = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabLT.gif");
        wall_LabRight= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabRight.gif");
        wall_LabS    = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabS.gif");
        wall_LabTR   = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabTR.gif");
        wall_LabUp   = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabUp.gif");
        wall_LabX    = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabX.gif");
        wall_LabY    = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabY.gif");

        wall_LabM_B = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabM_B.gif");
        wall_LabM_T = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabM_T.gif");
        wall_LabM_R = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabM_R.gif");
        wall_LabM_L = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/labyrinth/wall_LabM_L.gif");

        prisonX = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/prison3.png");
        prisonY= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/prison1.png");
        prisonXY= new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/textures/bricks/prison2.png");
    }

    public void creerSprite() {
        for (int y = 0; y < tab.length; y++) {
            for (int x = 0; x < tab[y].length; x++) {
                ImageView imageView;
                switch (tab[y][x]) {
                    case -1:
                        imageView = new ImageView(grass);
                        break;
                    case -2:
                        imageView = new ImageView(grass);
                        break;
                    case -3:
                        imageView = new ImageView(grass);
                        break;
                    case -4:
                        imageView = new ImageView(grass);
                        break;
                    case -5:
                        imageView = new ImageView(doorInOutDungeon);
                        break;
                    case -6:
                        imageView = new ImageView(doorInOutDungeon);
                        break;

                    // GRASS
                    case 0:
                        imageView = new ImageView(grass);
                        break;

                    // TREE
                    case 43:
                        imageView = new ImageView(arbre);
                        break;

                    // PLATE
                    case 41:
                        imageView = new ImageView(plateVillage);
                        break;
                    case 42:
                        imageView = new ImageView(plateKingdom);
                        break;

                    // WATER
                    case 20:
                        imageView = new ImageView(water0);
                        break;
                    case 21:
                        imageView = new ImageView(water1);
                        break;
                    case 22:
                        imageView = new ImageView(water2);
                        break;
                    case 23:
                        imageView = new ImageView(water3);
                        break;
                    case 24:
                        imageView = new ImageView(water4);
                        break;
                    case 25:
                        imageView = new ImageView(water5);
                        break;
                    case 26:
                        imageView = new ImageView(water6);
                        break;
                    case 27:
                        imageView = new ImageView(water7);
                        break;
                    case 28:
                        imageView = new ImageView(water8);
                        break;
                    case 29:
                        imageView = new ImageView(water9);
                        break;
                    case 30:
                        imageView = new ImageView(water10);
                        break;
                    case 31:
                        imageView = new ImageView(water11);
                        break;
                    case 32:
                        imageView = new ImageView(water12);
                        break;
                    case 33:
                        imageView = new ImageView(water13);
                        break;

                    // ROAD
                    case 1:
                        imageView = new ImageView(road0);
                        break;
                    case 2:
                        imageView = new ImageView(road1);
                        break;
                    case 3:
                        imageView = new ImageView(road2);
                        break;
                    case 4:
                        imageView = new ImageView(road3);
                        break;
                    case 5:
                        imageView = new ImageView(road4);
                        break;
                    case 6:
                        imageView = new ImageView(road5);
                        break;
                    case 7:
                        imageView = new ImageView(road6);
                        break;
                    case 8:
                        imageView = new ImageView(road7);
                        break;
                    case 9:
                        imageView = new ImageView(road8);
                        break;
                    case 10:
                        imageView = new ImageView(road9);
                        break;
                    case 11:
                        imageView = new ImageView(road10);
                        break;
                    case 12:
                        imageView = new ImageView(road11);
                        break;
                    case 13:
                        imageView = new ImageView(road12);
                        break;

                    // BRICKS AND DUNGEONS
                    case 71:
                        imageView = new ImageView(mossyBrick1);
                        break;
                    case 72:
                        imageView = new ImageView(mossyBrick2);
                        break;
                    case 73:
                        imageView = new ImageView(mossyCobble);
                        break;
                    case 74:
                        imageView = new ImageView(cube_brick);
                        break;
                    case 15:
                        imageView = new ImageView(brick_stairs);
                        break;
                    case 16:
                        imageView = new ImageView(cobblestone);
                        break;
                    case 17:
                        imageView = new ImageView(brick_stairsL);
                        break;
                    case 18:
                        imageView = new ImageView(brick_stairsR);
                        break;
                    case 75:
                        imageView = new ImageView(dungeonDoor1);
                        break;
                    case 76:
                        imageView = new ImageView(dungeonDoor2);
                        break;
                    case 77:
                        imageView = new ImageView(dungeonDoor3);
                        break;
                    case 78:
                        imageView = new ImageView(dungeonDoor4);
                        break;
                    case 80:
                        imageView = new ImageView(dungeonDoor6);
                        break;
                    case 14:
                        imageView = new ImageView(dungeon_brick);
                        break;
                    case 82:
                        imageView = new ImageView(dungeon_brick_background);
                        break;
                    case 83:
                        imageView = new ImageView(dungeon_brick_mur);
                        break;
                    case 84:
                        imageView = new ImageView(dungeonDoor1D);
                        break;
                    case 85:
                        imageView = new ImageView(dungeonDoor2D);
                        break;
                    case 86:
                        imageView = new ImageView(dungeonDoor3D);
                        break;
                    case 87:
                        imageView = new ImageView(dungeonDoor4D);
                        break;
                    case 88:
                        imageView = new ImageView(dungeonDoor6D);
                        break;


                    // HOUSES
                    case 51:
                        imageView = new ImageView(house1);
                        break;
                    case 52:
                        imageView = new ImageView(house2);
                        break;
                    case 53:
                        imageView = new ImageView(house3);
                        break;
                    case 54:
                        imageView = new ImageView(house4);
                        break;
                    case 55:
                        imageView = new ImageView(house5);
                        break;
                    case 56:
                        imageView = new ImageView(house6);
                        break;
                    case 57:
                        imageView = new ImageView(house7);
                        break;
                    case 58:
                        imageView = new ImageView(house8);
                        break;
                    case 59:
                        imageView = new ImageView(house9);
                        break;
                    case 60:
                        imageView = new ImageView(house10);
                        break;
                    case 61:
                        imageView = new ImageView(house11);
                        break;
                    case 62:
                        imageView = new ImageView(house12);
                        break;
                    case 63:
                        imageView = new ImageView(house13);
                        break;
                    case 64:
                        imageView = new ImageView(house14);
                        break;
                    case 65:
                        imageView = new ImageView(house15);
                        break;
                    case 66:
                        imageView = new ImageView(house16);
                        break;

                    // LABYRINTH
                    case 100:
                        imageView = new ImageView(wall_LabLB);
                        break;
                    case 101:
                        imageView = new ImageView(wall_LabBR);
                        break;
                    case 103:
                        imageView = new ImageView(wall_LabLeft);
                        break;
                    case 104:
                        imageView = new ImageView(wall_LabLT);
                        break;
                    case 105:
                        imageView = new ImageView(wall_LabRight);
                        break;
                    case 106:
                        imageView = new ImageView(wall_LabS);
                        break;
                    case 107:
                        imageView = new ImageView(wall_LabTR);
                        break;
                    case 108:
                        imageView = new ImageView(wall_LabUp);
                        break;
                    case 109:
                        imageView = new ImageView(wall_LabX);
                        break;
                    case 110:
                        imageView = new ImageView(wall_LabY);
                        break;
                    case 111:
                        imageView = new ImageView(wall_LabM_B);
                        break;
                    case 112:
                        imageView = new ImageView(wall_LabM_T);
                        break;
                    case 113:
                        imageView = new ImageView(wall_LabM_R);
                        break;
                    case 114:
                        imageView = new ImageView(wall_LabM_L);
                        break;
                    case 89:
                        imageView = new ImageView(prisonX);
                        break;
                    case 90:
                        imageView = new ImageView(prisonY);
                        break;
                    case 91:
                        imageView = new ImageView(prisonXY);
                        break;

                    // DEFAULT: Skip unknown values
                    default:
                        continue;
                }

                // Set size and position of the image view
                imageView.setFitWidth(TAILLE50);
                imageView.setFitHeight(TAILLE50);
                imageView.setX(x * TAILLE50);
                imageView.setY(y * TAILLE50);
                tilePane.getChildren().add(imageView);
            }
        }
    }

    public void setMap(int[][] newMap) {
        this.tabNum = newMap;
    }
}