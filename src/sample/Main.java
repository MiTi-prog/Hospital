package sample;

import com.mysql.cj.log.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Stage mainLoginStage;

    @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            //primaryStage.setTitle("Hospital Assistant");

            mainLoginStage = primaryStage;
            mainLoginStage.close();
            LoginController.dashBoard.close();
            //mainLoginStage.initStyle(StageStyle.UNDECORATED);
            mainLoginStage.setResizable(false);
            mainLoginStage.setScene(new Scene(root, 800, 500));
            mainLoginStage.show();

        }

        public static void main(String[] args) {
            launch(args);
        }
}

//test purpose only