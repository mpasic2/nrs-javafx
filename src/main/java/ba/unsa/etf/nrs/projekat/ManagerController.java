package ba.unsa.etf.nrs.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ManagerController {


    public Button btnproductManagement1;


    public void productManagement(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/productManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnproductManagement1.getScene().getWindow();
        zatvori.close();
    }

    public void actionManagement(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/actionManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnproductManagement1.getScene().getWindow();
        zatvori.close();
    }

    public void userManagement(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/userManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnproductManagement1.getScene().getWindow();
        zatvori.close();
    }

    public void generateRecord(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/generateRecord.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnproductManagement1.getScene().getWindow();
        zatvori.close();
    }
}
