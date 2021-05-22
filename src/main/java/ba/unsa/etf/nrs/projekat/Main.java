package ba.unsa.etf.nrs.projekat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));*/
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/warehousePage.fxml"));
        primaryStage.setTitle("POS kasa");
        primaryStage.setScene(new Scene(root,USE_COMPUTED_SIZE , USE_COMPUTED_SIZE));
        //primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
