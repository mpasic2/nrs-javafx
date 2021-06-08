package ba.unsa.etf.nrs.projekat.Classes;

import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Employee {

    public enum Uloga{Administrator, Skladistar, Kasir}

    SimpleIntegerProperty id;
    SimpleIntegerProperty userId;
    SimpleIntegerProperty managerId;
    SimpleObjectProperty<LocalDate> hireDate;
    SimpleStringProperty jobTitle;
    SimpleIntegerProperty role;
    public PosDAO baza = new PosDAO();


   /* public Employee(String ime, String prezime, String JMBG, String adresa, String brojMobitela, String email, LocalDate datumZaposlenja, Uloga uloga) {
        this.ime = new SimpleIntegerPropertyProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.JMBG = new SimpleStringProperty(JMBG);
        this.adresa = new SimpleStringProperty(adresa);
        this.brojMobitela = new SimpleStringProperty(brojMobitela);
        this.email = new SimpleStringProperty(email);
        this.datumZaposlenja = new SimpleObjectProperty<LocalDate>(datumZaposlenja);
        this.uloga = new SimpleObjectProperty<Uloga>(uloga);
    }*/

    public Employee(int id, int userId, int managerId, LocalDate hireDate, String jobTitle, int role) {
        this.id = new SimpleIntegerProperty(id);
        this.userId =  new SimpleIntegerProperty(userId);
        this.managerId =  new SimpleIntegerProperty(managerId);
        this.hireDate = new SimpleObjectProperty<LocalDate>(hireDate);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        this.role =  new SimpleIntegerProperty(role);
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

    public int getUserId() {
        return userId.get();
    }

    public SimpleIntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public int getManagerId() {
        return managerId.get();
    }

    public SimpleIntegerProperty managerIdProperty() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId.set(managerId);
    }

    public LocalDate getHireDate() {
        return hireDate.get();
    }

    public SimpleObjectProperty<LocalDate> hireDateProperty() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate.set(hireDate);
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public SimpleStringProperty jobTitleProperty() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public int getRole() {
        return role.get();
    }

    public SimpleIntegerProperty roleProperty() {
        return role;
    }

    public void setRole(int role) {
        this.role.set(role);
    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", userId=" + userId +
                ", managerId=" + managerId +
                ", hireDate=" + hireDate +
                ", jobTitle=" + jobTitle +
                ", role=" + role +
                '}'+ "\n";
    }


}
