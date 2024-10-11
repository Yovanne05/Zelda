package universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion;

public class Direction {

    private double dx;
    private double dy;

    public Direction(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void changementDirection(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public String directionString() {
        String direction = "";
        if(dx==0 && dy==-1) {
            direction = "up";
        }else if(dx==0 && dy==1) {
            direction = "down";
        }else if(dx==-1 && dy==0) {
            direction = "left";
        }else if(dx==1 && dy==0) {
            direction = "right";
        }
        return direction;
    }
}
