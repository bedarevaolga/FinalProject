package api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class ApiAutorizationTest {
    @Test
    public void testLoginRestAssured() {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", "31wkyhvgnyxez4rxsybr7vjbkmdm");
        params.put("response_type", "code");
        params.put("redirect_uri", "https://spotify.com/");
        params.put("grant_type", "authorization_code");


        String token = given().log().all().header("Authorization", "Basic d2ViYXBwOg==").contentType(ContentType.URLENC).formParams(params)
                .post("https://accounts.spotify.com/api/token").then().log().all().assertThat()
                .statusCode(HttpStatus.SC_OK).extract().path("access_token");

        TokenResponse tokenResponse = given()
                .log()
                .all()
                .header("Authorization", "Basic d2ViYXBwOg==")
                .contentType(ContentType.URLENC)
                .formParams(params)
                .post("https://accounts.spotify.com/api/token")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TokenResponse.class);

        System.out.println(tokenResponse.getAccessToken());

         System.out.println("Rest assured extracted token "+token);
    }
}
