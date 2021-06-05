package ba.unsa.etf.nrs.projekat;

public class AuthentificationService {
    private static AuthentificationService instance;

    private String token;
    private String username;

    private AuthentificationService() {}

    public static AuthentificationService getInstance() {
        if (instance == null) {
            instance = new AuthentificationService();
        }
        return instance;
    }

    public void setData(String token, String username) {
        this.username = username;
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    public String getUsername() {
        return username;
    }


}
