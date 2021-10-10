package delete;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
//import java.net.http.HttpClient;
//import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static io.restassured.RestAssured.given;


public class Delete {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
//        String url = " https://accounts.spotify.com/authorize";
//        String res = given()
//                .queryParams("client_id", "04c21be4154148c1a1ab1380500d4df7")
//                .queryParams("response_type", "code")
//                .queryParams("redirect_uri", "http://mysite.com/callback/")
//                .queryParams("scope", "user-read-email user-read-private")
//                .log()
//                .all()
//                .when()
//                .get(url)
//                .then()
//                .log()
//                .all()
//                .statusCode(200)
//                .extract()
//                .htmlPath()
//                .
//                //.body()
//                .asString();
//
//        System.out.println(res);
        //___________

        URL u = null;
        try {
            u = new URL("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=http%3A%2F%2Fmysite.com%2Fcallback%2F&scope=user-read-email%20user-read-private");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.print(line);

//---------------------------------------------
//        URL urls = new URL("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=http%3A%2F%2Fmysite.com%2Fcallback%2F&scope=user-read-email%20user-read-private");
//        URLConnection con = urls.openConnection();
//        InputStream in = con.getInputStream();
//        String encoding = con.getContentEncoding();
//        encoding = encoding == null ? "UTF-8" : encoding;
//        String body = IOUtils.toString(in, encoding);
//        System.out.println(body);
////---------------------------------------------------------
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpResponse response = httpClient.execute(new HttpGet("https://accounts.spotify.com/authorize?client_id=04c21be4154148c1a1ab1380500d4df7&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback%2F&scope=user-read-email%20user-read-private"));
//        HttpEntity entity = response.getEntity();
//
//        String responseString = EntityUtils.toString(entity, "UTF-8");
//        System.out.println(responseString);

//
//            C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl google.com
//                    <HTML><HEAD><meta http-equiv="content-type" content="text/html;charset=utf-8">
//<TITLE>301 Moved</TITLE></HEAD><BODY>
//<H1>301 Moved</H1>
//                    The document has moved
//                    <A HREF="http://www.google.com/">here</A>.
//</BODY></HTML>
//
//    curl -X "POST" -H "Authorization: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQzYzgxZTJhYjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spotify.com/api/token
//            {"access_token":"BQCjDoBgYbnZDcGfCLaiqa0mNlvg-eRWYjy-zNAGXvuhCnNLKyvPlcbMA4ZiM9Z
//                24MUu1qY4xVJdZjwCVz8","token_type":"Bearer","expires_in":3600}
//
//C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl google.com
//<HTML><HEAD><meta http-equiv="content-type" content="text/html;charset=utf-8">
//<TITLE>301 Moved</TITLE></HEAD><BODY>
//<H1>301 Moved</H1>
//The document has moved
//<A HREF="http://www.google.com/">here</A>.
//</BODY></HTML>
//
//C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl -X "POST" -H "Auth
//orization: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQ
//zYzgxZTJhYjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spo
//tify.com/api/token
//{"access_token":"BQCjDoBgYbnZDcGfCLaiqa0mNlvg-eRWYjy-zNAGXvuhCnNLKyvPlcbMA4ZiM9Z
//24MUu1qY4xVJdZjwCVz8","token_type":"Bearer","expires_in":3600}
//C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>
//
//C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl -X "POST" -H "Auth
//
//curl: no URL specified!
//curl: try 'curl --help' or 'curl --manual' for more information
//
//C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>//            orization
//: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQ
//"//" не является внутренней или внешней
//командой, исполняемой программой или пакетным файлом.
//
//C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>//            zYzgxZTJh
//YjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spo
//"//" не является внутренней или внешней
//командой, исполняемой программой или пакетным файлом.
//

//                    C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl -X "POST" -H "Auth
//            orization: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQ
//            zYzgxZTJhYjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spo
//            tify.com/api/token
//            {"access_token":"BQCjDoBgYbnZDcGfCLaiqa0mNlvg-eRWYjy-zNAGXvuhCnNLKyvPlcbMA4ZiM9Z
//                24MUu1qY4xVJdZjwCVz8","token_type":"Bearer","expires_in":3600}
//                C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>
//
//                    C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl -X "POST" -H "Auth
//
//                curl: no URL specified!
//                    curl: try 'curl --help' or 'curl --manual' for more information
//
//                C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>//            orization
//: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQ
//                "//" не является внутренней или внешней
//                командой, исполняемой программой или пакетным файлом.
//
//                C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>//            zYzgxZTJh
//                    YjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spo
//                "//" не является внутренней или внешней
//                командой, исполняемой программой или пакетным файлом.
//
//                C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>//            tify.com/
//                    api/tokencurl -X "POST" -H "Authorization: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzg
//                wNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQzYzgxZTJhYjcyODVlOGY0Y2Q=" -d grant_type=client_
//                credentials https://accounts.spotify.com/api/token
//                "//" не является внутренней или внешней
//                командой, исполняемой программой или пакетным файлом.
//
//                C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl -X "POST" -H "Auth
//                orization: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQ
//                zYzgxZTJhYjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spo
//                tify.com/api/token
//                {"access_token":"BQAVVBiKEvCGgugfeCdqTrkbUC7P6EqXEt98dM0MKHBdXiidH4QdFnH_J-_XJv0
//                    qDhjnIa3SIFZVk86gdHw","token_type":"Bearer","expires_in":3600}
//                    C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>curl -X "POST" -H "Auth
//                    orization: Basic MDRjMjFiZTQxNTQxNDhjMWExYWIxMzgwNTAwZDRkZjc6MzgzNWRlZGI1MjM2NDQ
//                    zYzgxZTJhYjcyODVlOGY0Y2Q=" -d grant_type=client_credentials https://accounts.spo
//                    tify.com/api/token
//                    {"access_token":"BQC6gY9ndggf7ORe1CBHvmS6uGCD4Hxh8bmcQvkJ4HJr_CCQU0l0F21pjmMkqbanbKyB9TR5SGlukvzLxzg","token_type":"Bearer","expires_in":3600}
//                        C:\curl-7.79.0_1-win64-mingw\curl-7.79.0-win64-mingw\bin>^A
        }
    }
}
