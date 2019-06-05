package auth.requests;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
