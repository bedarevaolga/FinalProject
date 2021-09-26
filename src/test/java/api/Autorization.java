package api;
import api.TokenResponse;
import io.restassured.http.ContentType;
import org.apache.commons.codec.binary.Base64;
//import org.json.JSONObject;

//import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Autorization {
   public static void main(String[] args) throws IOException, URISyntaxException {

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
//        //"https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback").openStream())) {
//
//
        //var response =
        //      given()
        // .accept(ContentType.JSON)
//                        .queryParams("client_id", "04c21be4154148c1a1ab1380500d4df7")
//                        .queryParams("response_type", "code")
//                        .queryParams("redirect_uri", "https://example.com/callback")
//                        .queryParams("scope", "user-read-email user-read-private")
//                .log()
//                .all()
//                        .when()
//                        .get("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback")
//                        //.getBody().asString();
        //   .then()
//                .log()
//                .all()
        //.statusCode(200)
        //     .body("code=")

        //       .toString();
        // .extract().header("Location")
        //        .toString();
        // .path("code");
        //   .jsonPath()
        //   .getMap("code");
        //     System.out.println(response);
//    }
//}


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

           URL obj = new URL(
                "https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email"
        );
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
     //  URL url = new URL("http://www.google.com");
       HttpURLConnection httpCon = (HttpURLConnection) obj.openConnection();

       System.out.println( obj.getQuery());
       System.out.println( obj.getContent());
       System.out.println( obj.getFile());
       System.out.println( obj.getPath());
       System.out.println( obj.getRef());
       System.out.println( obj.getRef());
       System.out.println( obj.toURI());
       System.out.println( obj.toExternalForm());

     //  System.out.println("Response code is " + httpCon.getURL());
     //  System.out.println("Response code is " + httpCon.getResponseMessage());
      // System.out.println("Response code is " + httpCon.getHeaderField());
      // System.out.println("Response code is " + httpCon.getHeaderFieldKey());
      // System.out.println("Response code is " + httpCon.getContentEncoding());
//       System.out.println("Response code is " + httpCon.getContent().toString());
//      // System.out.println("Response code is " + httpCon.getRequestMethod());
//       System.out.println("Response code is " + httpCon.toString());
//      // System.out.println("Response code is " + httpCon.getRequestProperty());
//      // System.out.println("Response code is " + httpCon.getResponseCode());
//       System.out.println("Response code is " + httpCon.getInstanceFollowRedirects());
//       System.out.println("Response code is " + httpCon.getPermission());
//     //  System.out.println("Response code is " + httpCon.getContentLengthLong());
//    //   System.out.println("Response code is " + httpCon.getRequestProperties());
//       System.out.println("Response code is " + httpCon.getUseCaches());
   }
  // public static String getToken() {
//      String token;
//
//        Map<String, String> body = new HashMap<>();
//        body.put("grant_type", "authorization_code");
//        body.put("code", "AQCDF4OHWT5N9AOp6CFILBRgjVKllZT5ZISfV0ZD8FraxrGQ27vX_DczJjMbvWJNBajj9TN14wf005q0Ue83Mx0PV5pnFAE9IVgnyAb-arCalEjFYHnb_6yMXPlKjjOR22zs2gMCvWg2HcJp1w5SOepmWRjpPO098yDRgeHPjsnhca-gbDUmegHHq-MjmzTm2N7n0iotUYlHgSOTvq2_GJIltQ4");
//        body.put("redirect_uri", "https://example.com/callback");
//
//        TokenResponse tokenResponse =
//       // Map<String, String> respObj=
//                given()
//                .accept(ContentType.JSON)
//                .queryParams(body)
//                .header("Authorization", createBasicAuthHeaderValue())
//                .when()
//                .post("https://accounts.spotify.com/api/token")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .extract()
//              //  .jsonPath()
//               // .getMap("$")
//
//               .as(TokenResponse.class);
//        token = tokenResponse.getAccessToken();
//
//        System.out.println(token);
//   //    return token;
//    }


    static String createBasicAuthHeaderValue() {
        String auth = String.format("%s:%s", "04c21be4154148c1a1ab1380500d4df7",
                "3835dedb5236443c81e2ab7285e8f4cd");
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        return "Basic " + new String(encodedAuth);

    }
}
