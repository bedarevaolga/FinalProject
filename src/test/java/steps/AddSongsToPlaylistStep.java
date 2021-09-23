package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import config.Config;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AddSongsToPlaylistStep {

    private String response;
    private String playlist_id = "6c2Bk3NG24pqM7ontU3GDs";


    @And("user is adding  to PlayList songs")
    public void addSongsToPlaylist(List<String> songs) {

        String url = "https://api.spotify.com/v1/playlists/" + playlist_id + "/tracks";
        for (int i = 0; i < songs.size(); i++) {
            //   response =
            given()
                    .accept("application/json")
                    .contentType("application/json")
                    .header("Authorization", "Bearer " + Config.getToken())
                    .queryParam("uris", songs.get(i))
                    .when()
                    .post(url)
                    .then()
                    .statusCode(201);
            //  .extract().response().asString();
            //  System.out.println(response);
        }
        // return response;
    }

    @And("get List of Song from PlayList")
    public String getSongsListFromPlaylist() throws ParseException, JsonProcessingException {
        String url = "https://api.spotify.com/v1/playlists/" + playlist_id + "/tracks";

        response =
                // Map<String, String> respObj =
                given()
                        .accept("application/json")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + Config.getToken())
                        .when()
                        .get(url)
                        .then()
                        .statusCode(200)
                        //.extract()
                        // .body().asString();
//                    .jsonPath()
//                    .getMap("$").toString();
                        .extract().response().asString();
        // System.out.println(response);

        return response;
    }

//List<String> song = new ArrayList<>();
//        //regexp
//
//        Pattern pattern = Pattern.compile("(?<=\\\"is_local\\\" : false,\\n\" +\n" +
//                "//                \"      \\\"name\\\" : \\\")(.+?)(?=\")");
////        Pattern pattern = Pattern.compile(" \"is_local\" : false,\n" +
////                "      \"name\" : \"(.)+(\",)");
//        Matcher match = pattern.matcher(response);
//
//        //if (match.find()) {
//        while (match.find())
//          {
//              song.add(match.group());
//                      //.substring(37));
//          }
//        System.out.println(song);

//        } else {
//            System.out.println("No token");
//        }


// ObjectMapper om = new ObjectMapper();
//Track track = om.readValue(response, Track.class);
////        ObjectMapper mapper = new ObjectMapper();
////        Person person = mapper.readValue(jsonString, Person.class);
////
//       System.out.println(track.getName());
//        for (Track track : track.friends) {
//            System.out.print(friend.lastName);
////            for (Phones phone : friend.phoneNumbers) {
////                System.out.println(" - phone type: " + phone.type + ", phone number : " + phone.number);
////            }
//        }

    public boolean checkSongIsAdedToPlayList(String song) {
        return response.contains(song);
    }

    @Then("user is checking List of Song")
    public void user_is_checking_list_of_song(List<String> songs) {
        for (String song : songs) {
            Assertions.assertTrue(checkSongIsAdedToPlayList(song));
        }
    }
}



