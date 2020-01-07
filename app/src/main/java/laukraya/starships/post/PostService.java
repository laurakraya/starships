package laukraya.starships.post;

import java.util.*;
import retrofit2.*;
import retrofit2.http.*;

public interface PostService {

    @GET("starships/{id}")
         Call<Post> starshipPorId(@Path("id") int id);

    @GET("starships")
        Call<Rsp> starshipList();

}
