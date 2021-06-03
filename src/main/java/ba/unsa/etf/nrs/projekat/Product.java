package ba.unsa.etf.nrs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {

    private SimpleStringProperty naziv;
    private SimpleIntegerProperty kolicina;
    private SimpleIntegerProperty cijena;
    private SimpleIntegerProperty kategorija;
    private SimpleIntegerProperty popust;
    private SimpleStringProperty sifra;

    public Product() {
    }

    public Product(String naziv, int kolicina, int cijena, int kategorija, int popust, String sifra) {
        this.naziv = new SimpleStringProperty(naziv);
        this.kolicina = new SimpleIntegerProperty(kolicina);
        this.cijena = new SimpleIntegerProperty(cijena);
        this.kategorija = new SimpleIntegerProperty(kategorija);
        this.popust = new SimpleIntegerProperty(popust);
        this.sifra = new SimpleStringProperty(sifra);
    }


    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public int getCijena() {
        return cijena.get();
    }

    public SimpleIntegerProperty cijenaProperty() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena.set(cijena);
    }

    public int getKategorija() {
        return kategorija.get();
    }

    public SimpleIntegerProperty kategorijaProperty() {
        return kategorija;
    }

    public void setKategorija(int kategorija) {
        this.kategorija.set(kategorija);
    }

    public int getPopust() {
        return popust.get();
    }

    public SimpleIntegerProperty popustProperty() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust.set(popust);
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
        return naziv.get() +"  "+sifra.get()+"  "+kolicina.get();
    }
}
