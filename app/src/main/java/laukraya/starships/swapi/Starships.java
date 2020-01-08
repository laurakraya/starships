package laukraya.starships.swapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Starships {

    @SerializedName("results")
    private List<Starship> results;

    public List<Starship> getResults() {
        return results;
    }
}
