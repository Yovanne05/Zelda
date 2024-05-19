package universite_paris8.iut.yponnou.zelda.controleurs;


import javafx.scene.layout.Pane;

public abstract class Affichable {
    private Pane pane;
    private static final int tailleCaseX = 50;
    private static final int tailleCaseY = 50;

    public Affichable(Pane pane) {
        this.pane = pane;
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
