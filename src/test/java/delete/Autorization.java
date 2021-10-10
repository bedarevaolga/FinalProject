package delete;


import io.restassured.http.ContentType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;

import org.apache.http.Header;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;
//import org.json.JSONObject;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.http.HttpRequest;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;


import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Autorization {
   // public static void main(String[] args) {

        //  String url = "https://accounts.spotify.com/authorize";


//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback");
//
//        try {
//            HttpResponse response = client.execute(request);
//
//            HttpEntity entity = response.getEntity();
//
//            // Read the contents of an entity and return it as a String.
//            String content =
//                    EntityUtils.toString(entity);
//            System.out.println(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//    }


//
//        // public void tokenRestAssuredTest() {
//        Map<String, String> params = new HashMap<>();
//        params.put("client_id", "04c21be4154148c1a1ab1380500d4df7");
//        params.put("response_type", "code");
//        params.put("redirect_uri", "https%3A%2F%2Fexample.com%2Fcallback");
//        //  params.put("scope", "user-read-email user-read-private");
//
////        public static String getHTML(String urlToRead) throws Exception {
////            StringBuilder result = new StringBuilder();
////            URL url = new URL(urlToRead);
////            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////            conn.setRequestMethod("GET");
////            try (BufferedReader reader = new BufferedReader(
////                    new InputStreamReader(conn.getInputStream()))) {
////                for (String line; (line = reader.readLine()) != null; ) {
////                    result.append(line);
////                }
////            }
////            return result.toString();
////        }
////
////        public static void main(String[] args) throws Exception
////        {
////            System.out.println(getHTML("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback"));
////        }
////    }
//
//
//        String url =
//                "https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback";
//
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        HttpResponse response = client.execute(httpGet);

//
////            //Instantiate an HttpClient
////            HttpClient client =  HttpClientBuilder.create().build();
////
////            //Instantiate a GET HTTP method
////            GetMethod method = new GetMethod(url);
////            method.setRequestHeader("Content-type",
////                    "text/xml; charset=ISO-8859-1");
//
////
//
//
        //"https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback").openStream())) {
        //   https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%253A%252F%252Fexample.com%252Fcallback&scope=user-read-private%2520user-read-email

        //  var response =


//                given()
//                        .accept(ContentType.JSON)
//                        .contentType(ContentType.JSON)
//                        .queryParams("client_id", "04c21be4154148c1a1ab1380500d4df7")
//                        .queryParams("response_type", "code")
//                        .queryParams("redirect_uri", "https://example.com/callback")
//                        .queryParams("scope", "user-read-email user-read-private")
//                        .log()
//                        .all()
//                        .when()
//                        .get("https://accounts.spotify.com/authorize")
//                        .then()
//                        .log()
//                        .all()
//                        .statusCode(200);
//        //       .extract().body().xmlPath().get().name();
        //   }
//
////                        .toString();
////         .extract().header("Location")
////                .toString();
////         .path("code");
////           .jsonPath()
////                .getMap("code");
//        System.out.println(response);
//
//    }


//        URL urls = new URL("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback");
//        HttpURLConnection httpCon = (HttpURLConnection) urls.openConnection();
//
//
//        System.out.println("Response code is " + httpCon.getURL());


//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback");
//        HttpResponse response = client.execute(httpGet);
//        System.out.println(response.toString());
//       // String responseText = EntityUtils.toString(response.getEntity());
//        client.close();

//        RestAssured.baseURI = "https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback";
//        RequestSpecification request = RestAssured.given();
//
//        JSONObject requestParams = new JSONObject();
////        requestParams.put("FirstName", "Virender"); // Cast
////        requestParams.put("LastName", "Singh");
////        requestParams.put("UserName", "63userf2d3d2011");
////        requestParams.put("Password", "password1");
////        requestParams.put("Email",  "ed26dff39@gmail.com");
//
//        request.body(requestParams.toJSONString());
//        Response response = request.get();
//
//        ResponseBody body = response.getBody();
//
////
////        System.out.println(body.toString());
//        // Deserialize the Response body into RegistrationSuccessResponse
//       RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
//        System.out.println(responseBody);
//    }
//}

//       URL obj =
//             new  URL("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email");
//
//
//       HttpClient client = HttpClient.newHttpClient();
//       HttpRequest request = HttpRequest.newBuilder()
//               .uri(URI.create("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email"))
//               .build();
//       client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//               .thenApply(HttpResponse::body)
//               .thenAccept(System.out::println)
//               .join();
//
//       Request request1 = new Request
//               .Builder()
//               .url("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email")
//               .get()
//               .build();
//


//       OkHttpClient.Builder builder = new OkHttpClient.Builder();
//       builder.followRedirects(true);
//       OkHttpClient httpClient = builder.build();
//

//       //response.headers.get("Location");
//   String response= given()
//       //TokenResponse tokenResponse =
//       // Map<String, String> respObj=
//              //  given()
//                .accept(ContentType.JSON)
//                .when()
//                .get("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .extract().body().xmlPath().get().name();
//              //  .jsonPath()
//               // .getMap("$")
//       System.out.println(response);
////         //       .extract()
        //  .jsonPath()
        // .getMap("$")
//       OkHttpClient client = new OkHttpClient().newBuilder()
//               .followRedirects(true)
//               .followSslRedirects(true)
//               .build();
//       HttpGet httpGet = new HttpGet("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email");
//       HttpResponse response = client.newCall("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email")
//       InputStream stream = obj.openStream();
//       Scanner scan = new Scanner(stream);
//       String data = scan.nextLine();
//       System.out.println(data);
//


//       HttpClient client = HttpClients.createDefault();
//       HttpGet httpGet = new HttpGet("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email");
//       HttpResponse response = client.execute(httpGet);
//
//
//       String responseText = EntityUtils.toString(response.getEntity());
//       client.close();
//       System.out.println(response.uri()); // Your json object
//       System.out.println(response.body().); // Your json object
//       System.out.println(response.headers()); // Your json object
//       System.out.println(response.sslSession()); // Your json object
//       System.out.println(response.version()); // Your json object
//

//        URLConnection conn = obj.openConnection();
//
//        //get all response headers
//        Map<String, List<String>> map = conn.getHeaderFields();
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
//        }
//
////get response body
//        InputStream output = conn.getInputStream();
//        Scanner s = new Scanner(output).useDelimiter("\\A");
//        String result = s.hasNext() ? s.next() : "";
//        System.out.println(result);
//    }
//}


        // public static String getToken() {
//        String token;
//
//        Map<String, String> body = new HashMap<>();
//        body.put("grant_type", "authorization_code");
//        body.put("code", "AQCqsItd4uXRu_iFt0YB9agi5nqUE4UDBmHr2mecSeV8n5PT1F7YqXTvQOhQqgiuLHmA4P0YJFeeH9RBIsX71YNlkyv2YeLEiKpu1Ri_Xo3RjcE1P1flAgw_icBM2R5PjAHr0LKCAePctRTqOd2DepI7ijLtjy4QLxY3Ta_8C5LVOh73hrr9UDER_0Zxz_EzY4eq911OxZtrzebqaiI6Z0E0cQ");
//        body.put("redirect_uri", "http://mysite.com/callback");
//
//        TokenResponse tokenResponse =
//                //  Map<String, String> respObj=
//                given()
//                        .accept(ContentType.JSON)
//                        .queryParams(body)
//                        .header("Authorization", createBasicAuthHeaderValue())
//                        .when()
//                        .post("https://accounts.spotify.com/api/token")
//                        .then()
//                        .assertThat()
//                        .statusCode(HttpStatus.SC_OK)
//                        .extract()
//                        // .jsonPath()
//                        //  .getMap("$");
//
//                        .as(TokenResponse.class);
//        String token = tokenResponse.getAccessToken();
//
//        System.out.println(token);
//        //    return token;
//
//    }

   // https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=http%3A%2F%2Fmysite.com%2Fcallback%2F&scope=user-read-email%20user-read-private
        @Test
    public void tokenRestAssuredTest() {
            Map<String, String> body = new HashMap<>();
        body.put("grant_type", "authorization_code");
        body.put("code", "AQCEs1sRI9KBdi-JlroDiTMfYxZbEOEbrMzfT08jID4iwh0O8XTlxxxeFovQSM7UPxqezf29DJi1XRFLnNRGFZvebosjg4KcLEydbnaw5xcQ8guTAJvN_eDuX3Nu9lQ6ATYlwfQ-MnHT4kYDVLdD1acJYg5zHB_tZlamCo7OotyykVseywLJZ1zrrKnZQbJKWw8TFGsd_to7Fafw9l2Q-Y7sdQ");
        body.put("redirect_uri", "http://mysite.com/callback");
        Map<String, String> respObj = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .header("Authorization", createBasicAuthHeaderValue())
                .queryParams(body)
                .log()
                .all()
                .when()
                .post("https://accounts.spotify.com/api/token")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("$");

        System.out.println(respObj);
    }

    private String createBasicAuthHeaderValue() {
        String auth = String.format("%s:%s", "04c21be4154148c1a1ab1380500d4df7",
                "3835dedb5236443c81e2ab7285e8f4cd");
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        return "Basic " + new String(encodedAuth);
    }
}

