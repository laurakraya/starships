package laukraya.starships.swapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Starship implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("manufacturer")
    private String manufacturer;


    public Starship() {}

    public Starship(String name, String model, String manufacturer) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public String getName() {return  name;}

    public String getModel() {return model;}

    public String getManufacturer() {return manufacturer;}

    @Override
    public String toString() {
        return "Starship{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
