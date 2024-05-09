package universite_paris8.iut.yponnou.zelda.vue;

public abstract class Pixable {
    private static int tailleCaseX;
    private static int tailleCaseY;

    public static int getTailleCaseX() {
        return tailleCaseX;
    }
    public static int getTailleCaseY() {
        return tailleCaseY;
    }

    public void setTailleCaseX(int tailleCaseX) {
        Pixable.tailleCaseX = tailleCaseX;
    }
    public void setTailleCaseY(int tailleCaseY) {
        Pixable.tailleCaseY = tailleCaseY;
    }

    public abstract void afficher();
}
