module universite_paris8.iut.yponnou.zelda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens universite_paris8.iut.yponnou.zelda to javafx.fxml;
    exports universite_paris8.iut.yponnou.zelda;
    exports universite_paris8.iut.yponnou.zelda.controleurs;
    opens universite_paris8.iut.yponnou.zelda.controleurs to javafx.fxml;
}