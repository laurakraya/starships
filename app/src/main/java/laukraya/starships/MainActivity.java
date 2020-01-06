package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import laukraya.starships.post.Post;
import laukraya.starships.post.PostService;
import laukraya.starships.post.RetroFitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextView textViewWelcomeMsg;
    private Button buttonToShipListActivity;
    private EditText editTextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWelcomeMsg = findViewById(R.id.textViewWelcomeMsg);
        buttonToShipListActivity = findViewById(R.id.buttonToShipListActivity);
        editTextId = findViewById(R.id.editTextId);

        buttonToShipListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStarshipPorId(v);
            }
        });
    }

    private void getStarshipPorId(final View view) {

        //progressDialog = new ProgressDialog(this);
        //progressDialog.setMessage("Cargando...");
        //progressDialog.show();

        //fragmentDialog
        //formas de mostrar msj de cargando, puede ser con librería externa

        int idStarship = Integer.parseInt(editTextId.getText().toString());

        PostService postService = RetroFitClient.recuperarRetrofit().create(PostService.class);
        Call<Post> call = postService.starshipPorId(idStarship);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                toStarshipDetailActivity(post);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                //progressDialog.dismiss();
            }
        });



    }

    private void toStarshipDetailActivity(Post post) {
        Intent intentToStarshipDetailActivity = new Intent(this, StarshipDetailActivity.class);
        String name = post.getName();
        intentToStarshipDetailActivity.putExtra("name", name);
        startActivity(intentToStarshipDetailActivity);
    }

}
