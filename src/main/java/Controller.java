import DataBase.*;
import MODEL.*;
import Spotify.SpotifyAccessor;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    public Controller(){};

    public static HashMap<String, String> artists = new HashMap<String, String>(Map.of(
            "Morat", "5C4PDR4LnhZTbVnKWXuDKD",
            "Quevedo", "52iwsT98xCoGgiGntTiR7K",
            "RelsB", "2IMZYfNi21MGqxopj9fWx8",
            "DannnyOcean", "5H1nN1SzW0qNeUEZvuXjAj",
            "CTangana", "5TYxZTjIPqKM8K8NuP9woO"
    ));

    public void setArtists(String artist, String id){
        this.artists.put(artist, id);
    }

    public String getArtistsString(){
        return artists.keySet().toString();
    }

    public  void controller() throws Exception {

        SpotifyAccessor accessor = new SpotifyAccessor();

        Connect dataBaseConnect = new Connect();

        Table tables = new Table();
        tables.createTables();

        for (String artist : artists.keySet()) {

            String artistJson  = accessor.get("/artists/" + artists.get(artist), Map.of());
            JsonObject artistJsonobj = new Gson().fromJson(artistJson, JsonObject.class);

            Artist artist1 = new Artist(artistJsonobj);

            tables.insertArtist(artist1, dataBaseConnect);


            String albumsJson = accessor.get("/artists/" + artists.get(artist) + "/albums", Map.of());

            JsonObject albumsJsonObj = new Gson().fromJson(albumsJson, JsonObject.class);
            JsonArray albumItems = albumsJsonObj.get("items").getAsJsonArray();

            List<Album> albums = new ArrayList<>();

            for (JsonElement albumItem : albumItems) {
                Album album1 = new Album(albumItem);
                albums.add(album1);
                tables.insertAlbum(album1, dataBaseConnect);
            }


            for (Album album : albums) {
                String tracksJson = accessor.get("/albums/" + album.getId() + "/tracks", Map.of());

                JsonObject tracksJsonObj = new Gson().fromJson(tracksJson, JsonObject.class);
                JsonArray tracksItems = tracksJsonObj.get("items").getAsJsonArray();

                for (JsonElement trackItem : tracksItems) {
                    Track track1 = new Track(trackItem);
                    tables.insertTrack(track1,dataBaseConnect);
                }
            }
        }
    }
}
