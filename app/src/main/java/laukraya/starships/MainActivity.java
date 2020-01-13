package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import laukraya.starships.swapi.Starship;
import laukraya.starships.swapi.StarshipService;
import laukraya.starships.swapi.RetroFitClient;
import laukraya.starships.swapi.Starships;
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

        Toolbar toolbar = findViewById(R.id.toolbarMain);

        toolbar.setTitle("Starships");
        setSupportActionBar(toolbar);

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

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        StarshipService starshipService = RetroFitClient.recuperarRetrofit().create(StarshipService.class);
        Call<Starships> call = starshipService.starshipList();
        call.enqueue(new Callback<Starships>() {
            @Override
            public void onResponse(Call<Starships> call, Response<Starships> response) {
                List<Starship> starships = response.body().getResults();
                progressDialog.dismiss();
                Log.i("ok", "TODO BIEEEEEEN");
                toStarshipListActivity(starships);

            }

            @Override
            public void onFailure(Call<Starships> call, Throwable t) {
                progressDialog.dismiss();
                Log.i("ERRRRRRRORRRRRR", "ERRORRRRRRR");
            }
        });

    }

    private void toStarshipListActivity(List<Starship> starships) {
        Intent intentToStarshipListActivity = new Intent(this, StarshipListActivity.class);
        if(starships != null) {
            ArrayList<Starship> starshipsAL = (ArrayList<Starship>) starships;
            intentToStarshipListActivity.putExtra("starships", starshipsAL);
        }
        startActivity(intentToStarshipListActivity);
    }

}
