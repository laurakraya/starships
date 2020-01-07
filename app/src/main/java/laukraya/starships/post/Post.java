package laukraya.starships.post;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("manufacturer")
    private String manufacturer;


    public Post() {}

    public Post(String name, String model, String manufacturer) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public String getName() {return  name;}

    public String getModel() {return model;}

    public String getManufacturer() {return manufacturer;}

}
