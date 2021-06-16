package ba.unsa.etf.nrs.projekat.Classes;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty quantity;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty category;
    private SimpleDoubleProperty discount;
    private SimpleStringProperty barCode;
    private SimpleStringProperty imgUrl;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price, int category, double discount, String barCode, String imgUrl) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.category = new SimpleIntegerProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.discount = new SimpleDoubleProperty(discount);
        this.barCode = new SimpleStringProperty(barCode);
        this.imgUrl = new SimpleStringProperty(imgUrl);

    }


    public Product(String name, int quantity, double price, int category, double discount, String barCode) {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.category = new SimpleIntegerProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.discount = new SimpleDoubleProperty(discount);
        this.barCode = new SimpleStringProperty(barCode);
    }



    public String getImgUrl() {
        return imgUrl.get();
    }

    public SimpleStringProperty imgUrlProperty() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl.set(imgUrl);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public double getDiscount() {
        return discount.get();
    }

    public SimpleDoubleProperty discountProperty() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount.set(discount);
    }

    public String getBarCode() {
        return barCode.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public SimpleStringProperty barCodeProperty() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode.set(barCode);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getCategory() {
        return category.get();
    }

    public SimpleIntegerProperty categoryProperty() {
        return category;
    }

    public void setCategory(int category) {
        this.category.set(category);
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    @Override
    public String toString() {
        return name.get() +" - "+ barCode.get() + " - " + quantity.get();
    }
}
