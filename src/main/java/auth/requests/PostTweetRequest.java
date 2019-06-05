package auth.requests;

import java.io.Serializable;

public class PostTweetRequest implements Serializable {

    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
