package universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion;

public class Direction {

    private int dx;
    private int dy;

    public Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void changementDirection(int dx, int dy) {
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
