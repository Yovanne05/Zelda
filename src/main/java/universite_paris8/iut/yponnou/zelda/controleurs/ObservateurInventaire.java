//package universite_paris8.iut.yponnou.zelda.controleurs;
//
//import javafx.scene.Node;
//import javafx.scene.layout.HBox;
//
//import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Pomme;
//import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;
//import universite_paris8.iut.yponnou.zelda.vue.ObjetVue;
//import universite_paris8.iut.yponnou.zelda.vue.PommeVue;
//
//public class ObservateurInventaire extends ObservateurObjets {
//
//    public ObservateurInventaire(HBox hBox) {
//        super(hBox);
//    }
//
//    @Override
//    public void onChanged(Change<?extends Objet> change) {
//        Node node;
//        while (change.next()) {
//            for (Objet ob : change.getAddedSubList()) {
//                if (ob instanceof Pomme) {
//                    PommeVue pommeVue = new PommeVue((Pomme) ob, getPane());
//                    pommeVue.creerSprite();
//                }
//                else {
//                    ObjetVue objVue = new ObjetVue(ob, getPane());
//                    objVue.creerSprite();
//                }
//            }
//            for (Objet ob : change.getRemoved()) {
//                for (int i = 0; i < getPane().getChildren().size(); i++) {
//                    if (getPane().getChildren().get(i).getId().equals(ob.getId())) {
//                        node = getPane().getChildren().get(i);
//                        getPane().getChildren().remove(node);
//                    }
//                }
//            }
//        }
//    }
//}
