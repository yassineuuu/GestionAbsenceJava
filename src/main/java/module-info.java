module ma.youcode.gestiona {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires java.prefs;

    opens ma.youcode.gestiona to javafx.fxml;
    exports ma.youcode.gestiona;

    opens ma.youcode.gestiona.Modeles to javafx.fxml;
    exports ma.youcode.gestiona.Modeles;

}
