package api.steps;

import config.Config;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ChangePlayListsDetailsStep {

    @And("user is Change a Playlist's Name")
    public void addSongsToPlaylist(String updatedNameOfPlayList) {

        String url = "https://api.spotify.com/v1/playlists/" + Config.playListIDforChanging();

        Map<String, String> body = new HashMap<>();
        body.put("name", updatedNameOfPlayList);

        Map<String, Boolean> body2 = new HashMap<>();
        body2.put("public", false);

  //  response =
              //   Map<String, String> respObj =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + Config.getToken())
                        .body(body)
                        .params(body2)
                        .when()
                        .put(url)
                        .then()
                        .statusCode(200);
                        //.extract();
                        // .body().asString();
                //    .jsonPath()
               //    .getMap("$");
                        //.toString();
    //                  .extract().response().asString();
     //    System.out.println(response);

       // return response;
    }

}

