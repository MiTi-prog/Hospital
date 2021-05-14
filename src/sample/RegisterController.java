package sample;


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

public class RegisterController implements Initializable {
    @FXML
    private Label ConfirmPasswordMessageLabel1;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private ImageView shieldImageView;
    @FXML
    private TextField imeTextField;
    @FXML
    private TextField priimekTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField telefonTextField;
    @FXML
    private TextField specializacijaTextField;
    @FXML
    private PasswordField setPasswordPassField;
    @FXML
    private PasswordField confirmPasswordPassField;
    @FXML
    private Button registerButton;
    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldFile = new File("Files/icons8-login-as-user-90.png");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    public void registerCB(ActionEvent actionEvent) {
        //registrationMessageLabel.setText("User Has Been Registerd Successfiully!");
        if (setPasswordPassField.getText().equals(confirmPasswordPassField.getText())){
            //ConfirmPasswordMessageLabel1.setText("You are all set");
            registerUsser();
            ConfirmPasswordMessageLabel1.setText("");
          //registrationMessageLabel.setText("User Has Been Registerd Successfiully!");
        }else {
            ConfirmPasswordMessageLabel1.setText("Password does not match");
        }
    }

    public void closeCB(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
    }

    public void registerUsser(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstName = imeTextField.getText();
        String lastName = priimekTextField.getText();
        String usserName = usernameTextField.getText();
        String password = setPasswordPassField.getText();
        String specializacija = specializacijaTextField.getText();
        String telefon = telefonTextField.getText();
        String email = mailTextField.getText();

        String inserFields = "INSERT INTO sql11412420.user_account(username,password,ime,priimek,specializacija,email,telefon) VALUES('";
        String insertValues = usserName + "','" + password + "','" + firstName +  "','" +lastName + "','" + specializacija + "','" + email+ "','" + telefon + "')";
        String insertRegister = inserFields + insertValues;

        try{

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertRegister);

            registrationMessageLabel.setText("User Has Been Registerd Successfiully!");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }
}
