package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Bill;
import ba.unsa.etf.nrs.projekat.Classes.Order;
import ba.unsa.etf.nrs.projekat.Classes.Product;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("POS kasa");
        primaryStage.setScene(new Scene(root,USE_COMPUTED_SIZE , USE_COMPUTED_SIZE));
        //primaryStage.setResizable(false);
        primaryStage.show();
/*        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/cashierMybPage.fxml"));
        cashierMybPageController ctrl = new cashierMybPageController("mustafa");
        loader.setController(ctrl);
        Parent root = loader.load();
        primaryStage.setTitle("POS Kasa");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();*/
//    PosDAO posDAO = PosDAO.getInstance();
//        System.out.printf(String.valueOf(posDAO.getUser(0).firstName));
        //  ObservableList<Bill> sss = PosDAO.getInstance().getBills();
        //System.out.println(sss);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
