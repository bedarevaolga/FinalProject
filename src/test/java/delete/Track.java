package delete;

 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
 import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

 import java.util.Date;
 import java.util.List;

//
// class ExternalUrls{
//    public String spotify;
//}
//
// class AddedBy{
//    public ExternalUrls external_urls;
//    public String href;
//    public String id;
//    public String type;
//    public String uri;
//}
//
// class Artist{
//    public ExternalUrls external_urls;
//    public String href;
//    public String id;
//    public String name;
//    public String type;
//    public String uri;
//}
//
// class Image{
//    public int height;
//    public String url;
//    public int width;
//}
//
// class Album{
//    public String album_type;
//    public List<Artist> artists;
//    public List<String> available_markets;
//    public ExternalUrls external_urls;
//    public String href;
//    public String id;
//    public List<Image> images;
//    public String name;
//    public String release_date;
//    public String release_date_precision;
//    public int total_tracks;
//    public String type;
//    public String uri;
//}
//
//class ExternalIds{
//    public String isrc;
//}
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track{
    @JsonProperty("album")
    private String album;
    @JsonProperty("artists")
    private List<String> artists;
    @JsonProperty("available_markets")
    private List<String> available_markets;
    @JsonProperty("disc_number")
    private int disc_number;
    @JsonProperty("duration_ms")
    private int duration_ms;
    @JsonProperty("episode")
    private boolean episode;
    @JsonProperty("explicit")
    private boolean explicit;
    @JsonProperty("external_ids")
    private String external_ids;
    @JsonProperty("external_urls")
    private String external_urls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("is_local")
    private boolean is_local;
    @JsonProperty("name")
    private String name;
    @JsonProperty("popularity")
    private int popularity;
    @JsonProperty("preview_url")
    private String preview_url;
    @JsonProperty("track")
    private boolean track;
    @JsonProperty("track_number")
    private int track_number;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

    public String getName() {
        return name;
    }
}

// class VideoThumbnail{
//    public Object url;
//}
//
// class Item{
//    public Date added_at;
//    public AddedBy added_by;
//    public boolean is_local;
//    public Object primary_color;
//    public Track track;
//    public VideoThumbnail video_thumbnail;
//}
//  class Root{
//    public String href;
//    public List<Item> items;
//    public int limit;
//    public Object next;
//    public int offset;
//    public Object previous;
//    public int total;
//}
//
