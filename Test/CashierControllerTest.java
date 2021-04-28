import ba.unsa.etf.nrs.projekat.Korisnik;
import ba.unsa.etf.nrs.projekat.Product;
import ba.unsa.etf.nrs.projekat.Uposlenik;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CashierControllerTest {


    @Test
    void testSetiGetLozinkaKorisnik(){
        Korisnik korisnik = new Korisnik("korisnik1","");
        korisnik.setLozinka("lozinka");
        korisnik.setKorisnickoIme("novi");
        assertEquals("novi",korisnik.getKorisnickoIme());
        assertEquals("lozinka",korisnik.getLozinka());
    }

    @Test
    void testSetiGetProduct(){
        Product proizvod = new Product("12345",0);
        proizvod.setSifra("nova_sifra");
        assertEquals("nova_sifra",proizvod.getSifra());
        proizvod.setKolicina(500);
        assertEquals(500,proizvod.getKolicina());
        assertEquals("nova_sifra 500", proizvod.toString());
    }


    @Test
    void testSetiGetUposlenik(){
        Uposlenik uposelnik = new Uposlenik("","","","","","", LocalDate.now(), Uposlenik.Uloga.Administrator);
        uposelnik.setIme("Uposleni");
        uposelnik.setPrezime("Uposlinecki");
        uposelnik.setJMBG("123456789");
        uposelnik.setAdresa("Bihac bb");
        uposelnik.setEmail("up1@gmail.com");
        uposelnik.setBrojMobitela("062062062");
        uposelnik.setDatumZaposlenja(LocalDate.of(2018, 11, 17));
        Uposlenik uposelnik2 = new Uposlenik("Uposleni","Uposlinecki","123456789","Bihac bb","062062062","up1@gmail.com", LocalDate.of(2018, 11, 17), Uposlenik.Uloga.Administrator);
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
