package ba.unsa.etf.nrs.projekat.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProductManagementController {

    public Button btnBackProduct;

    public void backAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/managerPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnBackProduct.getScene().getWindow();
        zatvori.close();
    }
}
