package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.Classes.Employee;
import ba.unsa.etf.nrs.projekat.Classes.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CashierControllerTest {


    @Test
    void testSetiGetLozinkaKorisnik(){
        User korisnik = new User("korisnik1","");
        korisnik.setPassword("lozinka");
        korisnik.setUsername("novi");
        assertEquals("novi",korisnik.getUsername());
        assertEquals("lozinka",korisnik.getPassword());
    }

    @Test
    void testSetiGetProduct(){
        Category category = new Category(1,"category");
        Product proizvod = new Product("Jabuke",20,2,1,"0",category);
        proizvod.setBarCode("nova_sifra");
        assertEquals("nova_sifra",proizvod.getBarCode());
        proizvod.setQuantity(500);
        assertEquals(500,proizvod.getQuantity());
        assertEquals("Jabuke  nova_sifra  500", proizvod.toString());
    }


    @Test
    void testSetiGetUposlenik(){
        Employee uposelnik = new Employee("","","","","","", LocalDate.now(), Employee.Uloga.Administrator);
        uposelnik.setIme("Uposleni");
        uposelnik.setPrezime("Uposlinecki");
        uposelnik.setJMBG("123456789");
        uposelnik.setAdresa("Bihac bb");
        uposelnik.setEmail("up1@gmail.com");
        uposelnik.setBrojMobitela("062062062");
        uposelnik.setDatumZaposlenja(LocalDate.of(2018, 11, 17));
        Employee uposelnik2 = new Employee("Uposleni","Uposlinecki","123456789","Bihac bb","062062062","up1@gmail.com", LocalDate.of(2018, 11, 17), Employee.Uloga.Administrator);
        boolean tacno=false;
        if(uposelnik.getIme().equals(uposelnik2.getIme())) tacno=true;
        if(uposelnik.getPrezime().equals(uposelnik2.getPrezime())) tacno=true;
        if(uposelnik.getEmail().equals(uposelnik2.getEmail())) tacno=true;
        if(uposelnik.getJMBG().equals(uposelnik2.getJMBG())) tacno=true;
        if(uposelnik.getBrojMobitela().equals(uposelnik2.getBrojMobitela())) tacno=true;
        if(uposelnik.getAdresa().equals(uposelnik2.getAdresa())) tacno=true;
        if(uposelnik.getUloga().equals(uposelnik2.getUloga())) tacno=true;
        if(uposelnik.getDatumZaposlenja().equals(uposelnik2.getDatumZaposlenja())) tacno=true;
        assertTrue(tacno);

    }

}
