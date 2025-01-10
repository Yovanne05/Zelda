package universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion;

public class Direction {

    /**
     * La classe Direction représente la direction dans laquelle un acteur ou un objet se déplace dans l'environnement du jeu.
     * Elle est définie par un vecteur de direction.
     *
     * Cette classe offre des méthodes pour obtenir ou modifier la direction, changer la direction actuelle,
     * ainsi qu'une méthode pour convertir la direction en une chaîne de caractères (up, down, left, right).
     */


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
