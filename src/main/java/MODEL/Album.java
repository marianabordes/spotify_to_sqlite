package MODEL;

import com.google.gson.JsonElement;
public class Album {

    private String name;
    private String id;
    private String albumType;
    private int totalTracks;


    public Album(JsonElement albumItems) {
        this.name = albumItems.getAsJsonObject().get("name").getAsString();
        this.id = albumItems.getAsJsonObject().get("id").getAsString();
        this.albumType = albumItems.getAsJsonObject().get("album_type").getAsString();
        this.totalTracks = albumItems.getAsJsonObject().get("total_tracks").getAsInt();
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAlbumType() {
        return albumType;
    }

    public int getTotalTracks() {
        return totalTracks;
    }



    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", albumType='" + albumType + '\'' +
                ", totalTracks=" + totalTracks +
                '}';
    }
}
