package ma.youcode.gestiona;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ma.youcode.gestiona.ImpDAO.FormateurAbsenceDAOImp;

import java.io.IOException;
import java.sql.SQLException;

public class SecPopupControler {
    FormateurAbsenceDAOImp formateurAbsenceDAOImp = new FormateurAbsenceDAOImp();

    @FXML
    private Button btnOui;

    public void popupOui() throws SQLException, IOException {
        formateurAbsenceDAOImp.delete("justifier");
        btnOui.getScene().getWindow().hide();
         Main.setRoot("secretaire");
    }

    public void popupNon() throws SQLException, IOException {
        btnOui.getScene().getWindow().hide();
    }


}
