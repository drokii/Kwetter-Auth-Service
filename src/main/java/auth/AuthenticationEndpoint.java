package auth;

import auth.requests.LoginRequest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/authentication")
public class AuthenticationEndpoint {

    @Inject
    private TokenHelper tokenHelper;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(LoginRequest loginRequest) {

        try {

            String token = issueToken(Integer.parseInt(authenticate(loginRequest.getUsername(), loginRequest.getPassword())));
            return Response.ok(token).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private String authenticate(String username, String password) throws Exception {
        System.out.println(password);
        System.out.println(username);
        HttpResponse<String> authRequest = Unirest.post("http://localhost:8080/kwetter/rest/user/login")
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .body("{\n" +
                        "  \"username\":\"" + username + "\",\n" +
                        "  \"password\":\"" + password + "\"\n" +
                        "}")
                .asString();
        if(authRequest.getBody().equals("Bad Credentials.")){
            throw new Exception();
        }
        return authRequest.getBody();
    }

    private String issueToken(int id) {
        return tokenHelper.createJWT(UUID.randomUUID().toString(), "kwetter", String.valueOf(id), 1000000);
    }
}