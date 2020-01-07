package laukraya.starships.post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rsp {

    @SerializedName("results")
    private List<Post> results;

    public List<Post> getResults() {
        return results;
    }
}
