package MODEL;

import com.google.gson.JsonObject;

public class Artist {
    private String id;
    private String name;
    private int popularity;
    private String genres;


    public Artist(JsonObject artistJsonObj) {
        this.id = artistJsonObj.get("id").getAsString();
        this.name = artistJsonObj.get("name").getAsString();
        this.popularity = artistJsonObj.get("popularity").getAsInt();
        this.genres = String.valueOf(artistJsonObj.get("genres").getAsJsonArray());
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getGenres() {
        return genres;
    }



    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", genres='" + genres + '\'' +
                '}';
    }
}
