module universite_paris8.iut.yponnou.zelda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires junit;
    requires org.junit.jupiter.api;
    requires org.testng;
    requires jcommander;

    opens universite_paris8.iut.yponnou.zelda to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda;
    exports universite_paris8.iut.yponnou.zelda.controleurs;
    opens universite_paris8.iut.yponnou.zelda.controleurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.acteurs;
    opens universite_paris8.iut.yponnou.zelda.modele.acteurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.objets;
    opens universite_paris8.iut.yponnou.zelda.modele.objets to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.aliments;
    opens universite_paris8.iut.yponnou.zelda.modele.aliments to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.acteurs_vue;
    opens universite_paris8.iut.yponnou.zelda.vue.acteurs_vue to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.pv_vue;
    opens universite_paris8.iut.yponnou.zelda.vue.pv_vue to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.armes_vue;
    opens universite_paris8.iut.yponnou.zelda.vue.armes_vue to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.nourritures_vue;
    opens universite_paris8.iut.yponnou.zelda.vue.nourritures_vue to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.environnements;
    opens universite_paris8.iut.yponnou.zelda.modele.environnements to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie;
    opens universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs;
    opens universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets;
    opens universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.objets_vue;
    opens universite_paris8.iut.yponnou.zelda.vue.objets_vue to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.maps_vue;
    opens universite_paris8.iut.yponnou.zelda.vue.maps_vue to javafx.fxml;

}