package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.Classes.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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


    private PosDAO() {
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            int port = 1000;
//            String dbUsername = "root";
//            String dbPassword = "root";
//            String sqlDialect = "mysql";
//            String host = "localhost";
//            String dbName = "bazakasa";
//            String useSSL = "false";
//
//            String url = "jdbc:" + sqlDialect + "://" + host + ":" + port + "/" + dbName + "?useSSL=" + useSSL;
//            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected String getBaseUri() {
        return bazaurl;
    }

    private JSONArray getJsonArrayFromUrl(URL url) {
        JSONArray jsonArray;
        String json = this.getReaderJsonConnectionData(url);
        if (json == null) return null;
        jsonArray = new JSONArray(json);
        return jsonArray;
    }

    private JSONObject getJsonObjectFromUrl(URL url) {
        JSONObject jsonArray;
        String json = this.getReaderJsonConnectionData(url);
        if (json == null) return null;
        jsonArray = new JSONObject(json);
        return jsonArray;
    }

    private JSONObject getJsonObjectData(String path) {
        URL url = this.getUrl(path);

        return this.getJsonObjectFromUrl(url);
    }


    private JSONArray getJsonArrayData(String path) {
        URL url = this.getUrl(path);

        return this.getJsonArrayFromUrl(url);
    }


    private HttpURLConnection getHttpConnection(URL url, String method) throws IOException {
        HttpURLConnection con = this.getBaseHttpConnection(url, method);
        String basicAuth = "Bearer " + this.authService.getToken();
        con.setRequestProperty ("Authorization", basicAuth);

        return con;
    }

    private String getReaderJsonConnectionData(URL url) {
        try {
            HttpURLConnection con = this.getHttpConnection(url, "GET");
            InputStream in = con.getInputStream();
            return this.getReaderJson(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> result = new ArrayList<>();
        JSONArray jsonArray = getJsonArrayData("products");
        if (jsonArray == null) return null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Category category = getCategory(json.getInt("categoryId"));
            Product product = new Product(json.getInt("id"), json.getString("name"), json.getInt("quantity"),json.getInt("price"),
                                     json.getDouble("discount"),json.getString("barCode"), category);
            result.add(product);
        }
        return result;
    }

    public Product getProduct(int id) {
        Product product;
        JSONObject json = this.getJsonObjectData("products/" + id);
        if (json == null) return null;
        product = new Product(json.getInt("id"), json.getString("name"), json.getInt("quantity"),json.getInt("price"),
                json.getDouble("discount"),json.getString("barCode"), getCategory(json.getInt("categoryId")));
        return product;
    }

    public Category getCategory(int id) {
        Category category = null;
        JSONObject json = this.getJsonObjectData("categories/" + id);
        if (json == null) return null;
        category = new Category(json.getInt("id"), json.getString("name"));
        return category;
    }

    public Category getCategoryByName(String name) {
        Category category;
        JSONObject json = this.getJsonObjectData("categoriesfor/" + name);
        if (json == null) return null;
        category = new Category(json.getInt("id"), json.getString("name"));
        return category;
    }

    public List<Category> getCategories() {
        List<Category> result = new ArrayList<>();
        JSONArray jsonArray = getJsonArrayData("categories");
        if (jsonArray == null) return null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Category category = new Category(json.getInt("id"), json.getString("name"));
            result.add(category);
        }
        return result;
    }

    public ArrayList<Product> getProductsForCategory(Category category) {
        ArrayList<Product> result = new ArrayList<>();
        JSONArray jsonArray = getJsonArrayData("productsfor/" + category.getName());
        if (jsonArray == null) return null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Product product = new Product(json.getInt("id"), json.getString("name"), json.getInt("quantity"),json.getInt("price"),
                    json.getDouble("discount"),json.getString("barCode"), category);

            result.add(product);
        }
        return result;
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> result = new ArrayList<>();

        JSONArray jsonArray = getJsonArrayData("products/" + name);
        if (jsonArray == null) return null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Product prod = getProduct(json.getInt("id"));
            Product product = new Product(json.getInt("id"), json.getString("name"), json.getInt("quantity"),json.getInt("price"),
                    json.getDouble("discount"),json.getString("barCode"), prod.getCategory());

            result.add(product);
        }
        return result;
    }

    public User getUser(int id) {
        JSONArray jsonArray = getJsonArrayData("users/" + id);
        if (jsonArray == null) return null;
        User user = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            LocalDate date = LocalDate.parse(json.getString("birthDate"), dateFormatter);
            user = new User(json.getInt("id"), json.getString("firstName"), json.getString("lastName"), json.getString("username"),
                    json.getString("password"), json.getString("email"), json.getString("phone"), json.getString("address"),
                    date);
        }
        return user;
    }

    public User getUserByUsername(String username) {
        JSONObject json = this.getJsonObjectData("usersfor/" + username);
        if (json == null) return null;
        User user;
        LocalDate date = LocalDate.parse(json.getString("birthDate"), dateFormatter);
        user = new User(json.getInt("id"), json.getString("firstName"), json.getString("lastName"), json.getString("username"),
                json.getString("password"), json.getString("email"), json.getString("phone"), json.getString("address"),
                date);
        return user;
    }


    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        JSONArray jsonArray = getJsonArrayData("users");
        if (jsonArray == null) return null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            LocalDate date = LocalDate.parse(json.getString("birthDate"), dateFormatter);
            User  user = new User(json.getInt("id"), json.getString("firstName"), json.getString("lastName"), json.getString("username"),
                    json.getString("password"), json.getString("email"), json.getString("phone"), json.getString("address"),
                    date);
            result.add(user);
        }
        return result;
    }





}
