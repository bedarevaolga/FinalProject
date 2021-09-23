package steps;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
//import static steps.Autorization.getToken;

public class CreatePlayListStep {

    private  String response;
    private  String playListID;

    @And("user is creating new PlayList")
    public String createPlayList() {

        Map<String, String> body = new HashMap<>();
        body.put("name", "Best12");
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
        return response;
    }

    @And("get PlayList ID")
    public String getPlayListID() {
        Pattern pattern = Pattern.compile("https://open.spotify.com/playlist/(.)+\"");
        Matcher match = pattern.matcher(response);
        if (match.find()) {
            playListID=match.group().substring(34, 56);
        } else {
            playListID = null;
        }
        return playListID;
    }

    @Then("playList is created")
    public void assertCreateBoarApi() {
        Assertions.assertNotEquals(null, playListID);
    }
}
