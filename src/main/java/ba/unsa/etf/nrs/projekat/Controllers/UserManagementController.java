package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.Classes.User;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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


        usersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User stari, User novi) {
                //usersList.setSelectionModel().select(novi);
                if(stari!=null) {
                    firstNameFld.textProperty().unbindBidirectional(stari.firstNameProperty());
                    lastNameFld.textProperty().unbindBidirectional(stari.lastNameProperty());
                    emailFld.textProperty().unbindBidirectional(stari.emailProperty());
                    usernameFld.textProperty().unbindBidirectional(stari.usernameProperty());
                    passwordFld.textProperty().unbindBidirectional(stari.passwordProperty());
                    addressFld.textProperty().unbindBidirectional(stari.adressProperty());
                    phoneFld.textProperty().unbindBidirectional(stari.phoneProperty());
                    //birthDatePicker.textProperty().unbindBidirectional(stari.passwordProperty());
                }
                if(novi==null){
                    firstNameFld.setText("");
                    lastNameFld.setText("");
                    emailFld.setText("");
                    usernameFld.setText("");
                    passwordFld.setText("");
                    addressFld.setText("");
                    phoneFld.setText("");
                    //birthDatePicker.setText("");

                }
                else{

                    firstNameFld.textProperty().bindBidirectional(novi.firstNameProperty());
                    lastNameFld.textProperty().bindBidirectional(novi.lastNameProperty());
                    emailFld.textProperty().bindBidirectional(novi.emailProperty());
                    usernameFld.textProperty().bindBidirectional(novi.usernameProperty());
                    passwordFld.textProperty().bindBidirectional(novi.passwordProperty());
                    addressFld.textProperty().bindBidirectional(novi.adressProperty());
                    phoneFld.textProperty().bindBidirectional(novi.phoneProperty());
                    //birthDatePicker.textProperty().bindBidirectional(novi.passwordProperty());
                }

            }
        });


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

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Stage noviProzor = new Stage();
        Parent roditelj = FXMLLoader.load(getClass().getResource("/fxml/addNewUser.fxml"));
        noviProzor.setTitle("Dodavanje korisnika");
        Scene scene = new Scene(roditelj, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        noviProzor.setScene(scene);
        noviProzor.show();

        Stage zatvaranjePoruka = (Stage) firstNameFld.getScene().getWindow();
        zatvaranjePoruka.close();
    }
}
