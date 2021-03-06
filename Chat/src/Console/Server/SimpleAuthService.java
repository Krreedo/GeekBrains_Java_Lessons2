package Console.Server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {


    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    List<UserData> users;

    public SimpleAuthService() {
        users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }

    @Override
    public String getAuthData(String login, String password) {
        for (UserData user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.nickname;
            }
        }
        return null;
    }

    @Override
    public boolean registration(String login, String pass, String nick) {
        for (UserData user : users) {
            if (user.login.equals(login) || user.nickname.equals(nick)) {
                return false;
            }
        }
        users.add(new UserData(login , pass, nick ));
        return true;
    }
}
