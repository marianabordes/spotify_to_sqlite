package MODEL;

import com.google.gson.JsonElement;

public class Track {

    private String name;
    private String id;
    private int duration;
    private boolean explicit;


    public Track(JsonElement trackItems) {
        this.name = trackItems.getAsJsonObject().get("name").getAsString();
        this.id = trackItems.getAsJsonObject().get("id").getAsString();
        this.duration = trackItems.getAsJsonObject().get("duration_ms").getAsInt() / 1000;
        this.explicit = trackItems.getAsJsonObject().get("explicit").getAsBoolean();
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public boolean getExplicit() {
        return explicit;
    }



    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", duration=" + duration +
                ", explicit=" + explicit +
                '}';
    }
}
