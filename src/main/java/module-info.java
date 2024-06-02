module universite_paris8.iut.yponnou.zelda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

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
    exports universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments;
    opens universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments to javafx.fxml;
}