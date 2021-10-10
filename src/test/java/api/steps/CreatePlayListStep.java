package api.steps;

import configuration.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;


public class CreatePlayListStep {

    private String response;
    private String playListID;
    private static final Logger log = Logger.getLogger(CreatePlayListStep.class);

    @When("user is creating new PlayList")
    public String createPlayList() {

        Map<String, String> body = new HashMap<>();
        body.put("name", "BestPlaylist");
        body.put("description", "New playlist description");
        body.put("public", "false");

        String url = "https://api.spotify.com/v1/users/vr1i2zt2s6d8z0kokb0oovlxg/playlists";
        response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.getToken())
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(201)
                .extract()
                .response()
                .asString();
        log.info("playList is created");
        return response;
    }

    @And("get PlayList ID")
    public String getPlayListID() {
        Pattern pattern = Pattern.compile("https://open.spotify.com/playlist/(.)+\"");
        Matcher match = pattern.matcher(response);
        if (match.find()) {
            playListID = match.group().substring(34, 56);
        } else {
            playListID = null;
        }
        log.info("playListID is " + playListID);
        return playListID;
    }

    @Then("playList is created")
    public void checkIsPlayListCreated() {
        Assertions.assertNotEquals(null, playListID);
        log.info("Assertion checkIsPlayListCreated passed");
    }
}
