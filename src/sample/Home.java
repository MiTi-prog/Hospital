package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.PropertyPermission;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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
    public DatePicker danasnjiDatum;
    public TextField ime;
    public TextField priimek;
    public TextField starost;
    public TextField spol;
    public TextField email;
    public TextField naslov;
    public TextField zdravstvena;

    public Label pacientDodan;
    public Label pregledDodan;

    public TableView<Pacient> table;

    public TableColumn<Pacient, String> tabIme;
    public TableColumn<Pacient, String> tabPriimek;
    public TableColumn<Pacient, String> tabStarost;
    public TableColumn<Pacient, String> tabSpol;
    public TableColumn<Pacient, String> tabEmail;
    public TableColumn<Pacient, String> tabNaslov;
    public TableColumn<Pacient, String> tabKartica;
    public TableColumn<Pacient, String> tabID;


    @FXML
    private Button odjavaButton;
    @FXML
    private Button izhodButton;
    @FXML
    private Button ponastaviButton;
    @FXML
    private Button shraniButton;

    ObservableList<Pacient> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String account = LoginController.userLog;
        String useridName = "SELECT account_id FROM sql11412420.user_account WHERE  username='"+account+"'";

        //System.out.println(useridName); // Username tega tipa ko se je prjavu

        int iDUsserja=1;

        try{


            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            Statement statement1 = connectDB.createStatement();
            ResultSet queryResult1 = statement1.executeQuery(useridName);

            while (queryResult1.next()){
                iDUsserja = queryResult1.getInt(1);
            }


            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM pacienti WHERE account_id="+String.valueOf(iDUsserja)+";");


            while (rs.next()){
                oblist.add(new Pacient(rs.getString("pacient_id"), rs.getString("pacient_ime"),
                        rs.getString("pacient_priimek"), rs.getString("pacient_starost"),
                        rs.getString("pacient_spol"), rs.getString("pacient_email"),
                        rs.getString("pacient_naslov"), rs.getString("pacient_st_kartice")));

            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        tabID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tabPriimek.setCellValueFactory(new PropertyValueFactory<>("priimek"));
        tabStarost.setCellValueFactory(new PropertyValueFactory<>("starost"));
        tabSpol.setCellValueFactory(new PropertyValueFactory<>("spol"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabNaslov.setCellValueFactory(new PropertyValueFactory<>("naslov"));
        tabKartica.setCellValueFactory(new PropertyValueFactory<>("stKartice"));

        table.setItems(oblist);

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

        pacientID.clear();
        kisik.clear();
        srcniUtrip.clear();
        pritisk.clear();
        diagnoza.clear();
        zdravilo.clear();
        ime.clear();
        priimek.clear();
        starost.clear();
        spol.clear();
        email.clear();
        naslov.clear();
        zdravstvena.clear();
        datumPregleda.getEditor().clear();
        danasnjiDatum.getEditor().clear();

    }

    public void saveCB(ActionEvent actionEvent) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idPacient = pacientID.getText();
        String pulz = srcniUtrip.getText();
        String kisikVKrvi = kisik.getText();
        String pritiskPacient = pritisk.getText();
        String ugotovljenaDiagnoza = diagnoza.getText();
        String predpisanoZdravilo = zdravilo.getText();
        String datum = datumPregleda.getEditor().getText();
        String datumDanes = danasnjiDatum.getEditor().getText();

        try{

            String inserFields = "INSERT INTO `pregled` (`diagnoza`, `srcni_utrip`, `pritisk`, `kisik_v_krvi`, `zdravilo`, `datum_pregleda`,`datum_naslednjega_pregleda`, `pacient_id`) VALUES('";
            String insertValues = ugotovljenaDiagnoza + "','" + pulz + "','" + pritiskPacient +  "','" +kisikVKrvi + "','" + predpisanoZdravilo + "','" +datumDanes + "','"  + datum +"','"+ idPacient + "')";
            String insertPacient = inserFields + insertValues;

            Statement statement2 = connectDB.createStatement();
            statement2.executeUpdate(insertPacient);

            pregledDodan.setText("Podatki pregleda uspešno dodani!");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
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