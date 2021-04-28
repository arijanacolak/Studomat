package nrs;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class LoginControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Studomat");
        stage.setScene(new Scene(root, 668, 529));
        stage.show();
        stage.toFront();
    }
    @Test
    public void testButtonPotvrdiClick (FxRobot robot) {
        Button btnPotvrdi = robot.lookup("#potvrdiBtn").queryAs(Button.class);
        robot.clickOn(btnPotvrdi);
        Button btnOk = robot.lookup("#okAlertBtn").queryAs(Button.class);
        robot.clickOn(btnOk);
        Label labela = robot.lookup("#labelaPoruka").queryAs(Label.class);
        assertTrue(labela.getText().equals("Neispravni korisnički podaci."));
    }

}