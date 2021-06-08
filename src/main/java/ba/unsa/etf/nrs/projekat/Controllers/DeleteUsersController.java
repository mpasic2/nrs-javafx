package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Employee;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class DeleteUsersController implements Initializable {

    public Button votePageBack;
    public Button deleteBtn;
    public PosDAO baza = new PosDAO();
    public TableView<Employee> tblEmploys;
    public TableColumn<Employee,Integer> colEmplyId;
    public TableColumn<Employee,String> colEmplyName;
    public TableColumn<Employee,String> colEmplyJob;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void votePageBackAction(ActionEvent actionEvent) throws SQLException, IOException { }

    public void onActionDelete(ActionEvent actionEvent) { }
}
