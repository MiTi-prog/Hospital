package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public Label pacientDodan;

    @FXML
    private Button odjavaButton;
    @FXML
    private Button izhodButton;
    @FXML
    private Button ponastaviButton;
    @FXML
    private Button shraniButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldFile = new File("Files/icons8-login-as-user-90.png");

        // tuki je treba nafilat še tabelo pacientov

    }

    public void dodajPacienta(ActionEvent actionEvent) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstName = ime.getText();
        String lastName = priimek.getText();
        String starostPacineta = starost.getText();
        String spolPacienta = spol.getText();
        String mail = email.getText();
        String naslovPacienta = naslov.getText();
        String zzzs = zdravstvena.getText();
        String account = LoginController.userLog;

        String useridName = "SELECT account_id FROM sql11412420.user_account WHERE  username='"+account+"'";

        //System.out.println(useridName); // Username tega tipa ko se je prjavu

        int iDUsserja=1;
        try{

            Statement statement1 = connectDB.createStatement();
            ResultSet queryResult1 = statement1.executeQuery(useridName);

            while (queryResult1.next()){
                iDUsserja = queryResult1.getInt(1);
            }

            String inserFields = "INSERT INTO sql11412420.pacienti(`pacient_ime`, `pacient_priimek`, `pacient_starost`, `pacient_spol`, `pacient_email`, `pacient_naslov`, `pacient_st_kartice`, `account_id`) VALUES('";
            String insertValues = firstName + "','" + lastName + "','" + starostPacineta +  "','" +spolPacienta + "','" + mail + "','" + naslovPacienta+ "','" + zzzs + "','" + String.valueOf(iDUsserja) +  "')";
            String insertPacient = inserFields + insertValues;


            Statement statement2 = connectDB.createStatement();
            statement2.executeUpdate(insertPacient);

            pacientDodan.setText("Pacient je Dodan Uspešno!");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }

    }

    public void resetCB(ActionEvent actionEvent) {

        // tu je treba vse TextFielde dat na nula torej ustvari pacienta pa v prelged

    }

    public void saveCB(ActionEvent actionEvent) {

        // tu pa je potrebbno naredit povezavo na bazo za pregled pa vnos podatkov

    }

    public void exitCB(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void outCB(ActionEvent actionEvent) {
        Stage stage = (Stage) odjavaButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
    }

}
