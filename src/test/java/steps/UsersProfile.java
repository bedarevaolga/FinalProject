package steps;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class UsersProfile {

    private String response;

    @And("user is getting a User's Profile")
    public void getUserProfile() {

        String url = "https://api.spotify.com/v1/users/" + Config.USER_ID;

        response = given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + Config.getToken())
                        .when()
                        .get(url)
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();
    }

    @Then("user is checking User's information")
    public void checkUsersInformation() {
        Assertions.assertTrue(response.contains(Config.USER_ID) && response.contains(Config.USER_NAME));
    }
}
