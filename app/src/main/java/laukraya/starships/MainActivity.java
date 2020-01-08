package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import laukraya.starships.post.Post;
import laukraya.starships.post.PostService;
import laukraya.starships.post.RetroFitClient;
import laukraya.starships.post.Rsp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextView textViewWelcomeMsg;
    private Button buttonToShipListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWelcomeMsg = findViewById(R.id.textViewWelcomeMsg);
        buttonToShipListActivity = findViewById(R.id.buttonToShipListActivity);

        buttonToShipListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStarships(v);
            }
        });
    }

    private void getStarships(final View view) {
        PostService postService = RetroFitClient.recuperarRetrofit().create(PostService.class);
        Call<Rsp> call = postService.starshipList();
        call.enqueue(new Callback<Rsp>() {
            @Override
            public void onResponse(Call<Rsp> call, Response<Rsp> response) {
                List<Post> posts = response.body().getResults();
                System.out.println(posts);
                toStarshipListActivity(posts);
            }

            @Override
            public void onFailure(Call<Rsp> call, Throwable t) {
                System.out.println(t + "ACÁ");
            }
        });
    }

    private void toStarshipListActivity(List<Post> posts) {
        Intent intentToStarshipListActivity = new Intent(this, StarshipListActivity.class);
        if(posts != null) {
            ArrayList<Post> starshipsAL = (ArrayList<Post>) posts;
            intentToStarshipListActivity.putExtra("posts", starshipsAL);
        }
        startActivity(intentToStarshipListActivity);
    }

}
