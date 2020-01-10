package laukraya.starships.swapi;

import retrofit2.*;
import retrofit2.http.*;

public interface StarshipService {

    @GET("starships")
        Call<Starships> starshipList();

}
