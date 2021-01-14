module ma.youcode.gestiona {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ma.youcode.gestiona to javafx.fxml;
    exports ma.youcode.gestiona;
}
