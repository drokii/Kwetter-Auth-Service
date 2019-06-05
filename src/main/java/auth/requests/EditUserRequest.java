package auth.requests;

import java.io.Serializable;

public class EditUserRequest implements Serializable {

    private String username;
    private String desiredUsername;
    private String bio;
    private String location;
    private String website;

    public String getUsername() {
        return username;
    }

    public String getDesiredUsername() {
        return desiredUsername;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }
}
