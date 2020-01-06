package laukraya.starships.post;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("name")
    private String name;


    public Post() {}

    public Post(String name) {
        this.name = name;
    }

    public String getName() {return  name;}
}
