package Console.Server;

public interface AuthService {
    String getAuthData(String login, String password);

    boolean registration(String login, String pass, String nick);
}
