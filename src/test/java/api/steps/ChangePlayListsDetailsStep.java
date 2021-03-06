package api.steps;

import configuration.Config;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ChangePlayListsDetailsStep {

    private static final Logger log = Logger.getLogger(ChangePlayListsDetailsStep.class);

    @When("user is Change a Playlist's Name")
    public void changeNameOfPlayList(String updatedNameOfPlayList) {

        String url = "https://api.spotify.com/v1/playlists/" + Config.PLAY_LIST_ID_FOR_CHANGING;

        Map<String, String> name = new HashMap<>();
        name.put("name", updatedNameOfPlayList);

        Map<String, Boolean> condition = new HashMap<>();
        condition.put("public", false);

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + Config.TOKEN)
                .body(name)
                .params(condition)
                .when()
                .put(url)
                .then()
                .statusCode(200);
       log.info("playList " + Config.PLAY_LIST_ID_FOR_CHANGING + " change name on: " + updatedNameOfPlayList);
    }
}

