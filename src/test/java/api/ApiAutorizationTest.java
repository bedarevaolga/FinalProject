package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ApiAutorizationTest {

//    public final String TOKEN= "BQByvuQNOZOpJpunX2xDuDFHX8b-_nXYVxAiZdhkgTFxBqyaXXYifJJ6DzQePvmMFJ9ZBTJILwCTE" +
//            "aqERCUtx4iFAHu2LBokASTIAK7y0Oh4yUFlN31EnpRMYO47onRDSLCje3rfMQxumEQQjL4THH0QQOXhdOGn7asvGKKKybbb150qA";


    public void  authorize () throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet tokenRequest = new HttpGet("https://spotify.com"); //??
        URI uri = new URIBuilder(tokenRequest.getURI())
               // .addParameter("token", TOKEN)
                .build();
        ((HttpRequestBase) tokenRequest).setURI(uri);
        HttpResponse response = httpClient.execute(tokenRequest);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);

    }

}