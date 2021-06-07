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

/*    @Test
    void testSetiGetProduct(){
        Category category = new Category(1,"category");
        Product proizvod = new Product("Jabuke",20,2,1,"0",category);
        proizvod.setBarCode("nova_sifra");
        assertEquals("nova_sifra",proizvod.getBarCode());
        proizvod.setQuantity(500);
        assertEquals(500,proizvod.getQuantity());
        assertEquals("Jabuke  nova_sifra  500", proizvod.toString());
    }*/


}
