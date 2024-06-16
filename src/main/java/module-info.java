module universite_paris8.iut.yponnou.zelda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires junit;
    opens universite_paris8.iut.yponnou.zelda.modele.TestJunit to junit;

    opens universite_paris8.iut.yponnou.zelda to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda;
    exports universite_paris8.iut.yponnou.zelda.controleurs;
    opens universite_paris8.iut.yponnou.zelda.controleurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue;
    opens universite_paris8.iut.yponnou.zelda.vue to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele;
    opens universite_paris8.iut.yponnou.zelda.modele to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.Acteurs;
    opens universite_paris8.iut.yponnou.zelda.modele.Acteurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.Objets;
    opens universite_paris8.iut.yponnou.zelda.modele.Objets to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.Aliments;
    opens universite_paris8.iut.yponnou.zelda.modele.Aliments to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.Acteurs;
    opens universite_paris8.iut.yponnou.zelda.vue.Acteurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.Pv;
    opens universite_paris8.iut.yponnou.zelda.vue.Pv to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.Armes;
    opens universite_paris8.iut.yponnou.zelda.vue.Armes to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.vue.Nourritures;
    opens universite_paris8.iut.yponnou.zelda.vue.Nourritures to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.modele.Environnements;
    opens universite_paris8.iut.yponnou.zelda.modele.Environnements to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie;
    opens universite_paris8.iut.yponnou.zelda.controleurs.observateurs.vie to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs;
    opens universite_paris8.iut.yponnou.zelda.controleurs.observateurs.acteurs to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets;
    opens universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets to javafx.fxml;
}