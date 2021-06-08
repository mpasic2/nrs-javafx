package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Employee;
import ba.unsa.etf.nrs.projekat.Classes.User;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class DeleteUsersController implements Initializable {

    public Button deleteBtn;
    public PosDAO baza = new PosDAO();
    public TableView<Employee> tblEmploys;
    public TableColumn<Employee,Integer> colEmplyId;
    public TableColumn<Employee,String> colEmplyName;
    public TableColumn<Employee,String> colEmplyJob;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            tblEmploys.setItems(baza.getEmployees());
            colEmplyId.setCellValueFactory(new PropertyValueFactory<>("id"));
            //colEmplyName.setCellValueFactory(cellData -> Bindings.createStringBinding(() -> usr.getFirstName() + " " + usr.getLastName()));
            colEmplyName.setCellValueFactory(cellData -> Bindings.createStringBinding(() -> imePrezime(cellData.getValue().getId())));
            colEmplyJob.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJobTitle()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String imePrezime(int id) throws IOException {
        Employee emp = baza.getEmployeeById(id);
        User usr = baza.getUserById(emp.getUserId());

        return usr.getFirstName() + " " + usr.getLastName();
    }

    public void managerBack(ActionEvent actionEvent) throws SQLException, IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/managerPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) deleteBtn.getScene().getWindow();
        zatvori.close();
    }

    public void onActionDelete(ActionEvent actionEvent) { }
}
