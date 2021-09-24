package api.steps;

//public class LoginStep {
//    Autorization autorization = new Autorization();
//    private  String TOKEN = autorization.getToken();


//    @When("a user is logged in Spotify")
//    public void authorize() throws URISyntaxException, IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet tokenRequest = new HttpGet("https://open.spotify.com/");
//        Autorization autorization = new Autorization();
//         String TOKEN = autorization.getToken();
//        System.out.println(autorization.getToken());
//        URI uri = new URIBuilder(tokenRequest.getURI())
//                .addParameter("token", TOKEN)
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
//
//}


