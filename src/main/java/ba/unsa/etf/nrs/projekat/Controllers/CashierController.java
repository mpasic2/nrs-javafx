package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.PosDAO;
import com.github.sarxos.webcam.Webcam;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.google.zxing.Result;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class CashierController implements Initializable {
    public ObservableList<Product> products = FXCollections.observableArrayList();
    public TextField fldPriceQuant;
    public TextField fldQuant;
    public TextField fldSum;
    public TextField fldTotalSum;
    public TextField fldSearchProduct;
    public Button btnScan;
    public TableView tableId;
    public TextField fldTotalPaid;
    public TextField fldTotalReturn;
/*    public TableColumn colName;
    public TableColumn colPriceOnPice;
    public TableColumn colQuantity;
    public TableColumn colSumPrice;*/
    public TableColumn<Product,String> colName;
    public TableColumn<Product,String> colPriceOnPice;
    public TableColumn<Product,Integer> colQuantity;
    public TableColumn<Product,Double> colSumPrice;
    private Product selectedProduct ;
    public Label lblUsername;

    public ListView listOfProducts;//lista




    void initData(String cashier) {
        lblUsername.setText(cashier);
    }


    public void napuni() throws IOException {

        this.products.addAll(PosDAO.getInstance().getProducts());


    }

    private boolean searchFindsOrder(Product order, String searchText){
        return (order.getBarCode().toLowerCase().contains(searchText.toLowerCase()));
                //Integer.valueOf(order.getId()).toString().equals(searchText.toLowerCase());
    }

    private Predicate<Product> createPredicate(String searchText){
        return order -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsOrder(order, searchText);
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPriceOnPice.setCellValueFactory(new PropertyValueFactory<>("price"));

        try {
            napuni();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fldSearchProduct.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Product> filteredData = new FilteredList<>(FXCollections.observableList(products));
            filteredData.setPredicate(createPredicate(newValue));
            listOfProducts.setItems(filteredData);

        });

        listOfProducts.setItems(products);

        listOfProducts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selectedProduct = (Product) newValue;
                fldPriceQuant.setText(String.valueOf(selectedProduct.getPrice()));//nekako dobacit cijenu artikla po komadu
                fldQuant.setText("1");
                double suma = Double.parseDouble(fldPriceQuant.getText())*Double.parseDouble(fldQuant.getText());
                fldSum.setText(String.valueOf(suma));
            }
        });

    }



    public void scanAction(ActionEvent actionEvent) throws IOException {
        Webcam webcam = Webcam.getDefault(); // non-default (e.g. USB) webcam can be used too
        webcam.open();

        Result result = null;
        BufferedImage image = null;
        //ImageIO.write(webcam.getImage(), "PNG", new File("QR.png"));
        if (webcam.isOpen()) {
            image = webcam.getImage();


            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                // fall thru, it means there is no QR code in image
            }
        }

        if (result != null) {
            System.out.println("QR code data is: " + result.getText());
        }
    }

    public void addProductAction(ActionEvent actionEvent) throws IOException {
        String str = String.valueOf(listOfProducts.getSelectionModel().getSelectedItem());
        String barCode = str.split(" ")[2];
        Product pr = new Product();

        for(int i=0;i<products.size();i++){
            if(products.get(i).getBarCode().equals(barCode))
                pr=products.get(i);
        }

        Product realPr = new Product(pr.getName(),Integer.parseInt(fldQuant.getText()),pr.getPrice(),pr.getCategory(),pr.getDiscount(),pr.getBarCode());
        tableId.getItems().add(realPr);
        //double suma = Double.parseDouble(fldPriceQuant.getText())*Double.parseDouble(fldQuant.getText());
        //colSumPrice.getColumns().add(suma);

    }

    public void deleteProductAction(ActionEvent actionEvent) {
    }

    public void createBill(ActionEvent actionEvent) {
    }

    public void aboutProduct(ActionEvent actionEvent) {
    }

    public void logoutAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) fldPriceQuant.getScene().getWindow();
        zatvori.close();
    }

    public void printAction(ActionEvent actionEvent) {
    }

    public void doneAction(ActionEvent actionEvent) {
    }


}
