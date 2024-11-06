package universite_paris8.iut.yponnou.zelda.modele.armes;


import universite_paris8.iut.yponnou.zelda.modele.acteurs.Guerrier;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;


public class ArcArme extends ArmeDistance {

    public ArcArme(double posxi, double posyi, Projectile projectile, Environnement environnement, Guerrier proprietaire) {
        super(posxi, posyi, projectile, environnement, proprietaire);
    }

    @Override
    public void utiliserArme() {
        creerFlecheDepuisHero();
        Projectile p = this.getProjectile();
        this.getEnvironnement().ajouterActeur(p);
        p.utiliserProjectile();
    }

    public void creerFlecheDepuisHero(){
        double dx = getProprietaire().getDirection().getDx();
        double dy = getProprietaire().getDirection().getDy();
        Direction d = new Direction(dx, dy);

        double posx = getProprietaire().getPosition().getX();
        double posy = getProprietaire().getPosition().getY();
        Fleche fleche = new Fleche(posx, posy, getEnvironnement(), d);
        this.setProjectile(fleche);
    }

    @Override
    public String nom(){
        return "Arc";
    }



}