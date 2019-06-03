package auth.requests;

import java.io.Serializable;

public class FollowRequest implements Serializable {
    private String username;
    private String followed;

    public String getUsername() {
        return username;
    }

    public String getFollowed() {
        return followed;
    }

}
