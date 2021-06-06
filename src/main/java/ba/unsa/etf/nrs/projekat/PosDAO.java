package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import ba.unsa.etf.nrs.projekat.Classes.Employee;
import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.Classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.converter.LocalDateStringConverter;
import jdk.nashorn.internal.parser.Parser;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PosDAO extends BaseDAO{
    private static Connection conn;
    private AuthentificationService authService;
    private static PosDAO instance;
    private static final String bazaurl = "http://34.65.74.184:1000/";
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);

    public static PosDAO getInstance() {
        if (instance == null) instance = new PosDAO();
        return instance;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    protected String getBaseUri() {
        return bazaurl;
    }



    public String dajUsere() throws IOException, ParseException {

        String adresa = "http://localhost:1000/GetUsers";
        URL url = new URL(adresa);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        String res = sb.toString();

        String[] savRES = res.split("},");
        ObservableList<User> useri = FXCollections.observableArrayList();
        for(int i=0;i<savRES.length;i++){
            int id = Integer.parseInt(savRES[i].split(",")[0].split(":")[1].replaceAll("\"",""));
            String name =  savRES[i].split(",")[1].split(":")[1].replaceAll("\"","");
            String lastname = savRES[i].split(",")[2].split(":")[1].replaceAll("\"","");
            String username = savRES[i].split(",")[3].split(":")[1].replaceAll("\"","");
            String pass =  savRES[i].split(",")[4].split(":")[1].replaceAll("\"","");
            String email = savRES[i].split(",")[5].split(":")[1].replaceAll("\"","");
            String phone = savRES[i].split(",")[6].split(":")[1].replaceAll("\"","");
            String address = savRES[i].split(",")[7].split(":")[1].replaceAll("\"","");
            String birthdate = savRES[i].split(",")[8].split(":")[1].replaceAll("\"","");
            birthdate = birthdate.split("T")[0];

            User usr = new User(id,name,lastname,username,pass,email,phone,address,LocalDate.parse(birthdate));
            useri.add(usr);
        }


            /*System.out.println("ovo je id: " + savRES[i].split(":")[1].replaceAll("\"",""));
            System.out.println("ovo je name: "+ savRES[i+1].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je lastnae: "+ savRES[i+2].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je username: "+ savRES[i+3].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je password: "+ savRES[i+4].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je email: "+ savRES[i+5].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je phone: "+ savRES[i+6].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je addnress: "+ savRES[i+7].split(":\"")[1].replaceAll("\"",""));
            System.out.println("ovo je birthdate: "+ savRES[i+8].split(":\"")[1].replaceAll("\"",""));*/
            System.out.println(useri);
        //}



        return res;
    }


    public String dajZaposlene() throws IOException {

        String adresa = "http://localhost:1000/GetEmployees";
        URL url = new URL(adresa);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext())
            sb.append(sc.next());
        String res = sb.toString();


        System.out.println(res);
        String[] savRES = res.split("},");

        /*System.out.println("ovo je id: " + savRES[0].split(":")[1].replaceAll("\"",""));
        System.out.println("ovo je name: "+ savRES[1].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je lastnae: "+ savRES[2].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je username: "+ savRES[3].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je password: "+ savRES[4].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je email: "+ savRES[5].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je phone: "+ savRES[6].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je addnress: "+ savRES[7].split(":\"")[1].replaceAll("\"",""));
        System.out.println("ovo je birthdate: "+ savRES[8].split(":\"")[1].replaceAll("\"",""));*/

        return res;
    }








}
