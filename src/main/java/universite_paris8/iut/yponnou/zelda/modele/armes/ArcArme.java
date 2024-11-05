package universite_paris8.iut.yponnou.zelda.modele.armes;


import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class ArcArme extends ArmeDistance {


    public ArcArme(double posxi, double posyi, Projectile projectile, Environnement environnement) {
        super(posxi, posyi, projectile, environnement);
    }

    @Override
    public void utiliserArme() {
        Projectile p = this.getProjectile();
        this.getEnvironnement().ajouterActeur(p);
        p.utiliserProjectile();
    }

    @Override
    public String nom(){
        return "Arc";
    }



}