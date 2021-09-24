package api.steps;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FollowPlayListStep {

    private  String response;

    @And("user is following a PlayList")
    public void followPlayList(String playListID) {

        Map<String, Boolean> body = new HashMap<>();
        body.put("public", false);

        String url = "https://api.spotify.com/v1/playlists/" + playListID + "/followers";
         given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.getToken())
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(200);

    }
    @And("user is Unfollowing a  Playlist")
    public void unfollowPlaylist(String idOFPlayList) {

        String url = "https://api.spotify.com/v1/playlists/" + idOFPlayList + "/followers";

        given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.getToken())
                .when()
                .delete(url)
                .then()
                .statusCode(200);

    }

    @And("get List of PlayLists")
    public void getListOfPlayList() {

        String url = "https://api.spotify.com/v1/me/playlists";
        response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + Config.getToken())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asString();
    }
    @Then("user is finding PlayList from List")
    public void isPlayListAddedToListOfPlayList(String playListName) {
        Assertions.assertTrue(response.contains(playListName));
    }
    @Then("user is checking of removing a  Playlist")
    public void isPlayListDeletedToListOfPlayList(String playListName) {
        Assertions.assertFalse(response.contains(playListName));
    }
}
