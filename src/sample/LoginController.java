package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;



public class LoginController implements Initializable {

    public static Stage mainRegistrationStage = new Stage();
    public static Stage dashBoard = new Stage();

    public static String userLog=""; // tuk sam da vemo kdo se je prjavu not ker user

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabble;

    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockimageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Files/2762370.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File  lockFile = new File("Files/icons8-lock-64.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockimageView.setImage(lockImage);
    }

    public void loginCB(ActionEvent actionEvent) {

        // loginMessageLabble.setText("Invalid Login. Please try Again");
        if (usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false ){
            validateLogin();
            //loginMessageLabble.setText("You Try To Login");
        }else {
            loginMessageLabble.setText("Please enter username and passoword");

        }
    }

    public void cancelCB(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM sql11412420.user_account WHERE  username='"+usernameTextField.getText()+"' AND password='"+passwordTextField.getText() +"'";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1)==1){
                    loginMessageLabble.setText("Congrats!");
                    //createAccountForm();
                    userLog = usernameTextField.getText();
                    dashBoard.close();
                    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    root.getStylesheets().add("sample/style.css");
                    dashBoard.setScene(new Scene(root));
                    //set stage borderless
                    Main.mainLoginStage.close();
                    dashBoard.setResizable(false);
                    dashBoard.show();

                }else {
                    loginMessageLabble.setText("Invalid Login. Please try Again!");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }

    public void createAccountForm(){

        try{

            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));

            mainRegistrationStage.close();
            //mainRegistrationStage.initStyle(StageStyle.UNDECORATED); //to jee problem biu
            mainRegistrationStage.setResizable(false);
            mainRegistrationStage.setScene(new Scene(root, 800, 500));
            mainRegistrationStage.show();
            Main.mainLoginStage.close();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


}