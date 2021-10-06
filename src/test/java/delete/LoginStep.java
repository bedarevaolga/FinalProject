package delete;

import config.Config;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.json.XMLTokener.entity;

public class LoginStep {

//    @When("a user is logged in Spotify")
//    public void authorize() throws URISyntaxException, IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet tokenRequest = new HttpGet("https://open.spotify.com/");
//        URI uri = new URIBuilder(tokenRequest.getURI())
//                //  .addParameter("key", KEY)
//                .addParameter("token", Config.getToken())
//                .build();
//        ((HttpRequestBase) tokenRequest).setURI(uri);
//        HttpResponse response = httpClient.execute(tokenRequest);
//      HttpEntity entity = response.getEntity();
//        String responseString = EntityUtils.toString(entity, "UTF-8");
//        System.out.println(responseString);

//    @When("a user is logged in Spotify")
//    public void authorize() throws URISyntaxException, IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet tokenRequest = new HttpGet("https://open.spotify.com/");
//
//
//        URI uri = new URIBuilder(tokenRequest.getURI())
//                .addParameter("token", Config.getToken())
//                .build();
//        tokenRequest.setURI(uri);
//        HttpResponse response = httpClient.execute(tokenRequest);
//        if (response.getStatusLine().getStatusCode() != 200) {
//            throw new RuntimeException("An error code received. Server returned " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
//        }
//
//        String responseString = EntityUtils.toString(response.getEntity());
//        System.out.println(responseString);
//        httpClient.close();
//    }

    }


