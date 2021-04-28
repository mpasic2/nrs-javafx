package ba.unsa.etf.nrs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
    //za pocetnu verziju implemtirane su samo ove osobine klase koje ce se kasnije prosiriti
    private SimpleStringProperty sifra;
    private SimpleIntegerProperty kolicina;


    public Product(String sifra,int kolicina) {
        this.sifra = new SimpleStringProperty(sifra);

        this.kolicina = new SimpleIntegerProperty(kolicina);
    }

    public String getSifra() {
        return sifra.get();
    }

    public int getKolicina() {
        return kolicina.get();
    }

    public SimpleIntegerProperty kolicinaProperty() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina.set(kolicina);
    }

    public SimpleStringProperty sifraProperty() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra.set(sifra);
    }




    @Override
    public String toString() {
        return sifra.get()+" "+kolicina.get();
    }
}
