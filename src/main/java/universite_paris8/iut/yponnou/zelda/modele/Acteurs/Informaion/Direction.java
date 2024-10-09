package universite_paris8.iut.yponnou.zelda.modele.Acteurs.Informaion;

public class Direction {

    private Double dx;
    private Double dy;

    public Direction(Double dx, Double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Double getDx() {
        return dx;
    }

    public Double getDy() {
        return dy;
    }

    public void setDx(Double dx) {
        this.dx = dx;
    }

    public void setDy(Double dy) {
        this.dy = dy;
    }
}
