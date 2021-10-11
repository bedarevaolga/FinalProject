package api.steps;

import configuration.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AddSongsToPlaylistStep {

    private String response;
    private static final Logger log = Logger.getLogger(AddSongsToPlaylistStep.class);

    @When("user is adding  to PlayList songs")
    public void addSongsToPlaylist(List<String> songs) {

        String url = "https://api.spotify.com/v1/playlists/" + Config.PLAY_LIST_ID_FOR_CHANGING + "/tracks";
        for (String song : songs) {
            given()
                    .accept("application/json")
                    .contentType("application/json")
                    .header("Authorization", "Bearer " + Config.TOKEN)
                    .queryParam("uris", song)
                    .when()
                    .post(url)
                    .then()
                    .statusCode(201);
            log.info("song" + song + "is added");
        }
    }

    @And("get List of Song from PlayList")
    public String getSongsListFromPlaylist() {
        String url = "https://api.spotify.com/v1/playlists/" + Config.PLAY_LIST_ID_FOR_CHANGING + "/tracks";

        response =
                given()
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
        log.info("SongsList from Playlist is received ");
        return response;
    }

    public boolean checkSongIsAdedToPlayList(String song) {
        return response.contains(song);
    }

    @Then("user is checking List of Song")
    public void user_is_checking_list_of_song(List<String> songs) {
        for (String song : songs) {
            Assertions.assertTrue(checkSongIsAdedToPlayList(song));
            log.info("Playlist contains Song: " + song);
        }
    }
}



