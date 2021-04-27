package ba.unsa.etf.nrs.projekat;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    SimpleStringProperty korisnickoIme;
    SimpleStringProperty lozinka;

    public Korisnik(String korisnickoIme, String lozinka) {
        this.korisnickoIme = new SimpleStringProperty(korisnickoIme);
        this.lozinka = new SimpleStringProperty(lozinka);
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }
}
