package ba.unsa.etf.nrs.projekat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class NewCashierController implements Initializable {
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
    private Product selectedProduct ;

    public ListView listOfProducts;//lista


    public void napuni(){
        this.products.add(new Product("Jabuke",20));
        this.products.add(new Product("Kruske",50));
        this.products.add(new Product("Banane", 10));
        this.products.add(new Product("Kasike",40));
        this.products.add(new Product("Ubrusi",40));
        this.products.add(new Product("Laptop",40));
        this.products.add(new Product("Parfem",40));
        this.products.add(new Product("Knjiga",40));
        //selectedProduct.set(null);
    }

    private boolean searchFindsOrder(Product order, String searchText){
        return (order.getSifra().toLowerCase().contains(searchText.toLowerCase()));
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
        napuni();
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
                fldPriceQuant.setText("10");//nekako dobacit cijenu artikla po komadu
                fldQuant.setText(String.valueOf(selectedProduct.getKolicina()));
                double suma = Integer.parseInt(fldPriceQuant.getText())*Integer.parseInt(fldQuant.getText());
                fldSum.setText(String.valueOf(suma));
            }
        });

    }



    public void scanAction(ActionEvent actionEvent) {
    }

    public void addProductAction(ActionEvent actionEvent) {
    }

    public void deleteProductAction(ActionEvent actionEvent) {
    }

    public void createBill(ActionEvent actionEvent) {
    }

    public void aboutProduct(ActionEvent actionEvent) {
    }

    public void logoutAction(ActionEvent actionEvent) {
    }

    public void printAction(ActionEvent actionEvent) {
    }

    public void doneAction(ActionEvent actionEvent) {
    }


}
