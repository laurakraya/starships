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

    @SerializedName("cost_in_credits")
    private String cost;

    @SerializedName("max_atmosphering_speed")
    private String speed;

    @SerializedName("crew")
    private String crew;

    @SerializedName("passengers")
    private String passengers;

    @SerializedName("cargo_capacity")
    private String cargo;

    @SerializedName("starship_class")
    private String starship_class;


    public Starship() {}

    public Starship(String name, String model, String manufacturer, String cost, String speed, String crew, String passengers, String cargo, String starship_class) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.speed = speed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargo = cargo;
        this.starship_class = starship_class;
    }

    public String getName() {return  name;}

    public String getModel() {return model;}

    public String getManufacturer() {return manufacturer;}

    public String getCost() {return cost;}

    public String getSpeed() {return speed;}

    public String getCrew() {return crew;}

    public String getPassengers() {return passengers;}

    public String getCargo() {return cargo;}

    public String getStarship_class() {return starship_class;}

    @Override
    public String toString() {
        return "Starship{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
