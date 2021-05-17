package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    public TextField pacientID;
    public TextArea diagnoza;
    public TextField kisik;
    public TextField srcniUtrip;
    public TextField pritisk;
    public TextArea zdravilo;
    public DatePicker datumPregleda;
    public TextField ime;
    public TextField priimek;
    public TextField starost;
    public TextField spol;
    public TextField email;
    public TextField naslov;
    public TextField zdravstvena;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldFile = new File("Files/icons8-login-as-user-90.png");
    }

    public void dodajPacienta(ActionEvent actionEvent) {
    }

    public void resetCB(ActionEvent actionEvent) {
    }

    public void saveCB(ActionEvent actionEvent) {
    }

    public void exitCB(ActionEvent actionEvent) {
    }

    public void outCB(ActionEvent actionEvent) {
    }
}
