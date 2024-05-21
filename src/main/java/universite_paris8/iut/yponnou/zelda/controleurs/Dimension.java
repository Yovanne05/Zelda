package universite_paris8.iut.yponnou.zelda.controleurs;

public interface Dimension {
    int tailleCaseX = 50;
    int tailleCaseY = 50;

    default int getTailleCaseX(){
        return tailleCaseX;
    }
    default int getTailleCaseY(){
        return tailleCaseY;
    }
}