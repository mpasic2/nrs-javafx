package ba.unsa.etf.nrs.projekat.Classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Order {

    SimpleIntegerProperty id;
    SimpleIntegerProperty employerId;
    SimpleIntegerProperty paymentType;
    SimpleObjectProperty<LocalDate> date;
    SimpleStringProperty status;


    public Order(int id, int employerId, int paymentType, LocalDate date, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.employerId = new SimpleIntegerProperty(employerId);
        this.paymentType = new SimpleIntegerProperty(paymentType);
        this.date = new SimpleObjectProperty<LocalDate>(date);
        this.status = new SimpleStringProperty(status);
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "id=" + id.getValue() + ", paymentType=" + paymentType.getValue() + ", date=" + date.getValue() + ", status=" + status.getValue() + "\n";
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

    public int getEmployerId() {
        return employerId.get();
    }

    public SimpleIntegerProperty employerIdProperty() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId.set(employerId);
    }

    public int getPaymentType() {
        return paymentType.get();
    }

    public SimpleIntegerProperty paymentTypeProperty() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType.set(paymentType);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
