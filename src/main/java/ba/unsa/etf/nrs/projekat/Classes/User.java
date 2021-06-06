package ba.unsa.etf.nrs.projekat.Classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class User {
    SimpleIntegerProperty id;
    SimpleStringProperty firstName;
    SimpleStringProperty lastName;
    SimpleStringProperty username;
    SimpleStringProperty password;
    SimpleStringProperty email;
    SimpleStringProperty phone;
    SimpleStringProperty adress;

    public User(int id, String firstName, String lastName, String username, String password, String email, String phone, String adress, LocalDate birthDate) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.adress = new SimpleStringProperty(adress);
        this.birthDate = new SimpleObjectProperty<LocalDate>(birthDate);
    }

    SimpleObjectProperty birthDate;

    public User(String korisnickoIme, String lozinka) {
        this.username = new SimpleStringProperty(korisnickoIme);
        this.password = new SimpleStringProperty(lozinka);
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

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getAdress() {
        return adress.get();
    }

    public SimpleStringProperty adressProperty() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public Object getBirthDate() {
        return birthDate.get();
    }

    public SimpleObjectProperty birthDateProperty() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate.set(birthDate);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        return  "firstName=" + firstName.getValue() +
                ", lastName=" + lastName.getValue() +
                ", email=" + email.getValue() +
                ", birthDate=" + birthDate.getValue() + "\n";
    }
}
