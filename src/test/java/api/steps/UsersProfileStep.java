package api.steps;

import configuration.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class UsersProfileStep {

    private String response;
    private static final Logger log = Logger.getLogger(UsersProfileStep.class);

    @When("user is getting a User's Profile")
    public String getUserProfile() {

        String url = "https://api.spotify.com/v1/users/" + Config.USER_ID;

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + Config.TOKEN)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .asString();
        log.info("got user info");
        return response;
    }

    public String getDisplayName() {
        JSONObject obj = new JSONObject(response);
        return obj.get("display_name").toString();
    }

    @Then("user is checking User's information")
    public void checkUsersInformation() {
        Assertions.assertEquals(getDisplayName(), (Config.USER_NAME));
        log.info("assertion  checkUsersInformation passed ");
    }
}
