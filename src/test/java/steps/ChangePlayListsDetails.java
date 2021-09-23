package steps;

import config.Config;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ChangePlayListsDetails {


//
//   private String response;
//    private String playlist_id = "3l1a3QmTfURa9ENjoYd4CF";


    @And("user is Change a Playlist's Name")
    public void addSongsToPlaylist() {

        String url = "https://api.spotify.com/v1/playlists/19Ef9KnmJs7YZMOfNPMak7" ;
                //+ playlist_id;

        Map<String, String> body = new HashMap<>();
        body.put("name", "Updated Playlist Name 321");
        body.put("description", "Updated playlist description");
        body.put("public", "false");


  //  response =
              //   Map<String, String> respObj =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + Config.getToken())
                        .body(body)
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

