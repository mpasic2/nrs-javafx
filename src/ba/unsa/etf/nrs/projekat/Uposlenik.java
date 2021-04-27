package ba.unsa.etf.nrs.projekat;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Uposlenik {

    enum Uloga{Administrator, Skladistar, Kasir}

    SimpleStringProperty ime;
    SimpleStringProperty prezime;
    SimpleStringProperty JMBG;
    SimpleStringProperty adresa;
    SimpleStringProperty brojMobitela;
    SimpleStringProperty email;
    SimpleObjectProperty<LocalDate> datumZaposlenja;
    SimpleObjectProperty<Uloga> uloga;

    public Uposlenik(String ime, String prezime, String JMBG, String adresa, String brojMobitela, String email, LocalDate datumZaposlenja, Uloga uloga) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.JMBG = new SimpleStringProperty(JMBG);
        this.adresa = new SimpleStringProperty(adresa);
        this.brojMobitela = new SimpleStringProperty(brojMobitela);
        this.email = new SimpleStringProperty(email);
        this.datumZaposlenja = new SimpleObjectProperty<LocalDate>(datumZaposlenja);
        this.uloga = new SimpleObjectProperty<Uloga>(uloga);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getJMBG() {
        return JMBG.get();
    }

    public SimpleStringProperty JMBGProperty() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG.set(JMBG);
    }

    public String getAdresa() {
        return adresa.get();
    }

    public SimpleStringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public String getBrojMobitela() {
        return brojMobitela.get();
    }

    public SimpleStringProperty brojMobitelaProperty() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela.set(brojMobitela);
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

    public LocalDate getDatumZaposlenja() {
        return datumZaposlenja.get();
    }

    public SimpleObjectProperty<LocalDate> datumZaposlenjaProperty() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(LocalDate datumZaposlenja) {
        this.datumZaposlenja.set(datumZaposlenja);
    }

    public Uloga getUloga() {
        return uloga.get();
    }

    public SimpleObjectProperty<Uloga> ulogaProperty() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga.set(uloga);
    }
}
