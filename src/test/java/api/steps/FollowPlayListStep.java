package api.steps;

import configuration.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FollowPlayListStep {

    private String response;
    private static final Logger log = Logger.getLogger(FollowPlayListStep.class);

    @When("user is following a PlayList")
    public void followPlayList(String playListID) {

        Map<String, Boolean> body = new HashMap<>();
        body.put("public", false);

        String url = "https://api.spotify.com/v1/playlists/" + playListID + "/followers";
        given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.TOKEN)
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(200);
        log.info("user follow playList " + playListID);
    }

    @When("user is Unfollowing a  Playlist")
    public void unfollowPlaylist(String idOfPlayList) {

        String url = "https://api.spotify.com/v1/playlists/" + idOfPlayList + "/followers";

        given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.TOKEN)
                .when()
                .delete(url)
                .then()
                .statusCode(200);
        log.info("user unfollow playList " + idOfPlayList);
    }

    @And("get List of PlayLists")
    public void getListOfPlayList() {

        String url = "https://api.spotify.com/v1/me/playlists";
        response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.TOKEN)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asString();
        log.info("users playLists is received");
    }

    @Then("user is finding PlayList from List")
    public void isPlayListAddedToListOfPlayList(String playListName) {
        Assertions.assertTrue(response.contains(playListName));
        log.info(" assertion isPlayListAddedToListOfPlayList for playList " + playListName + " passed");
    }

    @Then("user is checking of removing a  Playlist")
    public void isPlayListDeletedToListOfPlayList(String playListName) {
        Assertions.assertFalse(response.contains(playListName));
        log.info(" assertion isPlayListAddedToListOfPlayList passed");
    }
}
