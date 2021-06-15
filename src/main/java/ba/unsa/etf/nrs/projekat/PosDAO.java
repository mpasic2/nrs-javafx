package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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



    public ObservableList<User> getUsers() throws IOException {

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


        return useri;
    }

    public User getUserById(int id) throws IOException {
        ObservableList<User> users = getUsers();

        return users.get(id-1);
    }




    public ObservableList<Employee> getEmployees() throws IOException {

        String adresa = "http://localhost:1000/GetEmployees";
        URL url = new URL(adresa);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        String res = sb.toString();

        String[] savRES = res.split("},");
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        for(int i=0;i<savRES.length;i++){
            int id = Integer.parseInt(savRES[i].split(",")[0].split(":")[1].replaceAll("\"",""));
            int userId =  Integer.parseInt(savRES[i].split(",")[1].split(":")[1].replaceAll("\"",""));
            String managerId = savRES[i].split(",")[2].split(":")[1].replaceAll("\"","");
            String hireDate = savRES[i].split(",")[3].replaceAll("\"","");
            String jobTitle =  savRES[i].split(",")[i].split(":")[1].replaceAll("\"","");
            int role = Integer.parseInt(savRES[i].split(",")[5].split(":")[1].replaceAll("\"",""));


            hireDate = hireDate.split(":")[1];
            LocalDate lcd = LocalDate.parse(hireDate.split("T")[0]);


            if(managerId != null && !managerId.equals("") && !managerId.isEmpty() && !managerId.equals("null")) hireDate=hireDate;
            else {
                managerId="0";
            }

            employees.add(new Employee(id,userId,Integer.parseInt(managerId),lcd,jobTitle,role));

        }
        return employees;
    }




    public Employee getEmployeeById(int id) throws IOException {
        ObservableList<Employee> employees = getEmployees();

        return employees.get(id-1);

    }





    public ObservableList<Product> getProducts() throws IOException {

        String adresa = "http://localhost:1000/GetProducts";
        URL url = new URL(adresa);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        String res = sb.toString();


        String[] savRES = res.split("},");

        ObservableList<Product> products = FXCollections.observableArrayList();

        for(int i=0;i<savRES.length;i++){
            int id = Integer.parseInt(savRES[i].split(",")[0].split(":")[1].replaceAll("\"",""));
            String name =  savRES[i].split(",")[1].split(":")[1].replaceAll("\"","");
            int quantity = Integer.parseInt(savRES[i].split(",")[2].split(":")[1].replaceAll("\"",""));
            double price = Double.parseDouble(savRES[i].split(",")[3].split(":")[1].replaceAll("\"",""));
            int category =  Integer.parseInt(savRES[i].split(",")[4].split(":")[1].replaceAll("\"",""));
            double discount = Double.parseDouble(savRES[i].split(",")[5].split(":")[1].replaceAll("\"",""));
            String barCode = savRES[i].split(",")[6].split(":")[1].replaceAll("\"","");

            products.add(new Product(id,name,quantity,price,category,discount,barCode));
        }

        return products;
    }

    public ObservableList<Order> getOrders() throws IOException {

        String adresa = "http://localhost:1000/GetOrders";
        URL url = new URL(adresa);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        String res = sb.toString();


        String[] savRES = res.split("},");

        ObservableList<Order> orders = FXCollections.observableArrayList();

        for(int i=0;i<savRES.length;i++){
            int id = Integer.parseInt(savRES[i].split(",")[0].split(":")[1].replaceAll("\"",""));
            int empId =  Integer.parseInt(savRES[i].split(",")[1].split(":")[1].replaceAll("\"",""));
            int pymntId = Integer.parseInt(savRES[i].split(",")[2].split(":")[1].replaceAll("\"",""));
            String date = savRES[i].split(",")[3].split(":")[1].replaceAll("\"","");
            String status =  savRES[i].split(",")[4].split(":")[1].replaceAll("\"","");

            LocalDate lcd = LocalDate.parse(date.split("T")[0]);

            orders.add(new Order(id,empId,pymntId,lcd,status));
        }

        return orders;
    }

    public ObservableList<Bill> getBills() throws IOException {

        String adresa = "http://localhost:1000/GetBills";
        URL url = new URL(adresa);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        String res = sb.toString();


        String[] savRES = res.split("},");

        ObservableList<Bill> bills = FXCollections.observableArrayList();

        for(int i=0;i<savRES.length;i++){
            int id = Integer.parseInt(savRES[i].split(",")[0].split(":")[1].replaceAll("\"",""));
            int orderId =  Integer.parseInt(savRES[i].split(",")[1].split(":")[1].replaceAll("\"",""));
            double total = Double.parseDouble(savRES[i].split(",")[2].split(":")[1].replaceAll("\"",""));
            int date = Integer.parseInt(savRES[i].split(",")[3].split(":")[1].replaceAll("\"",""));


            bills.add(new Bill(id,orderId,total,date));
        }

        return bills;
    }

    public void addProduct(Product product) throws IOException {
        String url = "http://localhost:1000/AddProduct";
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        String prod = "{\"name\": \"" + product.getName() + "\"quantity\": \""+product.getQuantity() +
                "\"price\": \""+product.getPrice() +"\"categoriyId\": \""+product.getCategory() +
                "\"discount\": \""+product.getDiscount() +"\"barCode\": \""+product.getBarCode() +
                "\"imgUrl\": \""+null +"}";
        byte[] ulaz = prod.getBytes("utf-8");
        out.write(ulaz,0,ulaz.length);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String js = "", line = null;
        while ((line = input.readLine())!=null){
            js=js+line;
        }

        JSONObject res = new JSONObject(js);

    }


    public void addUser(User user) throws IOException {
        String url = "http://localhost:1000/AddUser";
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        String prod = "{\"firstName\": \"" + user.getFirstName() + "\"lastName\": \""+user.getLastName() +
                "\"username\": \""+user.getUsername() +"\"password\": \""+user.getPassword() +
                "\"email\": \""+user.getEmail() +"\"phone\": \""+user.getPhone() +
                "\"address\": \""+user.getAdress()+"\"birthDate\": \""+user.getBirthDate()+"}";
        byte[] ulaz = prod.getBytes("utf-8");
        out.write(ulaz,0,ulaz.length);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String js = "", line = null;
        while ((line = input.readLine())!=null){
            js=js+line;
        }

        JSONObject res = new JSONObject(js);

    }

    public void addCategory(Category category) throws IOException {
        String url = "http://localhost:1000/AddCategory";
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        String prod = "{\"name\": \"" + category.getName() +"}";
        byte[] ulaz = prod.getBytes("utf-8");
        out.write(ulaz,0,ulaz.length);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String js = "", line = null;
        while ((line = input.readLine())!=null){
            js=js+line;
        }

        JSONObject res = new JSONObject(js);

    }

    public void addOrder(Order order) throws IOException {
        String url = "http://localhost:1000/AddOrder";
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        String prod = "{\"employeeId\": \"" + order.getEmployerId() + "\"paymentType\": \""+order.getPaymentType() +
                "\"datetime\": \""+order.getDate() +"\"status\": \""+order.getStatus() +"}";
        byte[] ulaz = prod.getBytes("utf-8");
        out.write(ulaz,0,ulaz.length);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String js = "", line = null;
        while ((line = input.readLine())!=null){
            js=js+line;
        }

        JSONObject res = new JSONObject(js);

    }

    public void addBill(Bill bill) throws IOException {
        String url = "http://localhost:1000/AddBill";
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        String prod = "{\"orderId\": \"" + bill.getOrderId() + "\"total\": \""+bill.getTotal() +
                "\"fiscalNumber\": \""+bill.getFiscalNumber()+"}";
        byte[] ulaz = prod.getBytes("utf-8");
        out.write(ulaz,0,ulaz.length);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String js = "", line = null;
        while ((line = input.readLine())!=null){
            js=js+line;
        }

        JSONObject res = new JSONObject(js);

    }



/*  POGLEDAJ ADDEMPLOYEE... ZADNJI ATRIBUT ROLE PARSA INT A TRAZI EMAIL
    public void addEmployee(Employee employee) throws IOException {
        String url = "http://localhost:1000/AddUser";
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        String prod = "{\"userId\": \"" + employee.getUserId() + "\"managerId\": \""+employee.getManagerId() +
                "\"hireDate\": \""+employee.getHireDate() +"\"jobTitle\": \""+employee.getJobTitle() +
                "\"email\": \""+employee.gete() +"}";
        byte[] ulaz = prod.getBytes("utf-8");
        out.write(ulaz,0,ulaz.length);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String js = "", line = null;
        while ((line = input.readLine())!=null){
            js=js+line;
        }

        JSONObject res = new JSONObject(js);

    }*/




}







