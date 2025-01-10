package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs;//
//package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs;
//
//import javafx.collections.ListChangeListener;
//import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
//import universite_paris8.iut.yponnou.zelda.modele.Armes.Projectile;
//import universite_paris8.iut.yponnou.zelda.vue.Armes.FlecheVue;
//import javafx.scene.layout.Pane;
//
//public class ObservateurProjectiles implements ListChangeListener<Projectile> {
//
//    private Pane pane;
//
//    public ObservateurProjectiles(Pane pane) {
//        this.pane=pane;
//    }
//    @Override
//    public void onChanged(Change<? extends Projectile> change) {
//        while (change.next()) {
//            for (Projectile a : change.getAddedSubList()) {
//                FlecheVue f = new FlecheVue(pane, (Fleche) a);
//                f.creerSprite();
//            }
//            for (Projectile a : change.getRemoved()) {
//                for (int i = 0; i < pane.getChildren().size(); i++) {
//                    this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));
//
//                }
//            }
//        }
//    }
//}
