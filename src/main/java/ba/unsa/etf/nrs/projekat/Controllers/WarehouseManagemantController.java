package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.Classes.User;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextInputDialog;

public class WarehouseManagemantController implements Initializable {


    public ListView listProducts1;
    public TextField fldQuantity;
    public TextField fldBarCode;
    public ObservableList<Product> products = FXCollections.observableArrayList();
    private Product selectedProduct ;

    public void napuni() throws IOException {

        this.products.addAll(PosDAO.getInstance().getProducts());


    }

    public void btnAddProduct(ActionEvent actionEvent) {
        if(fldBarCode.getText()!="" && fldQuantity.getText()!=""){
            //products.add(new Product(fldBarCode.getText(),Integer.parseInt(fldQuantity.getText())));
            addProduct(fldBarCode.getText(),Integer.parseInt(fldQuantity.getText()));
        }
        listProducts1.refresh();
        fldBarCode.setText("");
        fldQuantity.setText("");
    }

    public void btnRemove(ActionEvent actionEvent) {

        deleteProduct(selectedProduct);
        listProducts1.refresh();
    }

    private void deleteProductQuantity(int br){

        for(Product produkt : products){
            if(produkt.getBarCode().equals(selectedProduct.getBarCode())){
                if(produkt.getQuantity()>1 && br<produkt.getQuantity()) {
                    produkt.setQuantity(produkt.getQuantity() - br);
                }else deleteProduct(selectedProduct);
            }
        }

    }
    private void addProductQuantity(int br){

        for(Product produkt : products)
            if(produkt.getBarCode().equals(selectedProduct.getBarCode()))
                    produkt.setQuantity(produkt.getQuantity() + br);

    }

    private void deleteProduct(Product produkt){
        products.removeIf(produkt::equals);
    }

    public void addProduct(String a, int b){
       /*int temp=0;
        for(Product produkt : products){
            if(produkt.getSifra().equals(a)){
                produkt.setKolicina(produkt.getKolicina()+b);
                temp=1;
            }
        }
       if(temp!=1)
        products.add(new Product(a,b));*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            napuni();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listProducts1.setItems(products);
        listProducts1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product stari, Product novi) {
                //usersList.setSelectionModel().select(novi);
                if(stari!=null) {
                    fldBarCode.textProperty().unbindBidirectional(stari.barCodeProperty());
                    fldQuantity.textProperty().unbindBidirectional(stari.quantityProperty());
                }
                if(novi==null){
                    fldBarCode.setText("");
                    fldQuantity.setText("");

                }
                else{
                    NumberStringConverter converter = new NumberStringConverter();

                    fldBarCode.textProperty().bindBidirectional(novi.barCodeProperty());
                    fldQuantity.textProperty().bindBidirectional(novi.quantityProperty(),converter);

                }

            }
        });



        /*listProducts1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selectedProduct = (Product) newValue;
            }
        });*/
    }

    public void btnChangeQ(ActionEvent actionEvent) {
        TextInputDialog txtInput = new TextInputDialog();
        txtInput.setHeaderText("Unesite kolicinu za koju zelite \nsmanjiti trenutnu kolicinu artikla! ");
        txtInput.showAndWait();


        String produkt = String.valueOf(listProducts1.getSelectionModel().getSelectedItem());
        String kolicina = produkt.split(" ")[1];


        //kolicina proizvoda              unesena kolicina
        if(Integer.parseInt(kolicina) < Integer.parseInt(txtInput.getEditor().getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Pogresni podaci");
            alert.setContentText("Nije moguce obrisati vecu kolicinu od trenutne kolicine proizvoda");
            alert.showAndWait();

        }

        else {

            deleteProductQuantity(Integer.parseInt(txtInput.getEditor().getText()));
            listProducts1.refresh();
        }


    }

    public void btnAdd(ActionEvent actionEvent) {
        TextInputDialog txtInput = new TextInputDialog();
        txtInput.setHeaderText("Unesite kolicinu koju zelite dodati \nna kolicinu trenutnog artikla! ");
        txtInput.showAndWait();


        String produkt = String.valueOf(listProducts1.getSelectionModel().getSelectedItem());
        String kolicina = produkt.split(" ")[1];

        addProductQuantity(Integer.parseInt(txtInput.getEditor().getText()));
        listProducts1.refresh();



    }


    public void goBackButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) listProducts1.getScene().getWindow();
        zatvori.close();

    }
}
