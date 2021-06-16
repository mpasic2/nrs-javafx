package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.Classes.User;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class UserManagementController implements Initializable {

    public Button btnBackUser;
    public ListView usersList;
    public TextField firstNameFld;
    public TextField lastNameFld;
    public TextField usernameFld;
    public TextField passwordFld;
    public TextField emailFld;
    public TextField phoneFld;
    public TextField addressFld;
    public DatePicker birthDatePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<User>users = null;
        try {
            users = PosDAO.getInstance().getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        usersList.setItems(users);
    }


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
        Stage zatvori = (Stage) btnBackUser.getScene().getWindow();
        zatvori.close();
    }

    public void changeBtn(ActionEvent actionEvent) {
    }

    public void addBtn(ActionEvent actionEvent) {
    }
}
