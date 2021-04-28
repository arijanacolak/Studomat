package ba.unsa.etf.nrs;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    public Button nazad1Btn;
    public Button potvrdiBtn;
    public PasswordField passwFld;
    public Label labelaPoruka;
    public TextField usernameFld;

    public void izadjiAction(ActionEvent actionEvent) {
        ((Stage) nazad1Btn.getScene().getWindow()).close();
    }

    public void otvoriAction(ActionEvent actionEvent) throws IOException {
        if(validacija() == true) {
            labelaPoruka.setText("");
        }
        else {
            labelaPoruka.setText("Neispravni korisnički podaci.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Neispravni korisnički podaci.");
            alert.setContentText("Polja sa korisničkim podacima ne smiju biti prazna.");
            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("okAlertBtn");
            alert.showAndWait();
        }
    }
    public boolean validacija() {
        if(usernameFld.getText().isEmpty() || passwFld.getText().isEmpty()) return false;
        else return true;
    }
}
