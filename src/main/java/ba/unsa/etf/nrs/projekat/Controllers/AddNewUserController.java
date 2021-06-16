package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Employee;
import ba.unsa.etf.nrs.projekat.Classes.User;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class AddNewUserController implements Initializable {


    public Button nazdIdBtn;
    public TextField firstName;
    public TextField lastName;
    public TextField username;
    public TextField password;
    public TextField email;
    public TextField phone;
    public TextField address;
    public DatePicker birthPicker;
    public DatePicker hireDatePicker;
    public ChoiceBox rolePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rolePicker.getItems().addAll("Kasir","Menadzer","Skladistar");
    }

    public void onActionBack(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/userManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();

        Stage zatvori = (Stage) nazdIdBtn.getScene().getWindow();
        zatvori.close();
    }


    public void onActionAddUser(ActionEvent actionEvent) throws IOException {
        int usersSize = PosDAO.getInstance().getUsers().size();
        User user = new User(usersSize+1,firstName.getText(),lastName.getText(),username.getText(),password.getText(),email.getText(),phone.getText(),address.getText(),birthPicker.getValue());
        PosDAO.getInstance().addUser(user);

        int empSize = PosDAO.getInstance().getEmployees().size();
        //Employee emp = new Employee(empSize+1,usersSize+1,1,hireDatePicker.getValue(),rolePicker.getValue().toString(), (Integer) rolePicker.getValue());
        //PosDAO.getInstance().add
    }


}
